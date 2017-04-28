package com.cedricmartens.hexpert;

import com.cedricmartens.hexpert.coordinate.Point;

/**
 * Created by Cedric Martens on 2017-04-27.
 */

public class Hexagon<T extends HexagonData>
{
    private HexCoord hexCoord;

    public Hexagon(Point center, double size) {
        hexCoord = new HexCoord(center, size, HexagonOrientation.POINTY_TOP);
    }
}
