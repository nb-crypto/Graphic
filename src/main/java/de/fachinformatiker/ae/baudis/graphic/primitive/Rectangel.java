package de.fachinformatiker.ae.baudis.graphic.primitive;

import de.fachinformatiker.ae.baudis.graphic.Primitive;

public class Rectangel implements Primitive {

    private Point lowerLeftPoint;
    private int width;
    private int heigth;


    public Rectangel(){
        this.lowerLeftPoint = new Point(0, 0);
        this.width = 1;
        this.heigth = 1;
    }
    public Rectangel(Point lowerLeftPoint, int width, int heigth) {
        this.lowerLeftPoint = lowerLeftPoint;
        this.width = width;
        this.heigth = heigth;
    }

    public Point getLowerLeftPoint() {
        return lowerLeftPoint;
    }

    public void setLowerLeftPoint(Point lowerLeftPoint) {
        this.lowerLeftPoint = lowerLeftPoint;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeigth() {
        return heigth;
    }

    public void setHeigth(int heigth) {
        this.heigth = heigth;
    }
}
