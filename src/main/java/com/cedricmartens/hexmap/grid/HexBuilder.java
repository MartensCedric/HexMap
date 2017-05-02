package com.cedricmartens.hexmap.grid;

import com.cedricmartens.hexmap.HexStyle;
import com.cedricmartens.hexmap.Hexagon;
import com.cedricmartens.hexmap.coordinate.Coordinate;
import com.cedricmartens.hexmap.coordinate.Point;

/**
 * Created by Cedric on 2017-04-29.
 */
public abstract class HexBuilder<T>
{
    protected boolean built = false;
    protected Point origin;
    protected Hexagon<T>[] hexs;
    protected HexagonShape shape;
    protected HexStyle style;

    protected Class<? extends Coordinate> coordinateSystem;

    public Class<? extends Coordinate> getCoordinateSystem() {
        return coordinateSystem;
    }

    public Point getOrigin() {
        return origin;
    }

    public Hexagon<T>[] getHexs() {
        return hexs;
    }

    public HexagonShape getShape() {
        return shape;
    }

    public HexStyle getStyle() {
        return style;
    }

    public abstract HexBuilder<T> build();
}