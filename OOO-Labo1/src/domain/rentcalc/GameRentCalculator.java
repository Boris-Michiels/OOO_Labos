package domain.rentcalc;

public class GameRentCalculator implements RentCalculator {
    @Override
    public double getPrice(int days) {
        return days * 3;
    }
}
