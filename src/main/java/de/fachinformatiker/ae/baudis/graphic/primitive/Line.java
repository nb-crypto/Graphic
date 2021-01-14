package de.fachinformatiker.ae.baudis.graphic.primitive;

import de.fachinformatiker.ae.baudis.graphic.Primitive;

public class Line implements Primitive {

    private Point start;
    private Point end;

    public Line(){
        this.start = new Point();
        this.end = new Point(1, 1);
    }

    public Line(Point start, Point end) {
        this.start = start;
        this.end = end;
    }

    public Line(Line line) {
        this.start = line.start;
        this.end = line.end;
    }
    public Point getStart() {
        return start;
    }

    public void setStart(Point start) {
        this.start = start;
    }

    public Point getEnd() {
        return end;
    }

    public void setEnd(Point end) {
        this.end = end;
    }

    @Override
    public String toString() {
        return "Line[" +
                "start Point= (" + start.getX() +
                ", " + start.getY() +
                ") , end Point= (" + end.getX() +
                ", " + end.getY() +
                ")]";
    }
}
