package de.fachinformatiker.ae.baudis.graphic.primitive;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class RectangleTest {

    @ParameterizedTest
    @MethodSource("testRectangleConstructor")
    void constructorTest(Point lowerLeft, double width, double height){

        Rectangle rectangle = new Rectangle(lowerLeft, width, height);

        assertEquals(lowerLeft.getX(), rectangle.getLowerLeftPoint().getX());
        assertEquals(lowerLeft.getY(), rectangle.getLowerLeftPoint().getY());
        assertEquals(width, rectangle.getWidth());
        assertEquals(height, rectangle.getHeight());
    }

    @Test
    void defaultConstructorTest(){
        Rectangle rectangle = new Rectangle();

        assertEquals(.0, rectangle.getLowerLeftPoint().getX());
        assertEquals(.0, rectangle.getLowerLeftPoint().getY());
        assertEquals(1., rectangle.getHeight());
        assertEquals(1., rectangle.getWidth());
    }

    @ParameterizedTest
    @MethodSource("testRectangleConstructor")
    void setterTest(Point lowerLeft, double width, double height){
        Rectangle rectangle = new Rectangle();

        rectangle.setLowerLeftPoint(lowerLeft);
        rectangle.setHeight(height);
        rectangle.setWidth(width);

        assertEquals(lowerLeft.getX(), rectangle.getLowerLeftPoint().getX());
        assertEquals(lowerLeft.getY(), rectangle.getLowerLeftPoint().getY());
        assertEquals(height, rectangle.getHeight());
        assertEquals(width, rectangle.getWidth());
    }

    @ParameterizedTest
    @MethodSource
    void testSquareConstructor(Point lowerLeft, double site) {
        Rectangle square = new Rectangle(lowerLeft, site);

        assertEquals(lowerLeft.getX(), square.getLowerLeftPoint().getX());
        assertEquals(lowerLeft.getY(), square.getLowerLeftPoint().getY());
        assertEquals(site, square.getHeight());
        assertEquals(site, square.getWidth());
    }

    @ParameterizedTest
    @MethodSource
    void testCopyRectangle(Rectangle rectangle) {
        Rectangle copyRectangle = new Rectangle(rectangle);

        assertEquals(rectangle.getLowerLeftPoint().getX(), copyRectangle.getLowerLeftPoint().getX());
        assertEquals(rectangle.getLowerLeftPoint().getY(), copyRectangle.getLowerLeftPoint().getY());
        assertEquals(rectangle.getWidth(), copyRectangle.getWidth());
        assertEquals(rectangle.getHeight(), copyRectangle.getHeight());
    }

    static Stream<Arguments> testSquareConstructor() {
        return Stream.of(
                arguments(new Point(), 1),
                arguments(new Point(), 1),
                arguments(new Point(), -1),
                arguments(new Point(-1,1), -1),
                arguments(new Point(-1,-1), -1),
                arguments(new Point(-1969.96,86.8), -1),
                arguments(new Point(-1,85474.5894), Double.MAX_VALUE),
                arguments(new Point(Double.MIN_VALUE,9867.06346), Double.MIN_VALUE),
                arguments(new Point(-1,Double.MIN_VALUE), 0),
                arguments(new Point(), 6576.87582),
                arguments(new Point(Double.MIN_VALUE, Double.MAX_VALUE), Double.MAX_VALUE)
        );
    }

    static Stream<Arguments> testRectangleConstructor() {
        return Stream.of(
                arguments(new Point(), 1, 1),
                arguments(new Point(), 1, -1),
                arguments(new Point(), -1, -1),
                arguments(new Point(-1,1), -1, -1),
                arguments(new Point(-1,-1), -1, -1),
                arguments(new Point(-1969.96,86.8), Double.MAX_VALUE, -1),
                arguments(new Point(-1,85474.5894), Double.MAX_VALUE, 0),
                arguments(new Point(Double.MIN_VALUE,9867.06346), Double.MIN_VALUE, 0),
                arguments(new Point(-1,Double.MIN_VALUE), Double.MIN_VALUE, Double.MAX_VALUE),
                arguments(new Point(), 6576.87582, Double.MAX_VALUE),
                arguments(new Point(Double.MIN_VALUE, Double.MAX_VALUE), Double.MAX_VALUE, Double.MAX_VALUE)
        );
    }

    static Stream<Arguments> testCopyRectangle() {
        return Stream.of(
                arguments(new Rectangle(new Point(), 1, 1)),
                arguments(new Rectangle(new Point(), 1, -1)),
                arguments(new Rectangle(new Point(), -1, -1)),
                arguments(new Rectangle(new Point(-1,1), -1, -1)),
                arguments(new Rectangle(new Point(-1,-1), -1, -1)),
                arguments(new Rectangle(new Point(-1969.96,86.8), Double.MAX_VALUE, -1)),
                arguments(new Rectangle(new Point(-1,85474.5894), Double.MAX_VALUE, 0)),
                arguments(new Rectangle(new Point(Double.MIN_VALUE,9867.06346), Double.MIN_VALUE, 0)),
                arguments(new Rectangle(new Point(-1,Double.MIN_VALUE), Double.MIN_VALUE, Double.MAX_VALUE)),
                arguments(new Rectangle(new Point(), 6576.87582, Double.MAX_VALUE)),
                arguments(new Rectangle(new Point(Double.MIN_VALUE, Double.MAX_VALUE), Double.MAX_VALUE, Double.MAX_VALUE))
        );
    }
}