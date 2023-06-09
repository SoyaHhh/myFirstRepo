package net.thumbtack.school.iface.v3;

import net.thumbtack.school.fillstyle.v3.FillStyle;
import net.thumbtack.school.fillstyle.v3.FillStyleException;

public interface Filled {
    void setFillStyle(FillStyle style) throws FillStyleException;

    FillStyle getFillStyle();
}
