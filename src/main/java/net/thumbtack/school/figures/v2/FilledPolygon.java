package net.thumbtack.school.figures.v2;

import net.thumbtack.school.iface.v2.Filled;

import java.util.Objects;

public class FilledPolygon extends Polygon implements Filled {
    private int color;

    public FilledPolygon(Point[] points, int color) {
        super(points);
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
        if (!(o instanceof FilledPolygon)) return false;
        if (!super.equals(o)) return false;
        FilledPolygon that = (FilledPolygon) o;
        return getColor() == that.getColor();
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), getColor());
    }
}
