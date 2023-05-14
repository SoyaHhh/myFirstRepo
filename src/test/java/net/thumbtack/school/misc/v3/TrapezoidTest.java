package net.thumbtack.school.misc.v3;

import net.thumbtack.school.figures.v2.Point;
import net.thumbtack.school.misc.v2.Trapezoid;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

class TrapezoidTest {
    private static final double DOUBLE_EPS = 1E-6;

    @Test
    public void testTrapezoid() {
        Point point1 = new Point(10, 20);
        Point point2 = new Point(20, 10);
        Point point3 = new Point(40, 20);
        Point point4 = new Point(50, 50);
        net.thumbtack.school.misc.v2.Trapezoid trapezoid = new net.thumbtack.school.misc.v2.Trapezoid(point1, point2, point3, point4);
        assertAll(
                () -> assertEquals(10, trapezoid.getPoint1().getX()),
                () -> assertEquals(20, trapezoid.getPoint1().getY()),
                () -> assertEquals(20, trapezoid.getPoint2().getX()),
                () -> assertEquals(10, trapezoid.getPoint2().getY()),
                () -> assertEquals(40, trapezoid.getPoint3().getX()),
                () -> assertEquals(20, trapezoid.getPoint3().getY()),
                () -> assertEquals(50, trapezoid.getPoint4().getX()),
                () -> assertEquals(50, trapezoid.getPoint4().getY()),
                () -> assertEquals(23655, trapezoid.getArea()),
                () -> assertEquals(118.12559200041264, trapezoid.getPerimeter(), DOUBLE_EPS)
        );
    }

    @Test
    public void testMoveTrapezoid() {
        net.thumbtack.school.misc.v2.Trapezoid trapezoid = new net.thumbtack.school.misc.v2.Trapezoid(new Point(10, 20), new Point(20, 10), new Point(40, 20), new Point(50, 50));
        trapezoid.moveRel(25, 45);
        assertAll(
                () -> assertEquals(35, trapezoid.getPoint1().getX()),
                () -> assertEquals(65, trapezoid.getPoint1().getY()),
                () -> assertEquals(45, trapezoid.getPoint2().getX()),
                () -> assertEquals(55, trapezoid.getPoint2().getY()),
                () -> assertEquals(65, trapezoid.getPoint3().getX()),
                () -> assertEquals(65, trapezoid.getPoint3().getY()),
                () -> assertEquals(75, trapezoid.getPoint4().getX()),
                () -> assertEquals(95, trapezoid.getPoint4().getY())
        );
        trapezoid.moveTo(10, 20);
        assertAll(
                () -> assertEquals(10, trapezoid.getPoint1().getX()),
                () -> assertEquals(20, trapezoid.getPoint1().getY()),
                () -> assertEquals(20, trapezoid.getPoint2().getX()),
                () -> assertEquals(10, trapezoid.getPoint2().getY()),
                () -> assertEquals(40, trapezoid.getPoint3().getX()),
                () -> assertEquals(20, trapezoid.getPoint3().getY()),
                () -> assertEquals(50, trapezoid.getPoint4().getX()),
                () -> assertEquals(50, trapezoid.getPoint4().getY())
        );
        trapezoid.moveTo(new Point(100, 200));
        assertAll(
                () -> assertEquals(100, trapezoid.getPoint1().getX()),
                () -> assertEquals(200, trapezoid.getPoint1().getY()),
                () -> assertEquals(110, trapezoid.getPoint2().getX()),
                () -> assertEquals(190, trapezoid.getPoint2().getY()),
                () -> assertEquals(130, trapezoid.getPoint3().getX()),
                () -> assertEquals(200, trapezoid.getPoint3().getY()),
                () -> assertEquals(140, trapezoid.getPoint4().getX()),
                () -> assertEquals(230, trapezoid.getPoint4().getY())
        );
    }

    @Test
    public void testResizeTrapezoid() {
        net.thumbtack.school.misc.v2.Trapezoid trapezoid = new Trapezoid(new Point(10, 20), new Point(20, 10), new Point(40, 20), new Point(50, 50));
        trapezoid.resize(3);
        assertAll(
                () -> assertEquals(10, trapezoid.getPoint1().getX()),
                () -> assertEquals(20, trapezoid.getPoint1().getY()),
                () -> assertEquals(40, trapezoid.getPoint2().getX()),
                () -> assertEquals(-10, trapezoid.getPoint2().getY()),
                () -> assertEquals(100, trapezoid.getPoint3().getX()),
                () -> assertEquals(20, trapezoid.getPoint3().getY()),
                () -> assertEquals(140, trapezoid.getPoint4().getX()),
                () -> assertEquals(110, trapezoid.getPoint4().getY())
        );
    }
}