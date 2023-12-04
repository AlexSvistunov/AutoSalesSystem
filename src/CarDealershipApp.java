public class CarDealershipApp {
    public static void main(String[] args) {
        CarDealer carDealer = new CarDealer();

        Car car1 = new Car("Легковой", "Sedan", "Toyota", false); //мне кажется не надо это в конструктор, конечно, она не продана
        Car car2 = new Car("Грузовой", "Truck", "Ford", false);
        Car car3 = new Car("Легковой", "Sedan", "Lada", false);

        Customer customer1 = new Customer("Иванов Иван Иванович", 30, "М");
        Customer customer2 = new Customer("Петров Петр Петрович", 35, "М");

        carDealer.addCar(car1);
        carDealer.addCar(car2);
        carDealer.addCar(car3);

        carDealer.viewAllCars();

        carDealer.sellCar(car1, customer1);
        carDealer.sellCar(car2, customer2);

        carDealer.viewSalesTable();
        carDealer.viewAllCars();
    }
}