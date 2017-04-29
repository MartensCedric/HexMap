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


       Hexagon<Integer> hexResult = hex.getByCoordinate(new CubeCoordinate(0, 0, 0));

       System.out.println(hexResult.getCoordinate().toString());

    }
}
