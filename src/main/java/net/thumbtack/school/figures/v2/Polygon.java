package net.thumbtack.school.figures.v2;

import java.util.Arrays;

public class Polygon extends ClosedFigure {

    private Point[] points;

    public Polygon(Point[] points) {
        this.points = Arrays.copyOf(points, points.length);
    }

    public Point[] getPoints() {
        return this.points;
    }

    public void setPoints(Point[] points) {
        this.points = Arrays.copyOf(points, points.length);
    }

    public double getPerimeter() {
        double distance = 0;
        for (int i = 0; i < points.length; ++i) {
            distance += Math.sqrt(Math.pow(points[(i + 1) % points.length].getX() - points[i].getX(), 2) +
                    Math.pow(points[(i + 1) % points.length].getY() - points[i].getY(), 2));
        }
        return distance;
    }

    public void moveTo(int x, int y) {
        int dX = x - points[0].getX();
        int dY = y - points[0].getY();
        for (Point point : points) {
            point.moveRel(dX, dY);
        }
    }

    public void moveRel(int dx, int dy) {
        for (Point point : points) {
            point.moveRel(dx, dy);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Polygon)) return false;
        Polygon polygon = (Polygon) o;
        return Arrays.equals(getPoints(), polygon.getPoints());
    }

    @Override
    public int hashCode() {
        return Arrays.hashCode(getPoints());
    }
}
