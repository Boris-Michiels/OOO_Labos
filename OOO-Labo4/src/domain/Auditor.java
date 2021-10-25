package domain;

public class Auditor implements Observer {
    private Bank bank;


    public Auditor(Subject bank) {
        this.bank = (Bank) bank;
        this.bank.addObserver(BankEvent.REKENING_OPENED, this);
    }

    @Override
    public void update(BankEvent e) {
        display();
    }

    private void display() {
        Rekening rekening = bank.getRekeningDb().getLastAddedRekening();
        String string = "Nieuwe rekening geopend op datum " + rekening.getCreationDate() +
                " met rekeningnummer " + rekening.getRekeningNummer() +
                " en saldo " + rekening.getSaldo();
        System.out.println(string);
    }
}
