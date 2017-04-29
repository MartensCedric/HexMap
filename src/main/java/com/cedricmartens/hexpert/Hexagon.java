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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Hexagon<?> hexagon = (Hexagon<?>) o;

        if (coordinate != null ? !coordinate.equals(hexagon.coordinate) : hexagon.coordinate != null) return false;
        return hexData != null ? hexData.equals(hexagon.hexData) : hexagon.hexData == null;
    }

    @Override
    public int hashCode() {
        int result = coordinate != null ? coordinate.hashCode() : 0;
        result = 31 * result + (hexData != null ? hexData.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Hexagon{" +
                "coordinate=" + coordinate +
                '}';
    }
}
