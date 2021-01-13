package de.fachinformatiker.ae.baudis.graphic;

public interface Observable {
    void addObserver(Observer observer);
    void removeObserver(Observer observer);

}
