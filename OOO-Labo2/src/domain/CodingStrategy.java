package domain;

public interface CodingStrategy {
    String encode(String text);
    String decode(String text);
}
