package com.cedricmartens.hexpert.coordinate;

/**
 * Created by 1544256 on 2017-04-28.
 */
public class OffsetCoordinate implements Coordinate
{
    private final int x;
    private final int y;

    public OffsetCoordinate(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
