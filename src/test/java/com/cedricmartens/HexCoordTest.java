package com.cedricmartens;

import com.cedricmartens.hexpert.HexCoord;
import com.cedricmartens.hexpert.HexagonOrientation;
import com.cedricmartens.hexpert.HexagonShape;
import com.cedricmartens.hexpert.Point;
import org.junit.Assert;
import org.junit.Test;

/**
 * Created by 1544256 on 2017-04-28.
 */
public class HexCoordTest
{
    @Test
    public void testCoord()
    {
        HexCoord coord = new HexCoord(new Point(4, 5), 5, HexagonOrientation.FLAT_TOP);
        Point flat1 = coord.getPoints().get(0);
        Point flat2 = coord.getPoints().get(1);
        Point flat3 = coord.getPoints().get(2);
        Point flat4 = coord.getPoints().get(3);
        Point flat5 = coord.getPoints().get(4);
        Point flat6 = coord.getPoints().get(5);

        Assert.assertEquals(flat1, new Point(9, 5));

    }
}
