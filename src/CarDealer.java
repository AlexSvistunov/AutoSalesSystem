import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class CarDealer {
    private List<Car> cars;
    private Map<Car, Buyer> sales;

    public CarDealer() {
        this.cars = new ArrayList<>();
        this.sales = new HashMap<>();
    }

    public void addCar(String type, String brand, String model) {
        Car car = new Car(type, brand, model);
        cars.add(car);
    }

    public void addCar(Car car) {
        cars.add(car);
    }


    public void showAvailableCars() {
        System.out.println("Available Cars:");
        for (Car car : cars) {
            if (!car.isSold()) {
                System.out.println(car);
            }
        }
    }

    public void sellCar(int carIndex, String buyerName, int buyerAge, char buyerGender) {
        if (carIndex >= 0 && carIndex < cars.size()) {
            Car car = cars.get(carIndex);
            if (!car.isSold()) {
                Buyer buyer = new Buyer(buyerName, buyerAge, buyerGender);
                car.sellTo(buyer);
                sales.put(car, buyer);
                cars.remove(carIndex);
                System.out.println("Car sold to " + buyerName);
            } else {
                System.out.println("Car is already sold.");
            }
        } else {
            System.out.println("Invalid car index.");
        }
    }

    public void showSales() {
        System.out.println("Sales History:");
        for (Map.Entry<Car, Buyer> entry : sales.entrySet()) {
            Car car = entry.getKey();
            Buyer buyer = entry.getValue();
            System.out.println(car + " - " + buyer);
        }
    }
}