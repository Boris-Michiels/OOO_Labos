package domain;

import java.util.Observable;
import java.util.Observer;

public class RekeningLoggerUtilPush implements Observer {
    private Rekening laatsteRekening;
    private int size;


    public RekeningLoggerUtilPush(Observable o) {
        o.addObserver(this);
    }

    @Override
    public void update(Observable o, Object arg) {
        laatsteRekening = ((BankUtilPush) o).getRekeningDb().getLastAddedRekening();
        size = ((BankUtilPush) o).getRekeningDb().getSize();
        display();
    }

    private void display() {
        String string = "REKENINGLOGGER; Rekeningnummer: " +
                laatsteRekening.getRekeningNummer() +
                " - Totaal aantal rekeningen: " +
                size;
        System.out.println(string);
    }
}
