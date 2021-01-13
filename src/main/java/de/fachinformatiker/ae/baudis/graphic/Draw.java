package de.fachinformatiker.ae.baudis.graphic;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class Draw implements Primitive, Observable{

    private List<Primitive> primitives = new ArrayList<>();
    private Collection<Observer> observers = new ArrayList<>();

    public void add(Primitive primitive){
        primitives.add(primitive);
        notifyObservers();
    }

    public int getSizePrimitives() {
        return primitives.size();
    }

    public void remove(Primitive primitive){
        boolean removed = this.primitives.remove(primitive);
        if (removed){
            notifyObservers();
        }
    }

    public void remove(int index){
        if (index < primitives.size() && index >= 0) {
            primitives.remove(index);
            notifyObservers();
        }
    }

    public Primitive getPrimitive(int i) {
        if (primitives.size() > i && i >= 0) {
            return primitives.get(i);
        }
        else return null;
    }

    public void undoAdd(){
        if (primitives.size() != 0) {
            primitives.remove(primitives.size() - 1);
            notifyObservers();
        }
    }
    
    public void addObserver(Observer observer){
        if (observers == null){
            observers = new ArrayList<>();
        }
        if (!observers.contains(observer)){
        observers.add(observer);
        }
    }
    
    public void removeObserver(Observer observer){
        observers.remove(observer);
    }
    
    private void notifyObservers(){
        for (Observer o: observers) {
            o.update(this);
        }
    }
}
