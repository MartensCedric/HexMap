package com.cedricmartens.hexmap;

import com.cedricmartens.hexmap.coordinate.Point;
import com.cedricmartens.hexmap.hexagon.HexStyle;
import com.cedricmartens.hexmap.hexagon.HexagonOrientation;

/**
 * Created by Cedric on 2017-05-05.
 */
public class GeometryUtils
{
    public static final double HEX_SLOPE = 1.7320508075688774;
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

    public static boolean isBetweenSlopes(Point p, Point sp1, Point sp2, double s1, double s2)
    {
        return isBetween(p.y, origin(sp1, s1) + p.x * s1, origin(sp2, s2) + p.x * s2);
    }

    public static boolean isBetweenSlopes(Point p, Point sp1, Point sp2, double slope)
    {
        return isBetweenSlopes(p, sp1, sp2, slope, slope);
    }

    public static boolean isBetween(double n, double lowerLimit, double higherLimit)
    {
        return (n >= lowerLimit && n <= higherLimit) || (n >= higherLimit && n <= lowerLimit);
    }

    public static boolean isInside(float x, float y, float lowX, float lowY, float highX, float highY)
    {
        return isBetween(x, lowX, highX) && isBetween(y, lowY, highY);
    }

    public static double distanceToPoint(double x1, double y1, double x2, double y2) {
        return Math.sqrt((x1 - x2) * (x1 - x2) + (y1 - y2) * (y1 - y2));
    }

    public static double origin(Point p, double slope)
    {
        return p.y - p.x * slope;
    }
}
