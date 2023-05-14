package net.thumbtack.school.figures.v1;

import java.util.Objects;

public class FilledEllipse extends Ellipse {

    private int color;

    public FilledEllipse(Point center, int xAxis, int yAxis, int color) {
        super(center.getX(), center.getY(), xAxis, yAxis);
        this.color = color;
    }

    public FilledEllipse(int xCenter, int yCenter, int xAxis, int yAxis, int color) {
        super(xCenter, yCenter, xAxis, yAxis);
        this.color = color;
    }

    public FilledEllipse(int xAxis, int yAxis, int color) {
        super(xAxis, yAxis);
        this.color = color;
    }

    public FilledEllipse(int color) {
        super(0, 0, 1, 1);
        this.color = color;
    }

    public int getColor() {
        return color;
    }

    public void setColor(int color) {
        this.color = color;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof FilledEllipse)) return false;
        if (!super.equals(o)) return false;
        FilledEllipse that = (FilledEllipse) o;
        return getColor() == that.getColor();
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), getColor());
    }
}
