package de.fachinformatiker.ae.baudis.graphic.primitive;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PointTest {

    @Test
    void constructorTest(){
        Point point = new Point(1,4);
        assertEquals(1, point.getX());
        assertEquals(4, point.getY());
    }

    @Test
    void defaultConstructorTest(){
        Point point = new Point();
        assertEquals(0, point.getX());
        assertEquals(0, point.getY());
    }

    @Test
    void setterTest(){
        Point point = new Point();
        point.setY(3);
        point.setX(-6);
        assertEquals(-6, point.getX());
        assertEquals(3, point.getY());
    }

}