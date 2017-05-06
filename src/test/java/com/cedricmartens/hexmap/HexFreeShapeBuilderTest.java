package com.cedricmartens.hexmap;

import com.cedricmartens.hexmap.coordinate.Point;
import com.cedricmartens.hexmap.hexagon.HexGeometry;
import com.cedricmartens.hexmap.hexagon.HexStyle;
import com.cedricmartens.hexmap.hexagon.HexagonOrientation;
import com.cedricmartens.hexmap.map.HexMap;
import com.cedricmartens.hexmap.map.freeshape.HexFreeShapeBuilder;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 * Created by 1544256 on 2017-05-03.
 */
public class HexFreeShapeBuilderTest
{    private static HexMap<Integer> hex;

    @BeforeClass
    public static void initClass()
    {
        HexFreeShapeBuilder<Integer> hexFSB = new HexFreeShapeBuilder<Integer>()
                .setStyle(new HexStyle(20, HexagonOrientation.FLAT_TOP));


        hexFSB.addHex(new Point(0, 0));
        hexFSB.addHexNextTo(0, 0);
        hexFSB.addHexNextTo(1, 2);
        hexFSB.addHexNextTo(2, 3);
        hexFSB.addHexNextTo(0, 4);
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
                hex3.getMiddlePoint().y - hex3.getHeight(), 0);
    }

    @Test
    public void testNeighbors()
    {
        Assert.assertEquals(4, hex.getHexs()[0].getNeighbors().size());
        Assert.assertEquals(2, hex.getHexs()[3].getNeighbors().size());
        Assert.assertEquals(1, hex.getHexs()[4].getNeighbors().size());
    }

    @Test
    public void testGetAt()
    {
        Assert.assertEquals(hex.getHexs()[0], hex.getAt(new Point(5, 5)));
        Assert.assertEquals(null, hex.getAt(new Point(200000, 5000000)));
    }


    @Test
    public void testAddNextTo()
    {
        HexFreeShapeBuilder<Integer> hexFSB = new HexFreeShapeBuilder<Integer>()
                .setStyle(new HexStyle(20, HexagonOrientation.FLAT_TOP));


        hexFSB.addHex(new Point(0, 0));
        hexFSB.addHexNextTo(0, 0);
        hexFSB.addHexNextTo(1, 2);
        hexFSB.addHexNextTo(2, 3);
        hexFSB.addHexNextTo(0, 4);
        hexFSB.addHexNextTo(0, 1);

        Assert.assertEquals(hexFSB.getHexagons().get(5),
                hexFSB.getHexagons().get(2));
    }

}
