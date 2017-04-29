package com.cedricmartens.hexpert.coordinate;

/**
 * Created by 1544256 on 2017-04-28.
 */
public class CubeCoordinate implements Coordinate
{
    private final int x;
    private final int y;
    private final int z;

    public CubeCoordinate(int x, int y, int z)
    {
        if(x + y + z != 0)
            throw new InvalidCubeCoordinate();

        this.x = x;
        this.y = y;
        this.z = z;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CubeCoordinate that = (CubeCoordinate) o;

        if (x != that.x) return false;
        if (y != that.y) return false;
        return z == that.z;
    }

    @Override
    public String toString() {
        return "CubeCoordinate{" +
                "x=" + x +
                ", y=" + y +
                ", z=" + z +
                '}';
    }
}
