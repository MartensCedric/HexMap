package com.cedricmartens.hexpert;

import com.cedricmartens.hexpert.coordinate.Coordinate;
import com.cedricmartens.hexpert.coordinate.Point;
import com.cedricmartens.hexpert.grid.HexagonOrientation;

/**
 * Created by Cedric Martens on 2017-04-27.
 */

public class Hexagon<T>
{
    private HexGeometry hexGeometry;
    private HexStyle style;
    private final Coordinate coordinate;
    private T hexData;

    public Hexagon(Point center, Coordinate coordinate, HexStyle style)
    {
        this.style = style;
        hexGeometry = new HexGeometry(center, style);
        this.coordinate = coordinate;
    }

    public HexGeometry getHexGeometry() {
        return hexGeometry;
    }

    public void setHexGeometry(HexGeometry hexGeometry) {
        this.hexGeometry = hexGeometry;
    }

    public T getHexData() {
        return hexData;
    }

    public void setHexData(T hexData) {
        this.hexData = hexData;
    }

    public Coordinate getCoordinate() {
        return coordinate;
    }
}
