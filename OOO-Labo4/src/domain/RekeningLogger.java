package domain;

public class RekeningLogger implements Observer {
    private Bank bank;


    public RekeningLogger(Subject bank) {
        this.bank = (Bank) bank;
        this.bank.addObserver(BankEvent.REKENING_OPENED, this);
        this.bank.addObserver(BankEvent.MONEY_DEPOSITED, this);
        this.bank.addObserver(BankEvent.MONEY_WITHDRAWN, this);
    }

    @Override
    public void update(BankEvent e) {
        display(e);
    }

    private void display(BankEvent e) {
        Rekening rekening = bank.getRekeningDb().getLastAddedRekening();
        String string = e.getEventName() + "; " +
                "Rekeningnummer: " + rekening.getRekeningNummer() +
                " - Saldo:" + rekening.getSaldo() +
                (e == BankEvent.REKENING_OPENED ? (" - Totaal aantal rekeningen: " + bank.getRekeningDb().getSize()) : "");
        System.out.println(string);
    }
}
