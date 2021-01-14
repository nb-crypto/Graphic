package de.fachinformatiker.ae.baudis.graphic.primitive;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class OvalTest {

    @ParameterizedTest
    @MethodSource("testOvalConstructor")
    void constructorTest(Point middlePoint, double width, double height){

        Oval oval = new Oval(middlePoint, width,height);

        assertEquals(middlePoint.getX(), oval.getMiddlePoint().getX());
        assertEquals(middlePoint.getY(), oval.getMiddlePoint().getY());
        assertEquals(height, oval.getHeight());
        assertEquals(width, oval.getWidth());
    }

    @Test
    void defaultConstructorTest(){
        Oval oval = new Oval();

        assertEquals(.0, oval.getMiddlePoint().getY());
        assertEquals(.0, oval.getMiddlePoint().getX());
        assertEquals(1., oval.getWidth());
        assertEquals(1., oval.getHeight());
    }

    @ParameterizedTest
    @MethodSource("testOvalConstructor")
    void setterTest(Point middlePoint, double width, double height){
        Oval oval = new Oval();

        oval.setMiddlePoint(middlePoint);
        oval.setHeight(height);
        oval.setWidth(width);

        assertEquals(middlePoint.getX(), oval.getMiddlePoint().getX());
        assertEquals(middlePoint.getY(), oval.getMiddlePoint().getY());
        assertEquals(width, oval.getWidth());
        assertEquals(height, oval.getHeight());
    }

    @ParameterizedTest
    @MethodSource
    void testCopyOval(Oval oval) {
        Oval copyOval = new Oval(oval);

        assertEquals(oval.getMiddlePoint().getX(), copyOval.getMiddlePoint().getX());
        assertEquals(oval.getMiddlePoint().getY(), copyOval.getMiddlePoint().getY());
        assertEquals(oval.getWidth(), copyOval.getWidth());
        assertEquals(oval.getHeight(), copyOval.getHeight());
    }

    static Stream<Arguments> testOvalConstructor() {
        return Stream.of(
          arguments(new Point(), 1, 1),
          arguments(new Point(), 1, -1),
          arguments(new Point(), -1, -1),
          arguments(new Point(-1,1), -1, -1),
          arguments(new Point(-1,-1), -1, -1),
          arguments(new Point(-1969.96,-1), Double.MAX_VALUE, -1),
          arguments(new Point(-1,85474.5894), Double.MAX_VALUE, 0),
          arguments(new Point(Double.MIN_VALUE,9867.06346), Double.MIN_VALUE, 0),
          arguments(new Point(-1,-1), Double.MIN_VALUE, Double.MAX_VALUE),
          arguments(new Point(), 6576.87582, Double.MAX_VALUE),
          arguments(new Point(Double.MIN_VALUE, Double.MAX_VALUE), Double.MAX_VALUE, Double.MAX_VALUE)
        );
    }

    static Stream<Arguments> testCopyOval() {
        return Stream.of(
          arguments(new Oval(new Point(), 1, 1)),
          arguments(new Oval(new Point(), 1, -1)),
          arguments(new Oval(new Point(), -1, -1)),
          arguments(new Oval(new Point(-1,1), -1, -1)),
          arguments(new Oval(new Point(-1,-1), -1, -1)),
          arguments(new Oval(new Point(-1969.96,-1), Double.MAX_VALUE, -1)),
          arguments(new Oval(new Point(-1,85474.5894), Double.MAX_VALUE, 0)),
          arguments(new Oval(new Point(Double.MIN_VALUE,9867.06346), Double.MIN_VALUE, 0)),
          arguments(new Oval(new Point(-1,-1), Double.MIN_VALUE, Double.MAX_VALUE)),
          arguments(new Oval(new Point(), 6576.87582, Double.MAX_VALUE)),
          arguments(new Oval(new Point(Double.MIN_VALUE, Double.MAX_VALUE), Double.MAX_VALUE, Double.MAX_VALUE))
        );
    }
}