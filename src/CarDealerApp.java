public class CarDealerApp {
    public static void main(String[] args) {
        Car car1 = new Car("легковая", "Opel", "Astra");
        Buyer buyer1 = new Buyer("AlexSvistunov", 19, 'M');

        CarDealer carDealer1 = new CarDealer();
        carDealer1.addCar("легковая", "Audi", "R8");
        carDealer1.addCar(car1);
        carDealer1.showAvailableCars();
        carDealer1.sellCar(0, "Tom", 55, 'M');
        carDealer1.showAvailableCars();
        carDealer1.showSales();


    }
}
