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
        int count = getProductMap().values().size();
        p.setId(Integer.toString(count + 1));
        db.addProduct(p);
    }

    public Product getProduct(String id) {
        return db.getProduct(id);
    }

    public List<Product> getProducts() {
        return db.getProducts().stream().sorted(new ProductComparator()).collect(Collectors.toList());
    }

    public Map<String, Product> getProductMap() {
        return db.getProductMap();
    }

    public void setProductMap(Map<String, Product> map) {
        db.setProductMap(map);
    }

    public Double getPrice(String id, int days) {
        return getProduct(id).getPrice(days);
    }

    public void toggleAvailable(String id) {
        getProduct(id).toggleAvailable();
    }

    public void close() {
        db.storeProducts(name);
    }
}
