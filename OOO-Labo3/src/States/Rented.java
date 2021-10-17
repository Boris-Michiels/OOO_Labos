package States;

import domain.Product;

import java.io.Serializable;

public class Rented implements State, Serializable {
    private Product product;

    public Rented(Product product) {
        this.product = product;
    }

    @Override
    public void removeProduct() {
        throw new IllegalStateException("Product is rented out");
    }

    @Override
    public void rentProduct() {
        throw new IllegalStateException("Product is already rented out");
    }

    @Override
    public void returnProduct(boolean damaged) {
        if (damaged) product.setProductState(product.getDamagedState());
        else product.setProductState(product.getAvailableState());
    }

    @Override
    public void repairProduct() {
        throw new IllegalStateException("Product is rented out");
    }
}
