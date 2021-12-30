package model;

import model.codingStrategy.CaesarCoding;

import java.util.ArrayList;
import java.util.List;

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

    public List<String> getCodingLijst(){
        List <String> codingLijst = new ArrayList<String>();
        for (CodingAlgorithm coding : CodingAlgorithm.values()){
            codingLijst.add(coding.toString());
        }
        return codingLijst;
    }
}
