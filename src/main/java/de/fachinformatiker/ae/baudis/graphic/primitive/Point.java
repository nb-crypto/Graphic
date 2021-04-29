package de.fachinformatiker.ae.baudis.graphic.primitive;

import de.fachinformatiker.ae.baudis.graphic.Primitive;

import java.io.Serializable;

public class Point implements Primitive, Serializable {

    private static final long serialVersionUID = 393734917427065230L;
    private double x;
    private double y;

    public Point() {
        setX(0.);
        setY(0.);
    }

    public Point(Point point) {
        this.x = point.x;
        this.y = point.y;
    }


    public Point(double x, double y) {
        setX(x);
        setY(y);
    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }


    @Override
    public String toString() {
        return "Point (" + x +
                ", " + y +
                ')';
    }
}
