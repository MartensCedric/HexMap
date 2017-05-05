package com.cedricmartens.hexmap.coordinate;

/**
 * Created by 1544256 on 2017-04-28.
 */
public class AxialCoordinate implements CoordinateSystem
{
    public final int x;
    public final int y;

    public AxialCoordinate(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public CubeCoordinate toCube() {
        return null;
    }

    @Override
    public IndexedCoordinate toIndexed() {
        return null;
    }

    @Override
    public OffsetCoordinate toOffset() {
        return null;
    }

    @Override
    public AxialCoordinate toAxial() {
        return this;
    }
}
