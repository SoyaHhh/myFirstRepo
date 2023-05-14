package net.thumbtack.school.misc.v3;

import net.thumbtack.school.figures.v3.Point;
import net.thumbtack.school.fillstyle.v3.FillStyleException;
import org.junit.jupiter.api.Test;

import static net.thumbtack.school.fillstyle.v3.FillStyle.SOLID_RED;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

class FilledTriangleTest {
    private static final double DOUBLE_EPS = 1E-6;

    @Test
    public void TestFilledTriangle1() throws FillStyleException {
        Point point1 = new Point(10, 20);
        Point point2 = new Point(30, 10);
        Point point3 = new Point(20, 30);
        FilledTriangle filledTriangle = new FilledTriangle(point1, point2, point3, SOLID_RED);
        assertAll(
                () -> assertEquals(10, filledTriangle.getPoint1().getX()),
                () -> assertEquals(20, filledTriangle.getPoint1().getY()),
                () -> assertEquals(30, filledTriangle.getPoint2().getX()),
                () -> assertEquals(10, filledTriangle.getPoint2().getY()),
                () -> assertEquals(20, filledTriangle.getPoint3().getX()),
                () -> assertEquals(30, filledTriangle.getPoint3().getY()),
                () -> assertEquals(150, filledTriangle.getArea()),
                () -> assertEquals(58.863495, filledTriangle.getPerimeter(), DOUBLE_EPS),
                () -> assertEquals(SOLID_RED, filledTriangle.getStyle())
        );
    }

    @Test
    public void TestFilledTriangle2() throws FillStyleException {
        FilledTriangle filledTriangle = new FilledTriangle(10, 20, 30, 10, 20, 30, SOLID_RED);
        assertAll(
                () -> assertEquals(10, filledTriangle.getPoint1().getX()),
                () -> assertEquals(20, filledTriangle.getPoint1().getY()),
                () -> assertEquals(30, filledTriangle.getPoint2().getX()),
                () -> assertEquals(10, filledTriangle.getPoint2().getY()),
                () -> assertEquals(20, filledTriangle.getPoint3().getX()),
                () -> assertEquals(30, filledTriangle.getPoint3().getY()),
                () -> assertEquals(150, filledTriangle.getArea()),
                () -> assertEquals(58.863495, filledTriangle.getPerimeter(), DOUBLE_EPS),
                () -> assertEquals(SOLID_RED, filledTriangle.getStyle())
        );
    }

    @Test
    public void testMoveFilledTriangle() throws FillStyleException {
        Point point1 = new Point(10, 20);
        Point point2 = new Point(30, 10);
        Point point3 = new Point(20, 30);
        FilledTriangle filledTriangle = new FilledTriangle(point1, point2, point3, SOLID_RED);
        filledTriangle.moveRel(100, 50);
        assertAll(
                () -> assertEquals(110, filledTriangle.getPoint1().getX()),
                () -> assertEquals(70, filledTriangle.getPoint1().getY()),
                () -> assertEquals(130, filledTriangle.getPoint2().getX()),
                () -> assertEquals(60, filledTriangle.getPoint2().getY()),
                () -> assertEquals(120, filledTriangle.getPoint3().getX()),
                () -> assertEquals(80, filledTriangle.getPoint3().getY())
        );

        filledTriangle.moveTo(50, 20);
        assertAll(
                () -> assertEquals(50, filledTriangle.getPoint1().getX()),
                () -> assertEquals(20, filledTriangle.getPoint1().getY()),
                () -> assertEquals(70, filledTriangle.getPoint2().getX()),
                () -> assertEquals(10, filledTriangle.getPoint2().getY()),
                () -> assertEquals(60, filledTriangle.getPoint3().getX()),
                () -> assertEquals(30, filledTriangle.getPoint3().getY())
        );

        filledTriangle.moveTo(new Point(1110, 1070));
        assertAll(
                () -> assertEquals(1110, filledTriangle.getPoint1().getX()),
                () -> assertEquals(1070, filledTriangle.getPoint1().getY()),
                () -> assertEquals(1130, filledTriangle.getPoint2().getX()),
                () -> assertEquals(1060, filledTriangle.getPoint2().getY()),
                () -> assertEquals(1120, filledTriangle.getPoint3().getX()),
                () -> assertEquals(1080, filledTriangle.getPoint3().getY())
        );
    }

}