package domain;

import db.RekeningDb;

import java.util.Observable;

public class BankUtilPush extends Observable {
    private RekeningDb rekeningDb;


    public BankUtilPush() {
        this.rekeningDb = RekeningDb.getInstance();
    }

    public RekeningDb getRekeningDb() {
        return rekeningDb;
    }

    public void addRekening(Rekening rekening) {
        rekeningDb.addRekening(rekening);
        setChanged();
        notifyObservers(this);
    }
}
