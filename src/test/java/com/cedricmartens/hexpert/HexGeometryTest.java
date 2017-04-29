package com.cedricmartens.hexpert;

import com.cedricmartens.hexpert.HexGeometry;
import com.cedricmartens.hexpert.grid.HexagonOrientation;
import com.cedricmartens.hexpert.coordinate.Point;
import org.junit.Assert;
import org.junit.Test;

/**
 * Created by 1544256 on 2017-04-28.
 */
public class HexGeometryTest
{
    @Test
    public void testFlat()
    {
        HexStyle style = new HexStyle(5, HexagonOrientation.FLAT_TOP);
        HexGeometry coord = new HexGeometry(new Point(4, 5), style);

        Assert.assertEquals(new Point(9, 5), coord.getPoints().get(0));
        Assert.assertEquals(new Point(6.50, 9.33), coord.getPoints().get(1));
        Assert.assertEquals(new Point(1.5, 9.33), coord.getPoints().get(2));
        Assert.assertEquals(new Point(-1, 5), coord.getPoints().get(3));
        Assert.assertEquals(new Point(1.5, 0.67), coord.getPoints().get(4));
        Assert.assertEquals(new Point(6.5, 0.67), coord.getPoints().get(5));
        Assert.assertEquals(new Point(4, 5), coord.getMiddlePoint());
    }

    @Test
    public void testPointy()
    {
        HexStyle style = new HexStyle(7, HexagonOrientation.POINTY_TOP);
        HexGeometry coord = new HexGeometry(new Point(-2, 3), style);

        Assert.assertEquals(new Point(4.06, 6.5), coord.getPoints().get(0));
        Assert.assertEquals(new Point(-2, 10), coord.getPoints().get(1));
        Assert.assertEquals(new Point(-8.06, 6.5), coord.getPoints().get(2));
        Assert.assertEquals(new Point(-8.06, -0.5), coord.getPoints().get(3));
        Assert.assertEquals(new Point(-2, -4), coord.getPoints().get(4));
        Assert.assertEquals(new Point(4.06, -0.5), coord.getPoints().get(5));
        Assert.assertEquals(new Point(-2, 3), coord.getMiddlePoint());
    }

    @Test
    public void testWidthFlat()
    {
        HexStyle style = new HexStyle(7, HexagonOrientation.FLAT_TOP);
        HexGeometry coord = new HexGeometry(new Point(-2, 3), style);
        Assert.assertEquals(14, coord.getWidth(), 0);
    }

    @Test
    public void testHeightFlat()
    {
        HexStyle style = new HexStyle(7, HexagonOrientation.FLAT_TOP);
        HexGeometry coord = new HexGeometry(new Point(-2, 3), style);
        Assert.assertEquals(12.124, coord.getHeight(), 0.001);
    }

    @Test
    public void testWidthPointy()
    {
        HexStyle style = new HexStyle(7, HexagonOrientation.POINTY_TOP);
        HexGeometry coord = new HexGeometry(new Point(-2, 3), style);
        Assert.assertEquals(12.124, coord.getWidth(), 0.001);
    }

    @Test
    public void testHeightPointy()
    {
        HexStyle style = new HexStyle(7, HexagonOrientation.POINTY_TOP);
        HexGeometry coord = new HexGeometry(new Point(-2, 3), style);
        Assert.assertEquals(14, coord.getHeight(), 0);
    }
}
