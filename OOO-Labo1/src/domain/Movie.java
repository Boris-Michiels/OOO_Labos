package domain;

import domain.rentcalc.MovieRentCalculator;

public class Movie extends Product {
    public Movie(String title, String id) {
        super(title, id);
        setRentCalculator(new MovieRentCalculator());
    }

    public Movie(String title) {
        super(title);
        setRentCalculator(new MovieRentCalculator());
    }
}
