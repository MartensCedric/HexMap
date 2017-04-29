package com.cedricmartens.hexpert;

import com.cedricmartens.hexpert.grid.HexGrid;
import com.cedricmartens.hexpert.grid.HexagonOrientation;
import com.cedricmartens.hexpert.grid.HexagonShape;
import org.junit.Test;

public class HexGridTest
{
    @Test
    public void testGrid()
    {
        HexGrid<Integer> hex = new HexGrid<Integer>()
                .setHeight(7)
                .setWidth(7)
                .setShape(HexagonShape.HEXAGON)
                .setStyle(new HexStyle(15, HexagonOrientation.FLAT_TOP))
                .build();
    }
}
