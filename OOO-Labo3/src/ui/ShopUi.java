package ui;

import domain.*;

import javax.swing.*;

public class ShopUi {
    private Shop shop;
    private String menu;

    public ShopUi() {
        shop = new Shop("Shop 1");
        menu = "1. Add product\n2. Remove product\n3. Rent product\n4. Return product\n5. Repair product\n6. Show available products\n\n0. Quit";
    }

    public void ShowMenu() {
        int choice = -1;
        while (choice != 0) {
            String choiceString = JOptionPane.showInputDialog(menu);
            choice = Integer.parseInt(choiceString);
            switch (choice) {
                case 1:
                    addProduct(shop);
                    break;
                case 2:
                    removeProduct(shop);
                    break;
                case 3:
                    rentProduct(shop);
                    break;
                case 4:
                    returnProduct(shop);
                    break;
                case 5:
                    repairProduct(shop);
                    break;
                case 6:
                    showAvailableProducts(shop);
            }
        }
        shop.close();
    }

    private void repairProduct(Shop shop) {
        String id = JOptionPane.showInputDialog("Enter the id:");
        try {
            shop.repairProduct(Integer.parseInt(id));
            JOptionPane.showMessageDialog(null, "Product repaired");
        } catch (IllegalStateException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }

    private void rentProduct(Shop shop) {
        String id = JOptionPane.showInputDialog("Enter the id:");
        try {
            shop.rentProduct(Integer.parseInt(id));
            JOptionPane.showMessageDialog(null, "Price is: €" + shop.getPrice(Integer.parseInt(id)));
        } catch (IllegalStateException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }

    private void returnProduct(Shop shop) {
        String id = JOptionPane.showInputDialog("Enter the id:");
        try {
            if (!shop.getProduct(Integer.parseInt(id)).getProductState().getClass().getSimpleName().equals("Rented"))
                shop.returnProduct(Integer.parseInt(id), false);
            int damaged = JOptionPane.showConfirmDialog(null, "Is the product damaged?");
            if (damaged == 0) {
                shop.returnProduct(Integer.parseInt(id), true);
                JOptionPane.showMessageDialog(null, "Product is damaged. Customer needs to pay damages.\nCost: €" + shop.getDamagedPrice(Integer.parseInt(id)));
            }
            if (damaged == 1) {
                shop.returnProduct(Integer.parseInt(id), false);
                JOptionPane.showMessageDialog(null, "Product returned");
            }
        } catch (IllegalStateException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }

    public void addProduct(Shop shop) {
        String title = JOptionPane.showInputDialog("Enter the title:");
        double price = Double.parseDouble(JOptionPane.showInputDialog("Enter the price:"));
        Product p = new PartyItem(title, price);
        try {
            shop.addProduct(p);
            JOptionPane.showMessageDialog(null, "Product added:\n" + p);
        } catch (IllegalStateException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }

    public void removeProduct(Shop shop) {
        String id = JOptionPane.showInputDialog("Enter the id:");
        try {
            shop.removeProduct(Integer.parseInt(id));
            JOptionPane.showMessageDialog(null, "Product removed");
        } catch (IllegalStateException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }

    public void showAvailableProducts(Shop shop) {
        StringBuilder products = new StringBuilder();
        for (Product p : shop.getAvailableProducts()) {
            products.append(p).append("\n");
        }
        JOptionPane.showMessageDialog(null, products.toString());
    }
}
