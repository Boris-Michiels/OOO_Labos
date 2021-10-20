import domain.Auditor;
import domain.Bank;
import domain.Rekening;
import domain.RekeningLogger;

public class BankApp {
    public static void main(String[] args) {
        Bank bank = new Bank();
        Auditor auditor = new Auditor(bank);
        RekeningLogger rekeningLogger = new RekeningLogger(bank);
        Rekening rekening1 = new Rekening(12345, 100);

        bank.addRekening(rekening1);
    }
}
