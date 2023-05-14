package net.thumbtack.school.misc.v2;

import net.thumbtack.school.figures.v2.Point;
import net.thumbtack.school.iface.v2.Filled;

public class FilledTriangle extends Triangle implements Filled {
    private int color;

    public FilledTriangle(Point point1, Point point2, Point point3, int color) {
        this(point1.getX(), point1.getY(), point2.getX(), point2.getY(), point3.getX(), point3.getY(), color);
    }

    public FilledTriangle(int oneX, int oneY, int twoX, int twoY, int threeX, int threeY, int color) {
        super(oneX, oneY, twoX, twoY, threeX, threeY);
        this.color = color;
    }

    @Override
    public void setColor(int color) {
        this.color = color;
    }

    @Override
    public int getColor() {
        return color;
    }
}
