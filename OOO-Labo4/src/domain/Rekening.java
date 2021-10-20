package domain;

import java.time.LocalDateTime;

public class Rekening {
    private double saldo;
    private int rekeningNummer;
    private LocalDateTime creationDate;

    public Rekening(int rekeningNummer, double saldo) {
        this.saldo = saldo;
        this.rekeningNummer = rekeningNummer;
        this.creationDate = LocalDateTime.now();
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public int getRekeningNummer() {
        return rekeningNummer;
    }

    public void setRekeningNummer(int rekeningNummer) {
        this.rekeningNummer = rekeningNummer;
    }

    public LocalDateTime getCreationDate() {
        return this.creationDate;
    }
}
