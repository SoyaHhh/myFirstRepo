package net.thumbtack.school.figures.v3;

import net.thumbtack.school.fillstyle.v3.FillStyle;
import net.thumbtack.school.fillstyle.v3.FillStyleErrorCode;
import net.thumbtack.school.fillstyle.v3.FillStyleException;
import net.thumbtack.school.iface.v3.Filled;

import java.util.Objects;

public class FilledEllipse extends Ellipse implements Filled {

    private FillStyle style;

    // REVU В классе должен быть только один конструктор, явно присваивающий значения полям. Остальные должны вызывать другой конструктор
    public FilledEllipse(Point center, int xAxis, int yAxis, FillStyle style) {
        super(center.getX(), center.getY(), xAxis, yAxis);
        this.style = style;
    }

    public FilledEllipse(int xCenter, int yCenter, int xAxis, int yAxis, FillStyle style) {
        this(new Point(xCenter, yCenter), xAxis, yAxis, style);
    }

    public FilledEllipse(int xAxis, int yAxis, FillStyle style) {
        this(new Point(0, 0), xAxis, yAxis, style);
    }

    public FilledEllipse(Point center, int xAxis, int yAxis, String style) throws FillStyleException {
        super(center.getX(), center.getY(), xAxis, yAxis);
        this.style = FillStyle.fillStyleFromString(style);
    }

    public FilledEllipse(FillStyle style) throws FillStyleException {
        this(new Point(0, 0), 1, 1, String.valueOf(style));
    }

    public FilledEllipse(int xCenter, int yCenter, int xAxis, int yAxis, String style) throws FillStyleException {
        this(new Point(xCenter, yCenter), xAxis, yAxis, String.valueOf(style));
    }

    public FilledEllipse(int xAxis, int yAxis, String style) throws FillStyleException {
        this(new Point(0, 0), xAxis, yAxis, String.valueOf(style));
    }

    public FilledEllipse(String style) throws FillStyleException {
        this(new Point(0, 0), 1, 1, String.valueOf(style));
    }

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
        if (!(o instanceof FilledEllipse)) return false;
        if (!super.equals(o)) return false;
        FilledEllipse that = (FilledEllipse) o;
        return style == that.style;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), style);
    }
}
