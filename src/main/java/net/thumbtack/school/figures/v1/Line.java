package net.thumbtack.school.figures.v1;

import java.util.Objects;

public class Line {
    Point startPoint;
    Point endPoint;

    public Line(Point startPoint, Point endPoint) {
        this.startPoint = startPoint;
        this.endPoint = endPoint;
    }

    public Line(int xLeft, int yTop, int xRight, int yBottom) {
        this.startPoint = new Point(xLeft, yTop);
        this.endPoint = new Point(xRight, yBottom);
    }

    public Line(Point endPoint) {
        this.startPoint = new Point(0, 0);
        this.endPoint = endPoint;
    }

    public Line(int x, int y) {
        this.startPoint = new Point(0, 0);
        this.endPoint = new Point(x, y);
    }

    public Line() {
        this.startPoint = new Point(0, 0);
        this.endPoint = new Point(1, 1);
    }

    public Point getStartPoint() {
        return startPoint;
    }

    public void setStartPoint(Point point) {
        this.startPoint = point;
    }

    public Point getEndPoint() {
        return endPoint;
    }

    public void setEndPoint(Point point) {
        this.endPoint = point;
    }

    public double getLength() {
        return Math.sqrt(Math.pow(getEndPoint().getX() - getStartPoint().getX(), 2) + Math.pow(getEndPoint().getY() - getStartPoint().getY(), 2));
    }

    public void moveTo(int x, int y) {
        setEndPoint(new Point(getEndPoint().getX() + x - getStartPoint().getX(), getEndPoint().getY() + y - getStartPoint().getY()));
        setStartPoint(new Point(x, y));
    }

    public void moveTo(Point point) {
        setEndPoint(new Point(getEndPoint().getX() + point.getX() - getStartPoint().getX(), getEndPoint().getY() + point.getY() - getStartPoint().getY()));
        setStartPoint(new Point(point.getX(), point.getY()));
    }

    public void moveRel(int dx, int dy) {
        setStartPoint(new Point(getStartPoint().getX() + dx, getStartPoint().getY() + dy));
        setEndPoint(new Point(getEndPoint().getX() + dx, getEndPoint().getY() + dy));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Line)) return false;
        Line line = (Line) o;
        return getStartPoint().equals(line.getStartPoint()) && getEndPoint().equals(line.getEndPoint());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getStartPoint(), getEndPoint());
    }
}
