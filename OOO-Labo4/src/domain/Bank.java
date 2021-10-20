package domain;

import db.RekeningDb;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Bank implements Subject {
    private HashMap<BankEvent, List<Observer>> observers;
    private RekeningDb rekeningDb;


    public Bank() {
        this.observers = new HashMap<>();
        for (BankEvent event : BankEvent.values()) {
            observers.put(event, new ArrayList<>());
        }
        this.rekeningDb = RekeningDb.getInstance();
    }

    public void addRekening(Rekening rekening) {
        rekeningDb.addRekening(rekening);
        notifyObservers(BankEvent.REKENING_OPENED);
    }

    public RekeningDb getRekeningDb() {
        return rekeningDb;
    }

    @Override
    public void addObserver(BankEvent e, Observer o) {
        observers.get(e).add(o);
    }

    @Override
    public void removeObserver(Observer o) {
        observers.remove(o);
    }

    @Override
    public void notifyObservers(BankEvent e) {
        for (Observer o : observers.get(e)) {
            o.update();
        }
    }
}
