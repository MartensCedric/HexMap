package com.cedricmartens.hexmap.coordinate;

/**
 * Created by 1544256 on 2017-04-28.
 */
public interface CoordinateSystem
{
    CubeCoordinate toCube();
    IndexedCoordinate toIndexed();
    OffsetCoordinate toOffset();
    AxialCoordinate toAxial();
}
