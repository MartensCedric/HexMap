package com.cedricmartens.hexmap.coordinate;

/**
 * Created by 1544256 on 2017-05-03.
 */
public class IndexedCoordinate implements CoordinateSystem
{
    private int i;

    public IndexedCoordinate(int i)
    {
        this.i = i;
    }

    public int getIndex() {
        return i;
    }

    @Override
    public CubeCoordinate toCube() {
        return null;
    }

    @Override
    public IndexedCoordinate toIndexed() {
        return this;
    }

    @Override
    public OffsetCoordinate toOffset() {
        return null;
    }

    @Override
    public AxialCoordinate toAxial() {
        return null;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        IndexedCoordinate that = (IndexedCoordinate) o;

        return i == that.i;
    }

    @Override
    public int hashCode() {
        return i;
    }

    @Override
    public String toString() {
        return "IndexedCoordinate{" +
                "i=" + i +
                '}';
    }
}
