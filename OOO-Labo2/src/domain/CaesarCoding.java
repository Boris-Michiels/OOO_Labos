package domain;

public class CaesarCoding implements CodingStrategy {
    private int caesarNumber = 1;
    private final String alphabet = "abcdefghijklmnopqrstuvwxyz";

    @Override
    public String encode(String text) {
        return caesar(text, true);
    }

    @Override
    public String decode(String text) {
        return caesar(text, false);
    }

    private String caesar(String text, boolean encode) {
        String caesar = "";
        int caesarNumber = (encode ? 1 : -1) * this.caesarNumber;
        for (char c : text.toLowerCase().toCharArray()) {
            if (alphabet.contains(Character.toString(c))) {
                caesar += alphabet.charAt((alphabet.indexOf(c) + 26 + caesarNumber) % 26);
            } else caesar += c;
        }
        return caesar;
    }

    public void setCaesarNumber(int caesarNumber){
        this.caesarNumber = caesarNumber;
    }

    public int getCaesarNumber() {
        return this.caesarNumber;
    }

    @Override
    public String toString() {
        return "Caesar";
    }
}
