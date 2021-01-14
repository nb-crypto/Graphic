package de.fachinformatiker.ae.baudis.graphic.primitive;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class PointTest {

    @ParameterizedTest
    @MethodSource("testPointConstructor")
    void constructorTest(double x, double y){
        Point point = new Point(x,y);
        assertEquals(x, point.getX());
        assertEquals(y, point.getY());
    }

    @Test
    void defaultConstructorTest(){
        Point point = new Point();
        assertEquals(.0, point.getX());
        assertEquals(.0, point.getY());
    }

    @ParameterizedTest
    @MethodSource("testPointConstructor")
    void setterTest(double x, double y){
        Point point = new Point();
        point.setY(y);
        point.setX(x);
        assertEquals(x, point.getX());
        assertEquals(y, point.getY());
    }

    @ParameterizedTest
    @MethodSource
    void testCopyPoint(Point point) {
        Point copyPoint = new Point(point);

        assertEquals(point.getX(), copyPoint.getX());
        assertEquals(point.getY(), copyPoint.getY());
    }
    static Stream<Arguments> testPointConstructor(){
        return Stream.of(
                arguments(1, 1),
                arguments(-1, -1),
                arguments(0, 0),
                arguments(Double.MAX_VALUE, 0),
                arguments(Double.MIN_VALUE, 0),
                arguments(Double.MIN_VALUE, Double.MAX_VALUE),
                arguments(Double.MIN_VALUE, 76875.45783723),
                arguments(Double.MIN_VALUE, -76875.45783723),
                arguments(6876.096785346, -76875.45783723),
                arguments(6876.096785346, 6776875.45783723)
        );
    }

    static Stream<Arguments> testCopyPoint(){
        return Stream.of(
                arguments(new Point(1, 1)),
                arguments(new Point(-1, -1)),
                arguments(new Point(0, 0)),
                arguments(new Point(Double.MAX_VALUE, 0)),
                arguments(new Point(Double.MIN_VALUE, 0)),
                arguments(new Point(Double.MIN_VALUE, Double.MAX_VALUE)),
                arguments(new Point(Double.MIN_VALUE, 76875.45783723)),
                arguments(new Point(Double.MIN_VALUE, -76875.45783723)),
                arguments(new Point(6876.096785346, -76875.45783723)),
                arguments(new Point(6876.096785346, 6776875.45783723))
        );
    }

}