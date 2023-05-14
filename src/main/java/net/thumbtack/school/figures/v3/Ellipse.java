package net.thumbtack.school.figures.v3;

import net.thumbtack.school.iface.v3.HasPerimeter;

import java.util.Objects;

public class Ellipse extends ClosedFigure implements HasPerimeter {
    private int xAxis;
    private int yAxis;
    private Point center;

    // REVU В классе должен быть только один конструктор, явно присваивающий значения полям. Остальные должны вызывать другой конструктор
    public Ellipse(Point center, int xAxis, int yAxis) {
        this.center = center;
        this.xAxis = xAxis;
        this.yAxis = yAxis;
    }

    public Ellipse(int xCenter, int yCenter, int xAxis, int yAxis) {
        this(new Point(xCenter, yCenter), xAxis, yAxis);
    }

    public Ellipse(int xAxis, int yAxis) {
        this(new Point(0, 0), xAxis, yAxis);
    }

    public Ellipse() {
        this(new Point(0, 0), 1, 1);
    }

    public int getXAxis() {
        return xAxis;
    }

    public void setXAxis(int xAxis) {
        this.xAxis = xAxis;
    }

    public int getYAxis() {
        return yAxis;
    }

    public void setYAxis(int yAxis) {
        this.yAxis = yAxis;
    }

    public Point getCenter() {
        return center;
    }

    public void setCenter(Point center) {
        this.center = center;
    }

    public void moveTo(int x, int y) {
        setCenter(new Point(x, y));
    }

    public void moveRel(int dx, int dy) {
        center.moveRel(dx, dy);
    }

    public void resize(int ratio) {
        setXAxis(getXAxis() * ratio);
        setYAxis(getYAxis() * ratio);
    }

    public double getArea() {
        return Math.PI * (getXAxis() * getYAxis()) / 4;
    }

    public double getPerimeter() {
        return 2 * Math.PI * Math.sqrt(((Math.pow(getXAxis(), 2)) + Math.pow(getYAxis(), 2)) / 8);
    }

    public boolean isInside(int x, int y) {
        double a = xAxis / 2;
        double b = yAxis / 2;
        x -= getCenter().getX();
        y -= getCenter().getY();
        return ((x * x) / (a * a) + (y * y) / (b * b) <= 1.);
    }

    public boolean isInside(Point point) {
        double a = xAxis / 2;
        double b = yAxis / 2;
        double x1 = point.getX();
        double y1 = point.getY();
        x1 -= getCenter().getX();
        y1 -= getCenter().getY();
        return ((x1 * x1) / (a * a) + (y1 * y1) / (b * b) <= 1.);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Ellipse)) return false;
        Ellipse ellipse = (Ellipse) o;
        return xAxis == ellipse.xAxis && yAxis == ellipse.yAxis && getCenter().equals(ellipse.getCenter());
    }

    @Override
    public int hashCode() {
        return Objects.hash(xAxis, yAxis, getCenter());
    }
}

