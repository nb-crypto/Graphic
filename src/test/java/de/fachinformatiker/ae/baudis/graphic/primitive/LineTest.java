package de.fachinformatiker.ae.baudis.graphic.primitive;

import  static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

class LineTest {

    @Test
    void constructorTest(){
        Point startPoint = new Point(-4, 4);
        Point endPoint = new Point(2, 90);
        Line line = new Line(startPoint, endPoint);
        assertEquals(-4, line.getStart().getX());
        assertEquals(4, line.getStart().getY());
        assertEquals(2, line.getEnd().getX());
        assertEquals(90, line.getEnd().getY());
    }

    @Test
    void defaultConstructorTest(){
        Line line = new Line();
        assertEquals(0, line.getStart().getX());
        assertEquals(0, line.getStart().getY());
        assertEquals(1, line.getEnd().getY());
        assertEquals(1, line.getEnd().getX());
    }

    @Test
    void setterTest(){
        Line line = new Line();
        Point startPoint = new Point(3, 7);
        Point endPoint = new Point(8, 4);
        line.setEnd(endPoint);
        line.setStart(startPoint);
        assertEquals(3,line.getStart().getX());
        assertEquals(7,line.getStart().getY());
        assertEquals(8,line.getEnd().getX());
        assertEquals(4,line.getEnd().getY());

    }
}