package de.fachinformatiker.ae.baudis.graphic.primitive;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RectangelTest {

    @Test
    void constructorTest(){
        Point point = new Point(4., 8.);
        Rectangel rectangel = new Rectangel(point, 2., 3.);

        assertEquals(4., rectangel.getLowerLeftPoint().getX());
        assertEquals(8., rectangel.getLowerLeftPoint().getY());
        assertEquals(2., rectangel.getWidth());
        assertEquals(3., rectangel.getHeight());
    }

    @Test
    void defaultConstructorTest(){
        Rectangel rectangel = new Rectangel();

        assertEquals(.0, rectangel.getLowerLeftPoint().getX());
        assertEquals(.0, rectangel.getLowerLeftPoint().getY());
        assertEquals(1.,rectangel.getHeight());
        assertEquals(1.,rectangel.getWidth());
    }

    @Test
    void setterTest(){
        Rectangel rectangel = new Rectangel();
        Point point = new Point(1., 3.);

        rectangel.setLowerLeftPoint(point);
        rectangel.setHeight(4.);
        rectangel.setWidth(8.);

        assertEquals(1., rectangel.getLowerLeftPoint().getX());
        assertEquals(3., rectangel.getLowerLeftPoint().getY());
        assertEquals(4., rectangel.getHeight());
        assertEquals(8., rectangel.getWidth());
    }
}