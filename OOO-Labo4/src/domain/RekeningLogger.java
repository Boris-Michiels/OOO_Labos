package domain;

public class RekeningLogger implements Observer {
    private Bank bank;


    public RekeningLogger(Subject bank) {
        this.bank = (Bank) bank;
        this.bank.addObserver(BankEvent.REKENING_OPENED, this);
    }

    @Override
    public void update() {
        display();
    }

    private void display() {
        Rekening rekening = bank.getRekeningDb().getLastAddedRekening();
        String string = "REKENINGLOGGER; Rekeningnummer: " +
                rekening.getRekeningNummer() +
                " - Totaal aantal rekeningen: " +
                bank.getRekeningDb().getSize();
        System.out.println(string);
    }
}
