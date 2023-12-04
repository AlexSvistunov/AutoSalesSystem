class Car {
    private String type;
    private String model;
    private String brand;
    private boolean isSold;

    public Car(String type, String model, String brand, boolean isSold) {
        this.type = type;
        this.model = model;
        this.brand = brand;
        this.isSold = isSold;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public boolean isSold() {
        return isSold;
    }

    public void toSell(boolean sold) {
        isSold = sold;
    }
}