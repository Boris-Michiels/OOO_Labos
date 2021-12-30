package model;

import java.util.ArrayList;
import java.util.List;

public class CodingFacade implements CodingSubject {
    CodingContext codingContext;
    List<CodingObserver> codingObserverList;

    public CodingFacade() {
        codingObserverList = new ArrayList<>();
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

    @Override
    public void addObserver(CodingObserver o) {
        codingObserverList.add(o);
    }

    @Override
    public void removeObserver(CodingObserver o) {
        codingObserverList.remove(o);
    }

    @Override
    public void notifyObservers() {
        for (CodingObserver o : codingObserverList) {
            o.update();
        }
    }
}
