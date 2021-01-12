package de.fachinformatiker.ae.baudis.graphic;

import de.fachinformatiker.ae.baudis.graphic.primitive.Oval;
import de.fachinformatiker.ae.baudis.graphic.primitive.Point;
import de.fachinformatiker.ae.baudis.graphic.primitive.Rectangel;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DrawTest {

    @Test
    void testAdd(){
        Draw field = new Draw();
        Point point = new Point();
        Oval oval = new Oval();
        Rectangel rectangel = new Rectangel();

        field.add(point);
        field.add(oval);
        field.add(rectangel);

        int size = field.getSize();
        assertEquals(3, size);
    }

    @Test
    void testRemove(){
        Draw field = new Draw();
        Point point = new Point();
        Oval oval = new Oval();
        Rectangel rectangel = new Rectangel();

        field.add(point);
        field.add(oval);
        field.add(rectangel);
        field.remove(2);

        int size = field.getSize();
        assertEquals(2, size);
    }

    @Test
    void testGetPrimitive(){
        Draw field = new Draw();
        Point point = new Point();
        Oval oval = new Oval();
        Rectangel rectangel = new Rectangel();

        field.add(point);
        field.add(oval);
        field.add(rectangel);

        assertEquals(point, field.getPrimitive(0));
    }

    @Test
    void testUndo(){
        Draw field = new Draw();
        Point point = new Point();
        Oval oval = new Oval();
        Rectangel rectangel = new Rectangel();

        field.add(point);
        field.add(oval);
        field.add(rectangel);
        field.undo();

        int size = field.getSize();
        assertEquals(2, size);
    }
}