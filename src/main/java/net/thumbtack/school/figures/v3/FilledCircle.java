package net.thumbtack.school.figures.v3;

import net.thumbtack.school.fillstyle.v3.FillStyle;
import net.thumbtack.school.fillstyle.v3.FillStyleErrorCode;
import net.thumbtack.school.fillstyle.v3.FillStyleException;
import net.thumbtack.school.iface.v3.Filled;

import java.util.Objects;

public class FilledCircle extends Circle implements Filled {

    private FillStyle style;

    // REVU В классе должен быть только один конструктор, явно присваивающий значения полям. Остальные должны вызывать другой конструктор
    public FilledCircle(Point center, int radius, FillStyle style) {
        super(center.getX(), center.getY(), radius);
        this.style = style;
    }

    public FilledCircle(Point center, int radius, String style) throws FillStyleException {
        super(center.getX(), center.getY(), radius);
        this.style = FillStyle.fillStyleFromString(style);
    }

    public FilledCircle(int xCenter, int yCenter, int radius, FillStyle style) {
        this(new Point(xCenter, yCenter), radius, style);
    }

    public FilledCircle(int xCenter, int yCenter, int radius, String style) throws FillStyleException {
        this(new Point(xCenter, yCenter), radius, style);
    }

    public FilledCircle(int radius, FillStyle style) {
        this(new Point(0, 0), radius, style);
    }

    public FilledCircle(int radius, String style) throws FillStyleException {
        this(new Point(0, 0), radius, FillStyle.fillStyleFromString(style));
    }

    public FilledCircle(FillStyle style) throws FillStyleException {
        this(new Point(0, 0), 1, String.valueOf(style));
    }

    public FilledCircle(String style) throws FillStyleException {
        this(new Point(0, 0), 1, String.valueOf(style));
    }

    public FilledCircle() {
        this(new Point(0, 0), 1, FillStyle.SOLID_RED);
    }

    @Override
    public void setFillStyle(FillStyle style) throws FillStyleException {
        if (style == null)
            throw new FillStyleException(FillStyleErrorCode.NULL_FILL_STYLE);
        else
            this.style = style;
    }

    @Override
    public FillStyle getFillStyle() {
        return style;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof FilledCircle)) return false;
        if (!super.equals(o)) return false;
        FilledCircle that = (FilledCircle) o;
        return style == that.style;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), style);
    }
}
