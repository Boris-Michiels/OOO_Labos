package States;

import domain.Product;

import java.io.Serializable;

public class Available implements State, Serializable {
    private Product product;

    public Available(Product product) {
        this.product = product;
    }

    @Override
    public void removeProduct() {
        product.setProductState(product.getRemovedState());
    }

    @Override
    public void rentProduct() {
        product.setProductState(product.getRentedState());
    }

    @Override
    public void returnProduct(boolean damaged) {
        throw new IllegalStateException("Product was not rented out");
    }

    @Override
    public void repairProduct() {
        throw new IllegalStateException("Product is not damaged");
    }
}
