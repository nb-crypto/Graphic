package de.fachinformatiker.ae.baudis.graphic;

import de.fachinformatiker.ae.baudis.graphic.primitive.Line;
import de.fachinformatiker.ae.baudis.graphic.primitive.Oval;
import de.fachinformatiker.ae.baudis.graphic.primitive.Point;
import de.fachinformatiker.ae.baudis.graphic.primitive.Rectangle;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
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
        Rectangle rectengel = new Rectangle();

        draw.add(point);
        draw.add(oval);
        draw.add(rectengel);

        int size = draw.getSizePrimitives();
        assertEquals(3, size);
    }

    @Test
    void testRemove(){
        Point point = new Point();
        Oval oval = new Oval();
        Rectangle rectengel = new Rectangle();

        draw.add(point);
        draw.add(oval);
        draw.add(rectengel);
        draw.remove(2);

        int size = draw.getSizePrimitives();
        assertEquals(2, size);
    }

    @Test
    void testGetPrimitive(){
        Point point = new Point();
        Oval oval = new Oval();
        Rectangle rectengel = new Rectangle();

        draw.add(point);
        draw.add(oval);
        draw.add(rectengel);

        assertEquals(point, draw.getPrimitive(0));
    }

    @Test
    @Disabled
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
        Rectangle rectengel = new Rectangle();

        draw.add(point);
        draw.add(oval);
        draw.add(rectengel);
        draw.undoAdd();

        int size = draw.getSizePrimitives();
        assertEquals(2, size);
    }

    @Test
    void testObservable(){
        int[] counter = {0, 0};
        GraphicObserver graphicObserver0 = new GraphicObserver() {
            @Override
            //zählt die Veränderungen
            public void update(GraphicObservable observable, String action, Primitive primitive) {
                counter[0]++;
            }
        };
        GraphicObserver graphicObserver1 = new GraphicObserver() {
            @Override
            //zählt wie viele Primitives in draw
            public void update(GraphicObservable observable, String action, Primitive primitive) {
                switch (action) {
                    case "add":
                        counter[1]++;

                    break;

                    case "remove":
                        counter[1]--;

                    break;
                }
            }
        };
        Draw draw = new Draw();
        draw.addObserver(graphicObserver0);
        draw.addObserver(graphicObserver1);
        Point point = new Point();
        Oval oval = new Oval();
        Rectangle rectangle = new Rectangle();
        Line line = new Line();

        draw.add(point);
        draw.add(oval);
        draw.add(rectangle);
        draw.add(line);

        assertEquals(4, counter[1]);
        assertEquals(4, counter[0]);

        draw.remove(oval);

        assertEquals(5, counter[0]);
        assertEquals(3, counter[1]);

        draw.removeObserver(graphicObserver1);
        draw.add(line);

        assertEquals(6, counter[0]);
        assertEquals(3, counter[1]);

        draw.addObserver(graphicObserver1);
        draw.removeObserver(graphicObserver0);
        draw.remove(line);

        assertEquals(6, counter[0]);
        assertEquals(2, counter[1]);

    }

    @Test
    void listTest() {
        Point v0 = new Point();
        Point v1 = new Point();

        // für die equals-Methode sind v0 und v1 gleich,
        // deshalb darf die equals-Methode im remove von Drawing nicht verwendet werden,
        // sondern es muss mit == gearbeitet werden um tatsächlich das konkrete Primitive zu finden.
        // ALSO: in remove(Primitive) darf nicht die Methode List.remove(Object) verwendet werden,
        //       da sonst auch ein falsches Primitive gelöscht werden könnte

        draw.add(v0);
        draw.add(v1);
        draw.remove(v0);

        assertNotSame(v0, draw.getPrimitive(0));
        assertSame(v1, draw.getPrimitive(0));
    }

}