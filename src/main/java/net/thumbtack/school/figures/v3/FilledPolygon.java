package net.thumbtack.school.figures.v3;

import net.thumbtack.school.fillstyle.v3.FillStyle;
import net.thumbtack.school.fillstyle.v3.FillStyleErrorCode;
import net.thumbtack.school.fillstyle.v3.FillStyleException;
import net.thumbtack.school.iface.v3.Filled;

import java.util.Objects;

public class FilledPolygon extends Polygon implements Filled {

    private FillStyle style;

    // REVU В классе должен быть только один конструктор, явно присваивающий значения полям. Остальные должны вызывать другой конструктор
    public FilledPolygon(Point[] points, FillStyle style) throws FillStyleException {
        super(points);
        setFillStyle(style);
    }

    public FilledPolygon(Point[] points, String style) throws FillStyleException {
        this(points, FillStyle.fillStyleFromString(style));
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
        if (!(o instanceof FilledPolygon)) return false;
        if (!super.equals(o)) return false;
        FilledPolygon that = (FilledPolygon) o;
        return style == that.style;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), style);
    }
}
