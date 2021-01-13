package de.fachinformatiker.ae.baudis.graphic.primitive;

import de.fachinformatiker.ae.baudis.graphic.Primitive;

public class Rectangel implements Primitive {

    private Point lowerLeftPoint;
    private double width;
    private double height;


    public Rectangel(){
        this.lowerLeftPoint = new Point(0, 0);
        this.width = 1;
        this.height = 1;
    }
    public Rectangel(Point lowerLeftPoint, double width, double height) {
        this.lowerLeftPoint = lowerLeftPoint;
        this.width = width;
        this.height = height;
    }

    public Point getLowerLeftPoint() {
        return lowerLeftPoint;
    }

    public void setLowerLeftPoint(Point lowerLeftPoint) {
        this.lowerLeftPoint = lowerLeftPoint;
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
}
