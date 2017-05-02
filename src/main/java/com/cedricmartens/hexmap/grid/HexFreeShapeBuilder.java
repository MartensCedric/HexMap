package com.cedricmartens.hexmap.grid;

import com.cedricmartens.hexmap.HexGeometry;
import com.cedricmartens.hexmap.HexStyle;
import com.cedricmartens.hexmap.coordinate.Coordinate;
import com.cedricmartens.hexmap.coordinate.Point;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Cedric Martens on 2017-05-02.
 */
public class HexFreeShapeBuilder<T> extends HexBuilder
{
    private List<HexGeometry> hexGeometries;

    public HexFreeShapeBuilder()
    {
        origin = new Point(0, 0);
        hexGeometries = new ArrayList<HexGeometry>();
        shape = HexagonShape.FREE;
    }

    public void setStyle(HexStyle style)
    {
        this.style = style;
    }

    public void setCoordinateSystem(Class<? extends Coordinate> coordinateSystem)
    {
        this.coordinateSystem = coordinateSystem;
    }

    public void addHex(Point p)
    {
        hexGeometries.add(new HexGeometry(p, style));
    }

    public void addHexNextTo(int n, int side)
    {
        addHexNextTo(hexGeometries.get(n), side);
    }

    public void addHexNextTo(HexGeometry hexGeometry, int side)
    {
        if(side >= 6)
            throw new HexBuildException();

        double degrees = side * 60;
        degrees += style.getOrientation() == HexagonOrientation.POINTY_TOP ? 30 : 0;
        double rad = Math.PI/180.0 * degrees;
        double x = hexGeometry.getMiddlePoint().x + style.getSize() * Math.cos(rad);
        double y = hexGeometry.getMiddlePoint().y + style.getSize() * Math.sin(rad);
        hexGeometries.add(new HexGeometry(new Point(x, y), style));
    }

    public HexBuilder build() {
        return null;
    }
}
