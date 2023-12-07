public class AutoSalonApp {
    public static void main(String[] args) {
        CarDealer dealer = new CarDealer();

        dealer.addCar("passenger", "Civic", "Honda");
        dealer.addCar("truck", "F-150", "Ford");
        dealer.addCar("passenger", "Camry", "Toyota");

        dealer.showAvailableCars();

        dealer.sellCar(0, "John Doe", 30, 'M');
        dealer.sellCar(1, "Jane Doe", 25, 'F');

        dealer.showSales();
    }
}