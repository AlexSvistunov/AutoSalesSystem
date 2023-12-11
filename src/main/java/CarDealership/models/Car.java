package CarDealership.models;

import java.util.ArrayList;
import java.util.List;

// Класс автомобиля
public class Car {
    private int id;
    private String type;
    private String model;
    private String brand;
    private boolean sold;
    private Buyer buyer;

    public Car(String type, String model, String brand) {
        this.type = type;
        this.model = model;
        this.brand = brand;
        this.sold = false;
        this.buyer = null;
    }

    // Геттеры и сеттеры

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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
        return sold;
    }

    public void setSold(boolean sold) {
        this.sold = sold;
    }

    public Buyer getBuyer() {
        return buyer;
    }

    public void setBuyer(Buyer buyer) {
        this.buyer = buyer;
    }

    // Метод toString
    @Override
    public String toString() {
        return "Car{" +
                "id=" + id +
                ", type='" + type + '\'' +
                ", model='" + model + '\'' +
                ", brand='" + brand + '\'' +
                ", sold=" + sold +
                ", buyer=" + buyer +
                '}';
    }
}