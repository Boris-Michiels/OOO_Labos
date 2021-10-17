package domain.rentcalc;

import java.io.Serializable;

public interface RentCalculator extends Serializable {
    double getPrice(int days);
}
