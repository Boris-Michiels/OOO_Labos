package domain;

import domain.*;
import ui.*;

public class CodingFacade {
    CodingContext codingContext;

    public CodingFacade() {
        getCodingContext();
    }

    public CodingContext getCodingContext() {
        if (codingContext == null) this.codingContext = new CodingContext();
        return codingContext;
    }

    public void setCodingStrategy(String strategy) {
        codingContext.setCodingStrategy(CodingStrategyFactory.createCodingStrategy(strategy));
    }

    public void setCaesarNumber(String number) {
        codingContext.setCaesarNumber(number);
    }

    public int getCaesarNumber() {
        return codingContext.getCaesarNumber();
    }

    public String getText() {
        return codingContext.getText();
    }

    public void setText(String text) {
        codingContext.setText(text);
    }

    public String encode() {
        return codingContext.encode();
    }

    public String decode() {
        return codingContext.decode();
    }
}
