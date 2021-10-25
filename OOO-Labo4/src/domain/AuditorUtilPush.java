package domain;

import java.util.Observable;
import java.util.Observer;

public class AuditorUtilPush implements Observer {
    private Rekening laatsteRekening;


    public AuditorUtilPush(Observable o) {
        o.addObserver(this);
    }

    @Override
    public void update(Observable o, Object arg) {
        laatsteRekening = ((BankUtilPush) o).getRekeningDb().getLastAddedRekening();
        display();
    }

    private void display() {
        String string = "Nieuwe rekening geopend op datum " +
                laatsteRekening.getCreationDate() +
                " met rekeningnummer " +
                laatsteRekening.getRekeningNummer() +
                " en saldo " +
                laatsteRekening.getSaldo();
        System.out.println(string);
    }
}
