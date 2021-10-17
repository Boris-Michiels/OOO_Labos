package domain;

import States.*;
import States.State;

import java.io.Serializable;

public abstract class Product implements Serializable {
    private int id;
    private String title;
    private String description = "";
    private double price;
    private State availableState, damagedState, removedState, rentedState;
    private State productState;


    public Product(String title, double price) {
        setTitle(title);
        setPrice(price);
        availableState = new Available(this);
        damagedState = new Damaged(this);
        removedState = new Removed(this);
        rentedState = new Rented(this);
        setProductState(this.availableState);
    }

    public int getId() {
        return id;
    }

    protected void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    protected void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void removeProduct() {
        productState.removeProduct();
    }

    public void rentProduct() {
        productState.rentProduct();
    }

    public void returnProduct(boolean damaged) {
        productState.returnProduct(damaged);
    }

    public void repairProduct() {
        productState.repairProduct();
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public State getProductState() {
        return productState;
    }

    public void setProductState(State productState) {
        this.productState = productState;
    }

    public State getAvailableState() {
        return availableState;
    }

    public State getDamagedState() {
        return damagedState;
    }

    public State getRemovedState() {
        return removedState;
    }

    public State getRentedState() {
        return rentedState;
    }

    @Override
    public String toString() {
        StringBuilder products = new StringBuilder();
        products.append("  Title: ").append(getTitle()).append("  Id: ").append(getId()).append("  Description: ").append(getDescription()).append(" Price: ").append(getPrice());
        return products.toString();
    }
}
