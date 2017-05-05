package com.cedricmartens.hexmap;

import com.cedricmartens.hexmap.coordinate.CubeCoordinate;
import com.cedricmartens.hexmap.coordinate.IndexedCoordinate;
import org.junit.Assert;
import org.junit.Test;

/**
 * Created by Shawn Martens on 2017-05-04.
 */
public class CoordinateConversionTest
{
    @Test
    public void testCubeToIndex()
    {
        CubeCoordinate cubeCoordinate = new CubeCoordinate(0, 0, 0);

        Assert.assertEquals(new IndexedCoordinate(0), cubeCoordinate.toIndexed());

        cubeCoordinate = new CubeCoordinate(2, 0, -2);

        Assert.assertEquals(new IndexedCoordinate(9), cubeCoordinate.toIndexed());
    }
}
