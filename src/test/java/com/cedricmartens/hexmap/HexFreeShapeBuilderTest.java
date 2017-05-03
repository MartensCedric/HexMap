package com.cedricmartens.hexmap;

import com.cedricmartens.hexmap.coordinate.CubeCoordinate;
import com.cedricmartens.hexmap.coordinate.IndexedCoordinate;
import com.cedricmartens.hexmap.coordinate.Point;
import com.cedricmartens.hexmap.hexagon.HexGeometry;
import com.cedricmartens.hexmap.hexagon.HexStyle;
import com.cedricmartens.hexmap.hexagon.HexagonOrientation;
import com.cedricmartens.hexmap.hexagon.HexagonShape;
import com.cedricmartens.hexmap.map.HexGrid;
import com.cedricmartens.hexmap.map.freeshape.HexFreeShapeBuilder;
import com.cedricmartens.hexmap.map.grid.HexGridBuilder;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 * Created by 1544256 on 2017-05-03.
 */
public class HexFreeShapeBuilderTest
{    private static HexGrid<Integer> hex;

    @BeforeClass
    public static void initClass()
    {
        HexFreeShapeBuilder<Integer> hexFSB = new HexFreeShapeBuilder<Integer>()
                .setStyle(new HexStyle(20, HexagonOrientation.FLAT_TOP))
                .setCoordinateSystem(IndexedCoordinate.class);


        hexFSB.addHex(new Point(0, 0));
        hexFSB.addHexNextTo(0, 0);
        hexFSB.addHexNextTo(1, 2);
        hexFSB.addHexNextTo(2, 3);
        hexFSB.addHexNextTo(0, 5);
        hex = hexFSB.build();
    }

    @Test
    public void testHexSpawnLocations()
    {
        Assert.assertEquals(5, hex.getHexs().length);
        HexGeometry hex0 = hex.getHexs()[0].getHexGeometry();
        HexGeometry hex3 = hex.getHexs()[3].getHexGeometry();
        Assert.assertEquals(hex0.getMiddlePoint().x,
                            hex3.getMiddlePoint().x, 0);

        Assert.assertEquals(hex0.getMiddlePoint().y,
                hex3.getMiddlePoint().y - hex0.getHeight(), 0);
    }

}
