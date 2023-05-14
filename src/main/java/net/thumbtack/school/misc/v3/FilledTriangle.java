package net.thumbtack.school.misc.v3;

import net.thumbtack.school.figures.v3.Point;
import net.thumbtack.school.fillstyle.v3.FillStyle;
import net.thumbtack.school.fillstyle.v3.FillStyleErrorCode;
import net.thumbtack.school.fillstyle.v3.FillStyleException;
import net.thumbtack.school.iface.v3.Filled;

public class FilledTriangle extends Triangle implements Filled {

    private FillStyle style;

    public FilledTriangle(Point point1, Point point2, Point point3, FillStyle style) throws FillStyleException {
        this(point1.getX(), point1.getY(), point2.getX(), point2.getY(), point3.getX(), point3.getY(), style);
    }

    public FilledTriangle(int oneX, int oneY, int twoX, int twoY, int threeX, int threeY, FillStyle style) throws FillStyleException {
        super(oneX, oneY, twoX, twoY, threeX, threeY);
        setFillStyle(style);
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

    public FillStyle getStyle() {
        return style;
    }

    public void setStyle(FillStyle style) {
        this.style = style;
    }
}
