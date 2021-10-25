package domain;

import java.util.Observable;
import java.util.Observer;

public class AuditorUtilPull implements Observer {
        private BankUtilPull bankUtilPull;


        public AuditorUtilPull(Observable o) {
            o.addObserver(this);
            bankUtilPull = (BankUtilPull) o;
        }

        @Override
        public void update(Observable o, Object arg) {
            display();
        }

        private void display() {
            String string = "Nieuwe rekening geopend op datum " +
                    bankUtilPull.getRekeningDb().getLastAddedRekening().getCreationDate() +
                    " met rekeningnummer " +
                    bankUtilPull.getRekeningDb().getLastAddedRekening().getRekeningNummer() +
                    " en saldo " +
                    bankUtilPull.getRekeningDb().getLastAddedRekening().getSaldo();
            System.out.println(string);
        }
}
