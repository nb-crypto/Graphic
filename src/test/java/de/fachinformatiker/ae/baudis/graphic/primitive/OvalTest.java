package de.fachinformatiker.ae.baudis.graphic.primitive;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class OvalTest {

    @Test
    void constructorTest(){
        Point middlePoint = new Point(2., 4.);
        Oval oval = new Oval(middlePoint, 3., 6.);

        assertEquals(2., oval.getMiddlePoint().getX());
        assertEquals(4., oval.getMiddlePoint().getY());
        assertEquals(6., oval.getHeight());
        assertEquals(3., oval.getWidth());
    }

    @Test
    void defaultConstructorTest(){
        Oval oval = new Oval();

        assertEquals(.0, oval.getMiddlePoint().getY());
        assertEquals(.0, oval.getMiddlePoint().getX());
        assertEquals(1., oval.getWidth());
        assertEquals(1., oval.getHeight());
    }

    @Test
    void setterTest(){
        Oval oval = new Oval();
        Point middlePoint = new Point(5., 7.);

        oval.setMiddlePoint(middlePoint);
        oval.setHeight(14.);
        oval.setWidth(10.);

        assertEquals(5., oval.getMiddlePoint().getX());
        assertEquals(7., oval.getMiddlePoint().getY());
        assertEquals(10., oval.getWidth());
        assertEquals(14., oval.getHeight());
    }
}