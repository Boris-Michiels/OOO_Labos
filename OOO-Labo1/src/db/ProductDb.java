package db;

import domain.Product;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ProductDb {
    private Map<String, Product> products;

    public ProductDb() {
        this.products = new HashMap<>();
    }

    public void addProduct(Product p) {
        this.products.put(p.getId(), p);
    }

    public Product getProduct(String id) {
        return products.get(id);
    }

    public List<Product> getProducts() {
        return new ArrayList<>(products.values());
    }

    public Map<String, Product> getProductMap() {
        return products;
    }

    public void setProductMap(Map<String, Product> map) {
        this.products = map;
    }

    public void loadProducts(String name) {
        try {
            FileInputStream fis = new FileInputStream(name + ".txt");
            ObjectInputStream ois = new ObjectInputStream(fis);
            Map<String, Product> map = (Map<String, Product>) ois.readObject();
            ois.close();
            setProductMap(map);
        } catch (FileNotFoundException ignored) {

        } catch (IOException | ClassNotFoundException e) {
            System.out.println(e);
        }
    }

    public void storeProducts(String name) {
        try {
            FileOutputStream fos = new FileOutputStream(name + ".txt");
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(getProductMap());
            oos.close();
        } catch (IOException e) {
            System.out.println(e);
        }
    }
}
