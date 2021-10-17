package domain;

import db.ProductDb;

import java.util.*;
import java.util.stream.Collectors;

public class Shop {
    private String name;
    private ProductDb db;

    public Shop(String name) {
        setName(name);
        db = new ProductDb();
        db.loadProducts(name);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void addProduct(Product p) {
        p.setId(db.getFirstUnusedKey());
        db.addProduct(p);
    }

    public Product getProduct(int id) {
        return db.getProduct(id);
    }

    public List<Product> getAvailableProducts() {
        return db.getAvailableProducts();
    }

    public Map<Integer, Product> getProductMap() {
        return db.getProductMap();
    }

    public void setProductMap(Map<Integer, Product> map) {
        db.setProductMap(map);
    }

    public double getPrice(int id) {
        return getProduct(id).getPrice() / 5;
    }

    public double getDamagedPrice(int id) {
        return getProduct(id).getPrice() / 3;
    }

    public void close() {
        db.storeProducts(name);
    }

    public void repairProduct(int id) {
        db.getProduct(id).repairProduct();
    }

    public void rentProduct(int id) {
        db.getProduct(id).rentProduct();
    }

    public void returnProduct(int id, boolean damaged) {
        db.getProduct(id).returnProduct(damaged);
    }

    public void removeProduct(int id) {
        db.getProduct(id).removeProduct();
    }
}
