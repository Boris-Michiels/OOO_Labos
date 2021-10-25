import domain.*;

public class BankApp {
    public static void main(String[] args) {
        Rekening rekening1 = new Rekening(12345, 100);

        Bank bank = new Bank();
        Auditor auditor = new Auditor(bank);
        RekeningLogger rekeningLogger = new RekeningLogger(bank);
        bank.addRekening(rekening1);
        bank.depositMoney(12345, 555.555);
        bank.withdrawMoney(12345, 654.555);

        System.out.println("\n\n\n");

        BankUtilPush bankUtilPush = new BankUtilPush();
        AuditorUtilPush auditorUtilPush = new AuditorUtilPush(bankUtilPush);
        RekeningLoggerUtilPush rekeningLoggerUtilPush = new RekeningLoggerUtilPush(bankUtilPush);
        bankUtilPush.addRekening(rekening1);

        BankUtilPull bankUtilPull = new BankUtilPull();
        AuditorUtilPull auditorUtilPull = new AuditorUtilPull(bankUtilPull);
        RekeningLoggerUtilPull rekeningLoggerUtilPull = new RekeningLoggerUtilPull(bankUtilPull);
        bankUtilPull.addRekening(rekening1);
    }
}
