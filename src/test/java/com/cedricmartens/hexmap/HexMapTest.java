package com.cedricmartens.hexmap;

import com.cedricmartens.hexmap.coordinate.CubeCoordinate;
import com.cedricmartens.hexmap.hexagon.HexStyle;
import com.cedricmartens.hexmap.hexagon.HexagonOrientation;
import com.cedricmartens.hexmap.hexagon.HexagonShape;
import com.cedricmartens.hexmap.map.HexMap;
import com.cedricmartens.hexmap.map.grid.HexGridBuilder;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 * Created by Cedric on 2017-04-29.
 */
public class HexMapTest
{
    private static HexMap<Integer> hex;

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
    public void testgetByCubeCoordinate()
    {
        Assert.assertEquals(hex.getHexs()[0], hex.getByCoordinate(new CubeCoordinate(0, 0, 0)));
        Assert.assertEquals(hex.getHexs()[1], hex.getByCoordinate(new CubeCoordinate(1, -1, 0)));
        Assert.assertEquals(hex.getHexs()[7], hex.getByCoordinate(new CubeCoordinate(2, -2, 0)));
        Assert.assertEquals(hex.getHexs()[19], hex.getByCoordinate(new CubeCoordinate(3, -3, 0)));
        Assert.assertEquals(hex.getHexs()[23], hex.getByCoordinate(new CubeCoordinate(2, 1, -3)));
    }

    @Test
    public void testCoordinateExists()
    {
        Assert.assertTrue(hex.coordinateExists(new CubeCoordinate(0, 0, 0)));
        Assert.assertTrue(hex.coordinateExists(new CubeCoordinate(-3, 1, 2)));
        Assert.assertTrue(hex.coordinateExists(new CubeCoordinate(-2, 1, 1)));

        Assert.assertFalse(hex.coordinateExists(new CubeCoordinate(5, -3, -2)));
    }

    @Test
    public void testgetRandom()
    {
        Assert.assertNotNull(hex.getRandom());
    }
}
