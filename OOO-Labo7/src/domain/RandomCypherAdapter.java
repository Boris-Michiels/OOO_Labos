package domain;

public class RandomCypherAdapter implements CodingStrategy {
    private RandomCypher randomCypher;


    public RandomCypherAdapter() {
        this.randomCypher = new RandomCypher();
    }

    @Override
    public String encode(String text) {
        return String.valueOf(randomCypher.encypher(text.toCharArray()));
    }

    @Override
    public String decode(String text) {
        return String.valueOf(randomCypher.decypher(text.toCharArray()));
    }

    @Override
    public String toString() {
        return "Random Cypher";
    }
}
