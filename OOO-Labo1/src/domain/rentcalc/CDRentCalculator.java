package domain.rentcalc;

public class CDRentCalculator implements RentCalculator {
    @Override
    public double getPrice(int days) {
        return 1.5 * days;
    }
}
