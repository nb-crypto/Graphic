package de.fachinformatiker.ae.baudis.graphic;


public interface GraphicObserver {
    void update(GraphicObservable graphicObservable, String action, Primitive primitive);

}
