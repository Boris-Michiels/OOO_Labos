package domain.rentcalc;

public class MovieRentCalculator implements RentCalculator {
    @Override
    public double getPrice(int days) {
        double price = 5;
        if (days <= 3) return price;
        else return price + (days - 3) * 2;
    }
}
