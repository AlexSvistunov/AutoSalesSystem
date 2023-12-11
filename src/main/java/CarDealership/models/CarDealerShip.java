package CarDealership.models;

import CarDealership.Connector.MySqlConnector;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

class CarDealership {
    private List<Car> cars;
    private List<Buyer> buyers;

    public CarDealership() {
        this.cars = new ArrayList<>();
        this.buyers = new ArrayList<>();
    }

    public void addCar(Car car) {
        cars.add(car);
        // Добавление в базу данных
        try (Connection connection = MySqlConnector.getConnection()) {
            String carQuery = "INSERT INTO cars (type, model, brand, sold, buyer_id) VALUES (?, ?, ?, ?, ?)";
            try (PreparedStatement carStatement = connection.prepareStatement(carQuery, Statement.RETURN_GENERATED_KEYS)) {
                carStatement.setString(1, car.getType());
                carStatement.setString(2, car.getModel());
                carStatement.setString(3, car.getBrand());
                carStatement.setBoolean(4, car.isSold());
                carStatement.setObject(5, null); // buyer_id, пока машина не продана
                carStatement.executeUpdate();

                // Получение сгенерированного ключа (id) для машины
                ResultSet generatedKeys = carStatement.getGeneratedKeys();
                if (generatedKeys.next()) {
                    int carId = generatedKeys.getInt(1);
                    car.setId(carId);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void sellCar(int carId, Buyer buyer) {
        for (Car car : cars) {
            if (car.getId() == carId && !car.isSold()) {
                car.setSold(true);
                car.setBuyer(buyer);
                buyers.add(buyer);
                // Обновление базы данных
                try (Connection connection = MySqlConnector.getConnection()) {
                    String carQuery = "UPDATE cars SET sold = true, buyer_id = ? WHERE id = ?";
                    try (PreparedStatement carStatement = connection.prepareStatement(carQuery)) {
                        carStatement.setInt(1, buyer.getId());
                        carStatement.setInt(2, carId);
                        carStatement.executeUpdate();
                    }
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                return;
            }
        }
        System.out.println("Car with ID " + carId + " not found or already sold.");
    }


    public void editCarInformation(int carId, String type, String model, String brand) {
        for (Car car : cars) {
            if (car.getId() == carId) {
                car.setType(type);
                car.setModel(model);
                car.setBrand(brand);
                // Обновление базы данных
                try (Connection connection = MySqlConnector.getConnection()) {
                    String query = "UPDATE cars SET type = ?, model = ?, brand = ? WHERE id = ?";
                    try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
                        preparedStatement.setString(1, type);
                        preparedStatement.setString(2, model);
                        preparedStatement.setString(3, brand);
                        preparedStatement.setInt(4, carId);
                        preparedStatement.executeUpdate();
                    }
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                return;
            }
        }
        System.out.println("Car with ID " + carId + " not found.");
    }

    public void editBuyerInformation(String fullName, int age, String gender) {
        for (Buyer buyer : buyers) {
            if (buyer.getFullName().equals(fullName)) {
                buyer.setAge(age);
                buyer.setGender(gender);
                // Обновление базы данных
                try (Connection connection = MySqlConnector.getConnection()) {
                    String query = "UPDATE buyers SET age = ?, gender = ? WHERE full_name = ?";
                    try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
                        preparedStatement.setInt(1, age);
                        preparedStatement.setString(2, gender);
                        preparedStatement.setString(3, fullName);
                        preparedStatement.executeUpdate();
                    }
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                return;
            }
        }
        System.out.println("Buyer with name " + fullName + " not found.");
    }

    public void displayAllCars() {
        for (Car car : cars) {
            System.out.println(car);
        }
    }

    public void displaySalesTable() {
        for (Car car : cars) {
            if (car.isSold()) {
                System.out.println("Sold car: " + car + " - Buyer: " + car.getBuyer());
            }
        }
    }

    public static void main(String[] args) {
        Car car1 = new Car("легковая", "Гранта", "Лада");
        Buyer buyer1 = new Buyer("Символоков Пашок", 22, "М");
        CarDealership carDealership1 = new CarDealership();
        carDealership1.addCar(car1);
    }

}