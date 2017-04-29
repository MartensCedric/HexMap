package com.cedricmartens.hexpert;

import com.cedricmartens.hexpert.coordinate.Coordinate;
import com.cedricmartens.hexpert.coordinate.CubeCoordinate;
import com.cedricmartens.hexpert.grid.HexGrid;
import com.cedricmartens.hexpert.grid.HexGridBuilder;
import com.cedricmartens.hexpert.grid.HexagonOrientation;
import com.cedricmartens.hexpert.grid.HexagonShape;
import org.junit.Assert;
import org.junit.Test;

public class HexGridBuilderTest
{
    @Test
    public void testGrid()
    {
        HexGrid<Integer> hex = new HexGridBuilder<Integer>()
                .setHeight(7)
                .setWidth(7)
                .setShape(HexagonShape.HEXAGON)
                .setStyle(new HexStyle(15, HexagonOrientation.FLAT_TOP))
                .build();
    }

    @Test
    public void testgetByCubeCoordinate()
    {
        HexGrid<Integer> hex = new HexGridBuilder<Integer>()
                .setHeight(7)
                .setWidth(7)
                .setShape(HexagonShape.HEXAGON)
                .setStyle(new HexStyle(15, HexagonOrientation.FLAT_TOP))
                .build();


        Assert.assertEquals(hex.getHexs()[0], hex.getByCoordinate(new CubeCoordinate(0, 0, 0)));
        Assert.assertEquals(hex.getHexs()[1], hex.getByCoordinate(new CubeCoordinate(1, -1, 0)));
        Assert.assertEquals(hex.getHexs()[7], hex.getByCoordinate(new CubeCoordinate(2, -2, 0)));
        Assert.assertEquals(hex.getHexs()[19], hex.getByCoordinate(new CubeCoordinate(3, -3, 0)));
        Assert.assertEquals(hex.getHexs()[23], hex.getByCoordinate(new CubeCoordinate(2, 1, -3)));
    }
}
