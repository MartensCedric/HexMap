package com.cedricmartens.hexpert.coordinate;

/**
 * Created by 1544256 on 2017-04-28.
 */
public class CubeCoordinate implements Coordinate
{
    private final int x;
    private final int y;
    private final int z;

    public CubeCoordinate(int x, int y, int z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }
}
