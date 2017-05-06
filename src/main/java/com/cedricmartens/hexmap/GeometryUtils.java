package com.cedricmartens.hexmap;

import com.cedricmartens.hexmap.coordinate.Point;
import com.cedricmartens.hexmap.hexagon.HexStyle;
import com.cedricmartens.hexmap.hexagon.HexagonOrientation;

/**
 * Created by Cedric on 2017-05-05.
 */
public class GeometryUtils
{
    public static double getHexWidth(double size, HexagonOrientation orientation)
    {
        return orientation == HexagonOrientation.POINTY_TOP ?
                Math.sqrt(3)/2 * getHexHeight(size, orientation) :
                size * 2;
    }

    public static double getHexHeight(double size, HexagonOrientation orientation)
    {
        return orientation == HexagonOrientation.POINTY_TOP ?
                size * 2 :
                Math.sqrt(3)/2 * getHexWidth(size, orientation);
    }

    public static double getHexHorizontalDist(double size, HexagonOrientation orientation)
    {
        return orientation == HexagonOrientation.POINTY_TOP ?
                getHexWidth(size, orientation) :
                getHexWidth(size, orientation) * 3.0/4.0;
    }

    public static double getHexVerticalDist(double size, HexagonOrientation orientation)
    {
        return orientation == HexagonOrientation.POINTY_TOP ?
                getHexHeight(size, orientation) * 3.0/4.0 :
                getHexHeight(size, orientation);
    }

    public static Point getPointAtSide(Point p, int side, HexStyle style)
    {

        if(side >= 6 || side < 0)
            throw new IllegalArgumentException();

        double x;
        double y;

        //for flat top
        // TODO: 5/6/17  Make this for pointy top also
        switch (side)
        {
            case 0:
                x = p.x + GeometryUtils.getHexHorizontalDist(style.getSize(), style.getOrientation());
                y = p.y - GeometryUtils.getHexVerticalDist(style.getSize(), style.getOrientation())/2.0;
                break;
            case 1:
                x = p.x + GeometryUtils.getHexHorizontalDist(style.getSize(), style.getOrientation());
                y = p.y + GeometryUtils.getHexVerticalDist(style.getSize(), style.getOrientation())/2.0;
                break;
            case 2:
                x = p.x;
                y = p.y + GeometryUtils.getHexVerticalDist(style.getSize(), style.getOrientation());
                break;
            case 3:
                x = p.x - GeometryUtils.getHexHorizontalDist(style.getSize(), style.getOrientation());
                y = p.y + GeometryUtils.getHexVerticalDist(style.getSize(), style.getOrientation())/2.0;
                break;
            case 4:
                x = p.x - GeometryUtils.getHexHorizontalDist(style.getSize(), style.getOrientation());
                y = p.y - GeometryUtils.getHexVerticalDist(style.getSize(), style.getOrientation())/2.0;
                break;
            case 5:
                x = p.x;
                y = p.y - GeometryUtils.getHexVerticalDist(style.getSize(), style.getOrientation());
                break;
            default:
                throw new IllegalStateException();
        }
        return new Point(x, y);
    }
}
