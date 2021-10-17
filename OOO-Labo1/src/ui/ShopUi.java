package ui;

import domain.*;

import javax.swing.*;

public class ShopUi {
    private Shop shop;
    private String menu;

    public ShopUi() {
        shop = new Shop("Shop 1");
        menu = "1. Add product\n2. Show product\n3. Show all products\n4. Show rental price\n\n0. Quit";
    }

    public void ShowMenu() {
        int choice = -1;
        while (choice != 0) {
            String choiceString = JOptionPane.showInputDialog(menu);
            choice = Integer.parseInt(choiceString);
            if (choice == 1) {
                addProduct(shop);
            } else if (choice == 2) {
                showProduct(shop);
            } else if (choice == 3) {
                showProducts(shop);
            } else if (choice == 4) {
                showPrice(shop);
            }
        }
        shop.close();
    }

    public void addProduct(Shop shop) {
        String typeMenu = "1. Movie\n2. Game\n3. Cd\n\n0. Cancel";
        String typeString = JOptionPane.showInputDialog(typeMenu);
        int typeChoice = Integer.parseInt(typeString);
        if (typeChoice <= 0 || typeChoice > 3) return;
        String title = JOptionPane.showInputDialog("Enter the title:");
        Product p = null;

        if (typeChoice == 1) {
            p = new Movie(title);
        } else if (typeChoice == 2) {
            p = new Game(title);
        } else if (typeChoice == 3) {
            p = new CD(title);
        }
        shop.addProduct(p);
    }

    public void showProduct(Shop shop) {
        String id = JOptionPane.showInputDialog("Enter the id:");
        showProduct(shop, id);
    }

    public void showProduct(Shop shop, String id) {
        Product p = shop.getProduct(id);
        String toggleString = JOptionPane.showInputDialog(null, "Title: " + p.getTitle() + "\nCategory: " + p.getClass().getSimpleName() +
                "\nDescription: " + p.getDescription() + "\nAvailable: " + (p.isAvailable() ? "Yes" : "No") + "\n\n1. Toggle availability" +
                "\n\n0. Back");
        try {
            int toggle = Integer.parseInt(toggleString);
            if (toggle == 1) {
                shop.toggleAvailable(id);
                showProduct(shop, id);
            }
        } catch (NumberFormatException ignored) {

        }
    }

    public void showProducts(Shop shop) {
        StringBuilder products = new StringBuilder();
        for (Product p : shop.getProducts()) {
            products.append(p).append("\n");
        }
        JOptionPane.showMessageDialog(null, products.toString());
    }

    public void showPrice(Shop shop) {
        String id = JOptionPane.showInputDialog("Enter the id:");
        String daysString = JOptionPane.showInputDialog("Enter the number of days:");
        int days = Integer.parseInt(daysString);
        JOptionPane.showMessageDialog(null, shop.getProduct(id) + "\n\n" + shop.getPrice(id, days));
    }
}
