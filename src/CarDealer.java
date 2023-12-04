import java.util.ArrayList;
import java.util.Date;
import java.util.List;

class CarDealer {
    private List<Car> carsInStock;
    private List<Sale> sales;

    public CarDealer() {
        this.carsInStock = new ArrayList<>();
        this.sales = new ArrayList<>();
    }

    public void addCar(Car car) {
        carsInStock.add(car);
    }

    public void sellCar(Car car, Customer customer) {
        if (!car.isSold()) {
            car.toSell(true);

            // В реальном приложении нужно создать нового покупателя только если его нет в системе
            // Также следует учесть дату продажи

            sales.add(new Sale(car, customer, new Date()));

            carsInStock.remove(car);
        } else {
            System.out.println("Ошибка: Автомобиль уже продан.");
        }
    }

    public void editCarInformation(Car car, String model, String brand) {
        car.setModel(model);
        car.setBrand(brand);
    }

    public void editCustomerInformation(Customer customer, String fullName, int age, String gender) {
        customer.setFullName(fullName);
        customer.setAge(age);
        customer.setGender(gender);
    }

    public void viewAllCars() {
        for (Car car : carsInStock) {
            System.out.println("Type: " + car.getType() + ", Model: " + car.getModel() +
                    ", Brand: " + car.getBrand() + ", Status: " + (car.isSold() ? "Sold" : "Available"));
        }
    }

    public void viewSalesTable() {
        for (Sale sale : sales) {
            System.out.println("Car: " + sale.getCar().getModel() + " - " + sale.getCar().getBrand() +
                    ", Customer: " + sale.getCustomer().getFullName() + ", Sale Date: " + sale.getSaleDate());
        }
    }
}