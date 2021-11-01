package domain;

public class RandomCyperAdapter implements CodingStrategy {
    private RandomCypher randomCypher;


    public RandomCyperAdapter(RandomCypher randomCypher) {
        this.randomCypher = randomCypher;
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
