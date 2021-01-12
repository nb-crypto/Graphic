package de.fachinformatiker.ae.baudis.graphic;

import de.fachinformatiker.ae.baudis.graphic.primitive.Point;
import de.fachinformatiker.ae.baudis.graphic.primitive.Rectangel;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class Draw implements Primitive{

    List<Primitive> field = new ArrayList();

    public void add(Primitive primitive){
        field.add(primitive);
    }

    public int getSize() {
        return field.size();
    }

    public void remove(Primitive primitive){
        field.remove(primitive);
    }

    public void remove(int index){
        field.remove(index);
    }

    public Primitive getPrimitive(int i) {
        return field.get(i);
    }

    public void undo(){
        field.remove(field.size() - 1);
    }
}
