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
    private final Coordinate coordinate;
    private T hexData;

    public Hexagon(Point center, double size, Coordinate coordinate) {
        hexGeometry = new HexGeometry(center, size, HexagonOrientation.POINTY_TOP);
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
