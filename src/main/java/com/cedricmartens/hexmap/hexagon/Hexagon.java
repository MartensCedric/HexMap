package com.cedricmartens.hexmap.hexagon;

import com.cedricmartens.hexmap.coordinate.CoordinateSystem;
import com.cedricmartens.hexmap.coordinate.Point;
import org.w3c.dom.ls.LSException;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Cedric Martens on 2017-04-27.
 */

public class Hexagon<T>
{
    private HexGeometry hexGeometry;
    private HexStyle style;
    private final CoordinateSystem coordinateSystem;
    private T hexData;
    private List<Hexagon<T>> neighbors;

    public Hexagon(Point center, CoordinateSystem coordinateSystem, HexStyle style)
    {
        this.style = style;
        hexGeometry = new HexGeometry(center, style);
        neighbors = new ArrayList<>();
        this.coordinateSystem = coordinateSystem;
    }

    public Hexagon(HexGeometry geo, CoordinateSystem coordinateSystem, HexStyle style)
    {
        this.style = style;
        this.hexGeometry = geo;
        this.coordinateSystem = coordinateSystem;
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

    public CoordinateSystem getCoordinateSystem() {
        return coordinateSystem;
    }

    public List<Hexagon<T>> getNeighbors()
    {
        return neighbors;
    }

    public void setNeighbors(List<Hexagon<T>> neighbors) {
        this.neighbors = neighbors;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Hexagon<?> hexagon = (Hexagon<?>) o;

        if (coordinateSystem != null ? !coordinateSystem.equals(hexagon.coordinateSystem) : hexagon.coordinateSystem != null) return false;
        return hexData != null ? hexData.equals(hexagon.hexData) : hexagon.hexData == null;
    }

    @Override
    public int hashCode() {
        int result = coordinateSystem != null ? coordinateSystem.hashCode() : 0;
        result = 31 * result + (hexData != null ? hexData.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Hexagon{" +
                "coordinateSystem=" + coordinateSystem +
                '}';
    }
}
