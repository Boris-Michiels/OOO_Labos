package domain;

public class CodingStrategyFactory {
    public static CodingStrategy createCodingStrategy(String name, Object... args) {
        CodingStrategy codingStrategy = null;

        CodingAlgorithm codingAlgorithm = CodingAlgorithm.valueOf(name);
        try {
            codingStrategy = (CodingStrategy) Class.forName(codingAlgorithm.getClassName()).getConstructor().newInstance();
        } catch (Exception e) {

        }

        return codingStrategy;
    }
}
