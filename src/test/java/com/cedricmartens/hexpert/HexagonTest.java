package com.cedricmartens.hexpert;

import com.cedricmartens.hexpert.coordinate.CubeCoordinate;
import com.cedricmartens.hexpert.grid.HexGrid;
import com.cedricmartens.hexpert.grid.HexGridBuilder;
import com.cedricmartens.hexpert.grid.HexagonOrientation;
import com.cedricmartens.hexpert.grid.HexagonShape;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 * Created by Cedric on 2017-04-29.
 */
public class HexagonTest
{
    private static HexGrid<Integer> hex;
    @BeforeClass
    public static void initClass()
    {
        hex = new HexGridBuilder<Integer>()
                .setHeight(7)
                .setWidth(7)
                .setShape(HexagonShape.HEXAGON)
                .setStyle(new HexStyle(15, HexagonOrientation.FLAT_TOP))
                .build();
    }


    @Test
    public void testPosition()
    {

    }
}
