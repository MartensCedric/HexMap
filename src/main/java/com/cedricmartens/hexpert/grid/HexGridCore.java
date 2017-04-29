package com.cedricmartens.hexpert.grid;

import com.cedricmartens.hexpert.HexStyle;
import com.cedricmartens.hexpert.Hexagon;
import com.cedricmartens.hexpert.coordinate.Coordinate;
import com.cedricmartens.hexpert.coordinate.Point;

/**
 * Created by Cedric on 2017-04-29.
 */
public abstract class HexGridCore<T>
{
    protected Point origin;
    protected Hexagon<T>[] hexs;
    protected OffsetLayout layout;
    protected HexagonShape shape;
    protected HexStyle style;
    protected int width;
    protected int height;
    protected Class<? extends Coordinate> coordinate;

    public Class<? extends Coordinate> getCoordinateSystem() {
        return coordinate;
    }

    public Point getOrigin() {
        return origin;
    }

    public Hexagon<T>[] getHexs() {
        return hexs;
    }

    public OffsetLayout getLayout() {
        return layout;
    }

    public HexagonShape getShape() {
        return shape;
    }

    public HexStyle getStyle() {
        return style;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }
}
