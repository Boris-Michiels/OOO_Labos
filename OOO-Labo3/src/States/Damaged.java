package States;

import domain.Product;

import java.io.Serializable;

public class Damaged implements State, Serializable {
    private Product product;

    public Damaged(Product product) {
        this.product = product;
    }

    @Override
    public void removeProduct() {
        product.setProductState(product.getRemovedState());
    }

    @Override
    public void rentProduct() {
        throw new IllegalStateException("Product is damaged and cannot be rented out");
    }

    @Override
    public void returnProduct(boolean damaged) {
        throw new IllegalStateException("Product was not rented out");
    }

    @Override
    public void repairProduct() {
        product.setProductState(product.getAvailableState());
    }
}
