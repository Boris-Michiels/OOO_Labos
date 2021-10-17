package db;

import States.Available;
import domain.Product;

import java.io.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class ProductDb {
    private Map<Integer, Product> products;

    public ProductDb() {
        this.products = new HashMap<>();
    }

    public void addProduct(Product p) {
        this.products.put(p.getId(), p);
    }

    public Product getProduct(int id) {
        return products.get(id);
    }

    public List<Product> getAvailableProducts() {
        return products.values().stream().filter(e -> e.getProductState().getClass() == Available.class).collect(Collectors.toList());
    }

    public Map<Integer, Product> getProductMap() {
        return products;
    }

    public void setProductMap(Map<Integer, Product> map) {
        this.products = map;
    }

    public int getFirstUnusedKey() {
        Set<Integer> ints = products.keySet();
        for (int i = 1; i <= ints.size() + 1; i++) {
            if (!ints.contains(i)) return i;
        }
        return -1;
    }

    public void loadProducts(String name) {
        try {
            FileInputStream fis = new FileInputStream(name + ".txt");
            ObjectInputStream ois = new ObjectInputStream(fis);
            Map<Integer, Product> map = (Map<Integer, Product>) ois.readObject();
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
