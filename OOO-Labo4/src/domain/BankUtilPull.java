package domain;

import db.RekeningDb;

import java.util.Observable;

public class BankUtilPull extends Observable {
    private RekeningDb rekeningDb;


    public BankUtilPull() {
        this.rekeningDb = RekeningDb.getInstance();
    }

    public RekeningDb getRekeningDb() {
        return rekeningDb;
    }

    public void addRekening(Rekening rekening) {
        rekeningDb.addRekening(rekening);
        setChanged();
        notifyObservers();
    }
}
