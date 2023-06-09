package net.thumbtack.school.figures.v2;

import net.thumbtack.school.iface.v2.Filled;

import java.util.Objects;

public class FilledCircle extends Circle implements Filled {

    private int color;

    public FilledCircle(Point center, int radius, int color) {
        super(center.getX(), center.getY(), radius);
        this.color = color;
    }

    public FilledCircle(int xCenter, int yCenter, int radius, int color) {
        super(xCenter, yCenter, radius);
        this.color = color;
    }

    public FilledCircle(int radius, int color) {
        super(0, 0, radius);
        this.color = color;
    }

    public FilledCircle(int color) {
        super(0, 0, 1);
        this.color = color;
    }

    public FilledCircle() {
        super(0, 0, 1);
        this.color = 1;
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
        if (!(o instanceof FilledCircle)) return false;
        if (!super.equals(o)) return false;
        FilledCircle that = (FilledCircle) o;
        return getColor() == that.getColor();
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), getColor());
    }
}
