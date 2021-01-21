package de.fachinformatiker.ae.baudis.graphic;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.ConcurrentModificationException;
import java.util.List;

public class Draw implements Primitive, GraphicObservable, Serializable {

    private List<Primitive> primitives = new ArrayList<>();
    private List<GraphicObserver> graphicObservers = new ArrayList<>();


    public void drawLoad(Draw draw){
        if (draw != null) {
            primitives = draw.primitives;
            graphicObservers = draw.graphicObservers;
        }
    }

    public void add(Primitive primitive) {
        if (primitive != null) {
            primitives.add(primitive);
            notifyObservers("add", primitive);
        }
    }

    public int getSizePrimitives() {
        return primitives.size();
    }

    public void remove(Primitive primitive) {
        for (int i = 0; i < primitives.size(); i++) {
            if (primitive == primitives.get(i)) {
                remove(i);
            }
        }
    }

    public void remove(int index) {

        if (index < primitives.size() && index >= 0) {
            Primitive primitive = getPrimitive(index);
            primitives.remove(index);
            notifyObservers("remove", primitive);
        }
    }

    public Primitive getPrimitive(int i) {
        //if (primitives.size() > i && i >= 0) {
        return primitives.get(i);
        // }
        //else return null;
    }

    public void undoAdd() {
        if (primitives.size() != 0) {
            Primitive primitive = getPrimitive(primitives.size() - 1);
            primitives.remove(primitive);
            notifyObservers("remove", primitive);
        }
    }

    public void addObserver(GraphicObserver graphicObserver) {
        if (graphicObservers == null) {
            graphicObservers = new ArrayList<>();
        }
        if (!graphicObservers.contains(graphicObserver)) {
            graphicObservers.add(graphicObserver);
        }
    }

    public void removeObserver(GraphicObserver graphicObserver) {
        graphicObservers.remove(graphicObserver);
    }

    private void notifyObservers(String action, Primitive primitive) {
        for (GraphicObserver o : graphicObservers) {
            o.update(this, action, primitive);
        }
    }

    public void clear() {
        primitives.clear();
        notifyObservers("clear", null);
    }

    public GraphicObserver getGraphicObserver(int i) {
        return graphicObservers.get(i);
    }

    public int getSizeGraphicObservers() {
        return graphicObservers.size();
    }

    public void clearGraphicObservers() {
        graphicObservers.clear();
    }
}
