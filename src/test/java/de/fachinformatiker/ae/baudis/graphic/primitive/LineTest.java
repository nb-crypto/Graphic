package de.fachinformatiker.ae.baudis.graphic.primitive;

import  static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.params.provider.Arguments.arguments;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

class LineTest {

    @ParameterizedTest
    @MethodSource("testLineConstructor")
    void constructorTest(Point p1, Point p2){

        Line line = new Line(p1, p2);
        assertEquals(p1, line.getStart());
        assertEquals(p2, line.getEnd());

    }

    @Test
    void defaultConstructorTest(){
        Line line = new Line();
        assertEquals(.0, line.getStart().getX());
        assertEquals(.0, line.getStart().getY());
        assertEquals(1., line.getEnd().getY());
        assertEquals(1., line.getEnd().getX());
    }

    @ParameterizedTest
    @MethodSource("testLineConstructor")
    void setterTest(Point p1, Point p2){
        Line line = new Line();

        line.setStart(p1);
        line.setEnd(p2);

        assertEquals(p1, line.getStart());
        assertEquals(p2, line.getEnd());


    }

    @ParameterizedTest
    @MethodSource
    void testCopyLine(Line line) {
        Line copyLine = new Line(line);

        assertEquals(line.getStart().getX(), copyLine.getStart().getX());
        assertEquals(line.getStart().getY(), copyLine.getStart().getY());
        assertEquals(line.getEnd().getY(), copyLine.getEnd().getY());
        assertEquals(line.getEnd().getX(), copyLine.getEnd().getX());
    }
    static Stream<Arguments> testLineConstructor(){
        return Stream.of(
                arguments((new Point(Double.MAX_VALUE, Double.MAX_VALUE)),
                        new Point(Double.MAX_VALUE, Double.MAX_VALUE)),
                arguments((new Point()), new Point(Double.MIN_VALUE, Double.MIN_VALUE)),
                arguments((new Point(1,1)), new Point(-1, 1)),
                arguments((new Point(1,1)), new Point(-1, -1)),
                arguments((new Point()), new Point(-17985.79, 78655.5688971)),
                arguments(new Point(), new Point())

        );
    }
    static Stream<Arguments> testCopyLine(){
        return Stream.of(
                arguments(new Line(new Point(Double.MAX_VALUE, Double.MAX_VALUE),
                        new Point(Double.MAX_VALUE, Double.MAX_VALUE))),
                arguments(new Line(new Point(), new Point(Double.MIN_VALUE, Double.MIN_VALUE))),
                arguments(new Line(new Point(1,1), new Point(-1, 1))),
                arguments(new Line(new Point(1,1), new Point(-1, -1))),
                arguments(new Line(new Point(), new Point(-17985.79, 78655.5688971))),
                arguments(new Line(new Point(), new Point()))

        );
    }

}