package States;

import domain.Product;

import java.io.Serializable;

public class Removed implements State, Serializable {
    private Product product;

    public Removed(Product product) {
        this.product = product;
    }

    @Override
    public void removeProduct() {
        throw new IllegalStateException("Product already removed");
    }

    @Override
    public void rentProduct() {
        throw new IllegalStateException("Product already removed");
    }

    @Override
    public void returnProduct(boolean damaged) {
        throw new IllegalStateException("Product already removed");
    }

    @Override
    public void repairProduct() {
        throw new IllegalStateException("Product already removed");
    }
}
