package domain;

public class CodingContext {
    private CodingStrategy codingStrategy;
    private String text;

    public String encode() {
        return codingStrategy.encode(text);
    }

    public String decode() {
        return codingStrategy.decode(text);
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public int getCaesarNumber() {
        return ((CaesarCoding) codingStrategy).getCaesarNumber();
    }

    public void setCaesarNumber(int caesarNumber) {
        ((CaesarCoding) codingStrategy).setCaesarNumber(caesarNumber);
    }

    public void setCaesarNumber(String caesarNumber) {
        if (caesarNumber != null && !caesarNumber.trim().isEmpty())
            ((CaesarCoding) codingStrategy).setCaesarNumber(Integer.parseInt(caesarNumber));
    }

    public CodingStrategy getCodingStrategy() {
        return codingStrategy;
    }

    public void setCodingStrategy(CodingStrategy codingStrategy) {
        this.codingStrategy = codingStrategy;
    }
}
