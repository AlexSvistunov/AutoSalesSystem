import java.util.Date;

class Sale {
    private Car car;
    private Customer customer;
    private Date saleDate;

    public Sale(Car car, Customer customer, Date saleDate) {
        this.car = car;
        this.customer = customer;
        this.saleDate = saleDate;
    }

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Date getSaleDate() {
        return saleDate;
    }

    public void setSaleDate(Date saleDate) {
        this.saleDate = saleDate;
    }
}