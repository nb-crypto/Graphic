package de.fachinformatiker.ae.baudis.graphic.primitive;

import de.fachinformatiker.ae.baudis.graphic.Primitive;

public class Oval implements Primitive {

    private Point middlePoint;
    private int width;
    private int heigth;

    public Oval(){
        this.middlePoint = new Point();
        this.width = 1;
        this.heigth = 1;
    }
    public Oval(Point middlePoint, int width, int heigth) {
        this.middlePoint = middlePoint;
        this.width = width;
        this.heigth = heigth;
    }

    public Point getMiddlePoint() {
        return middlePoint;
    }

    public void setMiddlePoint(Point middlePoint) {
        this.middlePoint = middlePoint;
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
