package domain;

import domain.rentcalc.GameRentCalculator;

public class Game extends Product {
    public Game(String title, String id) {
        super(title, id);
        setRentCalculator(new GameRentCalculator());
    }

    public Game(String title) {
        super(title);
        setRentCalculator(new GameRentCalculator());
    }
}
