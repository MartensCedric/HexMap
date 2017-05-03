package com.cedricmartens.hexmap;

import com.cedricmartens.hexmap.coordinate.CubeCoordinate;
import com.cedricmartens.hexmap.hexagon.HexStyle;
import com.cedricmartens.hexmap.hexagon.HexagonOrientation;
import com.cedricmartens.hexmap.hexagon.HexagonShape;
import com.cedricmartens.hexmap.map.HexGrid;
import com.cedricmartens.hexmap.map.grid.HexGridBuilder;
import org.junit.Test;

public class HexGridBuilderTest
{
    @Test (timeout = 1000)
    public void testGrid()
    {
        HexGrid<Integer> hex = new HexGridBuilder<Integer>()
                .setHeight(7)
                .setWidth(7)
                .setShape(HexagonShape.HEXAGON)
                .setStyle(new HexStyle(15, HexagonOrientation.FLAT_TOP))
                .setCoordinateSystem(CubeCoordinate.class)
                .build();
    }
}
