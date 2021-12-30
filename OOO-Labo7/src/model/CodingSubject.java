package model;

public interface CodingSubject {
    void addObserver(CodingObserver o);
    void removeObserver(CodingObserver o);
    void notifyObservers();
}
