package de.fachinformatiker.ae.baudis.graphic;


import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class Draw implements Primitive, GraphicObservable, Serializable {

    private static final long serialVersionUID = 5012732945538256418L;
    private List<Primitive> primitives = new ArrayList<>();
    private transient Collection<GraphicObserver> graphicObservers;


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
        return primitives.get(i);
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
        if (graphicObservers != null) {
            graphicObservers.remove(graphicObserver);
        }
    }

    private void notifyObservers(String action, Primitive primitive) {
        if (graphicObservers != null) {
            for (GraphicObserver o : graphicObservers) {
                o.update(this, action, primitive);
            }
        }
    }

    public void clear() {
        primitives.clear();
        notifyObservers("clear", null);
    }
}
