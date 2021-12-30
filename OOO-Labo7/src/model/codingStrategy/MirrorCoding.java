package model.codingStrategy;

import model.CodingStrategy;

public class MirrorCoding implements CodingStrategy {
    @Override
    public String encode(String text) {
        return mirror(text);
    }

    @Override
    public String decode(String text) {
        return mirror(text);
    }

    private String mirror(String text) {
        return new StringBuilder(text).reverse().toString();
    }

    @Override
    public String toString() {
        return "Mirror";
    }
}
