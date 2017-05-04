package com.cedricmartens.hexmap;

import com.cedricmartens.hexmap.coordinate.CubeCoordinate;
import com.cedricmartens.hexmap.hexagon.HexStyle;
import com.cedricmartens.hexmap.hexagon.Hexagon;
import com.cedricmartens.hexmap.hexagon.HexagonOrientation;
import com.cedricmartens.hexmap.hexagon.HexagonShape;
import com.cedricmartens.hexmap.map.HexGrid;
import com.cedricmartens.hexmap.map.grid.HexGridBuilder;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

public class HexGridBuilderTest
{
    private static HexGrid<Integer> hex;
    @BeforeClass
    public static void init()
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
    public void testNeighbors()
    {
        Hexagon<Integer> hex0 = hex.getHexs()[0];
        Hexagon<Integer> hexLast = hex.getHexs()[hex.getHexs().length - 1];

        Assert.assertEquals(6, hex0.getNeighbors().size());
        Assert.assertEquals(4, hexLast.getNeighbors().size());
    }
}
