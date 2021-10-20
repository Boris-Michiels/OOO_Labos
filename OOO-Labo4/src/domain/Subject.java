package domain;

public interface Subject {
    void addObserver(BankEvent e, Observer o);
    void removeObserver(Observer o);
    void notifyObservers(BankEvent e);
}
