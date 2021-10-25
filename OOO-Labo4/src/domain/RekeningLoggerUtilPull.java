package domain;

import java.util.Observable;
import java.util.Observer;

public class RekeningLoggerUtilPull implements Observer {
    BankUtilPull bankUtilPull;


    public RekeningLoggerUtilPull(Observable o) {
        o.addObserver(this);
        bankUtilPull = (BankUtilPull) o;
    }

    @Override
    public void update(Observable o, Object arg) {
        display();
    }

    private void display() {
        String string = "REKENINGLOGGER; Rekeningnummer: " +
                bankUtilPull.getRekeningDb().getLastAddedRekening().getRekeningNummer() +
                " - Totaal aantal rekeningen: " +
                bankUtilPull.getRekeningDb().getSize();
        System.out.println(string);
    }
}
