package com.cedricmartens.hexmap;

import com.cedricmartens.hexmap.coordinate.CubeCoordinate;
import com.cedricmartens.hexmap.hexagon.HexStyle;
import com.cedricmartens.hexmap.hexagon.HexagonOrientation;
import com.cedricmartens.hexmap.hexagon.HexagonShape;
import com.cedricmartens.hexmap.map.HexGrid;
import com.cedricmartens.hexmap.map.grid.HexGridBuilder;
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
                .setCoordinateSystem(CubeCoordinate.class)
                .build();
    }


    @Test
    public void testPosition()
    {

    }
}
