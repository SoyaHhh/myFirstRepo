package net.thumbtack.school.figures.v1;

import java.util.Objects;

public class Circle {
    private Point center;
    private int radius;

    public Circle(Point center, int radius) {
        this.center = center;
        this.radius = radius;
    }

    public Circle(int xCenter, int yCenter, int radius) {
        this.center = new Point(xCenter, yCenter);
        this.radius = radius;
    }

    public Circle(int radius) {
        this.center = new Point(0, 0);
        this.radius = radius;
    }

    public Circle() {
        this.center = new Point(0, 0);
        this.radius = 1;
    }

    public Point getCenter() {
        return center;
    }

    public int getRadius() {
        return radius;
    }

    public void setCenter(Point center) {
        this.center = center;
    }

    public void setRadius(int radius) {
        this.radius = radius;
    }

    public void moveRel(int dx, int dy) {
        setCenter(new Point(getCenter().getX() + dx, getCenter().getY() + dy));
    }

    public void moveTo(int x, int y) {
        setCenter(new Point(x, y));
    }

    public void moveTo(Point point) {
        setCenter(new Point(point.getX(), point.getY()));
    }

    public void resize(int ratio) {
        setRadius(getRadius() * ratio);
    }

    public double getArea() {
        return Math.PI * Math.pow(getRadius(), 2);
    }

    public double getPerimeter() {
        return getRadius() * 2 * Math.PI;
    }

    public boolean isInside(int x, int y) {
        return Math.pow(x - getCenter().getX(), 2) + Math.pow((y - getCenter().getY()), 2) <= Math.pow(getRadius(), 2);
    }

    public boolean isInside(Point point) {
        return Math.pow(point.getX() - getCenter().getX(), 2) + Math.pow((point.getY() - getCenter().getY()), 2) <= Math.pow(getRadius(), 2);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Circle)) return false;
        Circle circle = (Circle) o;
        return getRadius() == circle.getRadius() && getCenter().equals(circle.getCenter());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getCenter(), getRadius());
    }
}
