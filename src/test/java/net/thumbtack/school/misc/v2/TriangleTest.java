package net.thumbtack.school.misc.v2;

import net.thumbtack.school.figures.v2.Point;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TriangleTest {

    private static final double DOUBLE_EPS = 1E-6;

    @Test
    public void testTriangle() {
        Point point1 = new Point(10, 20);
        Point point2 = new Point(30, 10);
        Point point3 = new Point(20, 30);
        Triangle triangle = new Triangle(point1, point2, point3);
        assertAll(
                () -> assertEquals(10, triangle.getPoint1().getX()),
                () -> assertEquals(20, triangle.getPoint1().getY()),
                () -> assertEquals(30, triangle.getPoint2().getX()),
                () -> assertEquals(10, triangle.getPoint2().getY()),
                () -> assertEquals(20, triangle.getPoint3().getX()),
                () -> assertEquals(30, triangle.getPoint3().getY()),
                () -> assertEquals(150, triangle.getArea()),
                () -> assertEquals(58.863495, triangle.getPerimeter(), DOUBLE_EPS)
        );
    }

    @Test
    public void testMoveTriangle() {
        Point point1 = new Point(10, 20);
        Point point2 = new Point(30, 10);
        Point point3 = new Point(20, 30);
        Triangle triangle = new Triangle(point1, point2, point3);
        triangle.moveRel(100, 50);
        assertAll(
                () -> assertEquals(110, triangle.getPoint1().getX()),
                () -> assertEquals(70, triangle.getPoint1().getY()),
                () -> assertEquals(130, triangle.getPoint2().getX()),
                () -> assertEquals(60, triangle.getPoint2().getY()),
                () -> assertEquals(120, triangle.getPoint3().getX()),
                () -> assertEquals(80, triangle.getPoint3().getY())
        );

        triangle.moveTo(50, 20);
        assertAll(
                () -> assertEquals(50, triangle.getPoint1().getX()),
                () -> assertEquals(20, triangle.getPoint1().getY()),
                () -> assertEquals(70, triangle.getPoint2().getX()),
                () -> assertEquals(10, triangle.getPoint2().getY()),
                () -> assertEquals(60, triangle.getPoint3().getX()),
                () -> assertEquals(30, triangle.getPoint3().getY())
        );

        triangle.moveTo(new Point(1110, 1070));
        assertAll(
                () -> assertEquals(1110, triangle.getPoint1().getX()),
                () -> assertEquals(1070, triangle.getPoint1().getY()),
                () -> assertEquals(1130, triangle.getPoint2().getX()),
                () -> assertEquals(1060, triangle.getPoint2().getY()),
                () -> assertEquals(1120, triangle.getPoint3().getX()),
                () -> assertEquals(1080, triangle.getPoint3().getY())
        );
    }
}