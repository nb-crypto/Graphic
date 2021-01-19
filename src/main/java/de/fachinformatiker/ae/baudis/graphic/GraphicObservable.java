package de.fachinformatiker.ae.baudis.graphic;

public interface GraphicObservable {
    void addObserver(GraphicObserver graphicObserver);

    void removeObserver(GraphicObserver graphicObserver);

}
