package States;

public interface State {
    void removeProduct();
    void rentProduct();
    void returnProduct(boolean damaged);
    void repairProduct();
}
