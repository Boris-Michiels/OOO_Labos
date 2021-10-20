package db;

import domain.Rekening;

import java.util.Comparator;
import java.util.HashMap;

public class RekeningDb {
    private static RekeningDb rekeningDb;
    private HashMap<Integer, Rekening> rekeningen;


    private RekeningDb() {
        rekeningen = new HashMap<>();
    }

    public static RekeningDb getInstance() {
        if (rekeningDb == null) rekeningDb = new RekeningDb();
        return rekeningDb;
    }

    public void addRekening(Rekening rekening) {
        rekeningen.put(rekening.getRekeningNummer(), rekening);
    }

    public Rekening getRekening(int rekeningNummer) {
        return rekeningen.get(rekeningNummer);
    }

    public Rekening getLastAddedRekening() {
        return rekeningen.values().stream().max(Comparator.comparing(Rekening::getCreationDate)).get();
    }

    public int getSize() {
        return rekeningen.size();
    }
}
