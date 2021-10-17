package domain;

import domain.rentcalc.CDRentCalculator;

public class CD extends Product {
    public CD(String title , String id) {
        super(title,id);
        setRentCalculator(new CDRentCalculator());
    }

    public CD(String title) {
        super(title);
        setRentCalculator(new CDRentCalculator());
    }
}
