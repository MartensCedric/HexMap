package com.cedricmartens.hexmap.coordinate;

/**
 * Created by 1544256 on 2017-04-28.
 */
public class OffsetCoordinate implements CoordinateSystem
{
    private final int x;
    private final int y;

    public OffsetCoordinate(int x, int y) {
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
        return this;
    }

    @Override
    public AxialCoordinate toAxial() {
        return null;
    }
}
