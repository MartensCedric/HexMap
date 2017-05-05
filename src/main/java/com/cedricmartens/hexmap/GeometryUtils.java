package com.cedricmartens.hexmap;

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
}
