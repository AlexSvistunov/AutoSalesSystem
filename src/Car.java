class Car {
    private String type;

    private String brand;
    private String model;
    private boolean isSold;
    private Buyer buyer;

    public Car(String type, String brand, String model) {
        this.type = type;
        this.model = model;
        this.brand = brand;
        this.isSold = false;
        this.buyer = null;
    }

    public String getType() {
        return type;
    }

    public String getModel() {
        return model;
    }

    public String getBrand() {
        return brand;
    }

    public boolean isSold() {
        return isSold;
    }

    public void sellTo(Buyer buyer) {
        this.buyer = buyer;
        this.isSold = true;
    }

    public Buyer getBuyer() {
        return buyer;
    }

    @Override
    public String toString() {
        return "Car{" +
                "type='" + type + '\'' +
                ", model='" + model + '\'' +
                ", brand='" + brand + '\'' +
                ", isSold=" + isSold +
                ", buyer=" + buyer +
                '}';
    }
}