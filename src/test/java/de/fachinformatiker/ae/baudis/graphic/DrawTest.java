package de.fachinformatiker.ae.baudis.graphic;

import de.fachinformatiker.ae.baudis.graphic.primitive.Line;
import de.fachinformatiker.ae.baudis.graphic.primitive.Oval;
import de.fachinformatiker.ae.baudis.graphic.primitive.Point;
import de.fachinformatiker.ae.baudis.graphic.primitive.Rectangel;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


import static org.junit.jupiter.api.Assertions.*;

class DrawTest {
    Draw draw;

    @BeforeEach
    void beforeEach(){
        draw = new Draw();
    }

    @Test
    void testAdd(){
        Point point = new Point();
        Oval oval = new Oval();
        Rectangel rectangel = new Rectangel();

        draw.add(point);
        draw.add(oval);
        draw.add(rectangel);

        int size = draw.getSizePrimitives();
        assertEquals(3, size);
    }

    @Test
    void testRemove(){
        Point point = new Point();
        Oval oval = new Oval();
        Rectangel rectangel = new Rectangel();

        draw.add(point);
        draw.add(oval);
        draw.add(rectangel);
        draw.remove(2);

        int size = draw.getSizePrimitives();
        assertEquals(2, size);
    }

    @Test
    void testGetPrimitive(){
        Point point = new Point();
        Oval oval = new Oval();
        Rectangel rectangel = new Rectangel();

        draw.add(point);
        draw.add(oval);
        draw.add(rectangel);

        assertEquals(point, draw.getPrimitive(0));
    }

    @Test
    void testGetPrimitiveNull(){
        Point point = new Point();
        draw.add(point);
        assertNotNull(draw.getPrimitive(0));
        assertNull(draw.getPrimitive(7));
        assertNull(draw.getPrimitive(-1));
        assertNull(draw.getPrimitive(1));
        assertNull(draw.getPrimitive(-789));
        assertNull(draw.getPrimitive(Integer.MAX_VALUE));
    }

    @Test
    void testUndoAdd(){
        Point point = new Point();
        Oval oval = new Oval();
        Rectangel rectangel = new Rectangel();

        draw.add(point);
        draw.add(oval);
        draw.add(rectangel);
        draw.undoAdd();

        int size = draw.getSizePrimitives();
        assertEquals(2, size);
    }

    @Test
    void testObservable(){
        int[] counter = {0};
        Observer observer = new Observer() {
            @Override
            public void update(Observable observable) {
                counter[0]++;
            }
        };
        Draw draw = new Draw();
        draw.addObserver(observer);
        Point point = new Point();
        Oval oval = new Oval();
        Rectangel rectangel = new Rectangel();
        Line line = new Line();

        draw.add(point);
        draw.add(oval);
        draw.add(rectangel);
        draw.add(line);

        draw.remove(oval);
        assertEquals(5, counter[0]);

        draw.removeObserver(observer);
        draw.add(line);
        assertEquals(5, counter[0]);

    }

}