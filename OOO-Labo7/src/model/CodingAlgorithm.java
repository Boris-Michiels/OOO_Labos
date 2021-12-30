package model;

public enum CodingAlgorithm {
    CAESAR ("Caesar", "model.codingStrategy.CaesarCoding"),
    MIRROR ("Mirror", "model.codingStrategy.MirrorCoding"),
    RANDOM_CYPHER ("Random Cypher", "model.codingStrategy.RandomCypherAdapter");

    private final String naam, className;

    CodingAlgorithm(String naam, String className) {
        this.naam = naam;
        this.className = className;
    }

    public String getNaam() {
        return naam;
    }

    public String getClassName() {
        return className;
    }

    @Override
    public String toString() {
        return this.getNaam();
    }
}
