package de.fachinformatiker.ae.baudis.graphic.primitive;

import de.fachinformatiker.ae.baudis.graphic.Primitive;

public class Oval implements Primitive {

    private Point middlePoint;
    private double width;
    private double height;

    public Oval(){
        this.middlePoint = new Point();
        this.width = 1;
        this.height = 1;
    }
    public Oval(Point middlePoint, double width, double height) {
        this.middlePoint = middlePoint;
        this.width = width;
        this.height = height;
    }

    public Oval(Point middlePoint, double radius) {
        this.middlePoint = middlePoint;
        this.width = radius;
        this.height = radius;
    }

    public Oval(Oval oval) {
        this.middlePoint = oval.middlePoint;
        this.height = oval.height;
        this.width = oval.width;
    }

    public Point getMiddlePoint() {
        return middlePoint;
    }

    public void setMiddlePoint(Point middlePoint) {
        this.middlePoint = middlePoint;
    }

    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    @Override
    public String toString() {
        return "Oval[" +
                "middlePoint= (" + middlePoint.getX() +
                ", " + middlePoint.getY() +
                "), width=" + width +
                ", height=" + height +
                ']';
    }
}
