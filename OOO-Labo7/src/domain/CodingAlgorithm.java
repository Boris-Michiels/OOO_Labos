package domain;

public enum CodingAlgorithm {
    CAESAR ("Caesar", "domain.CaesarCoding"),
    MIRROR ("Mirror", "domain.MirrorCoding"),
    RANDOM_CYPHER ("Random Cypher", "domain.RandomCypherAdapter");

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
