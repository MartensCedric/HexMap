package com.cedricmartens.hexmap.map;

import com.cedricmartens.hexmap.Utils;
import com.cedricmartens.hexmap.hexagon.*;
import com.cedricmartens.hexmap.coordinate.Point;

import java.util.List;

/**
 * Created by Cedric on 2017-04-29.
 */
public abstract class HexBuilder<T>
{
    private final static double HEX_SLOPE = 1.7320508075688774;
    protected boolean built = false;
    protected Point origin;
    protected Hexagon<T>[] hexs;
    protected HexagonShape shape;
    protected HexStyle style;

    public Point getOrigin() {
        return origin;
    }

    public Hexagon<T>[] getHexs() {
        return hexs;
    }

    public HexagonShape getShape() {
        return shape;
    }

    public HexStyle getStyle() {
        return style;
    }

    public abstract HexMap<T> build();

    protected HexMap<T> createGrid() {

       HexMap grid = new HexMap();
       grid.setOrigin(origin);
       grid.setShape(shape);
       grid.setStyle(style);
       grid.hexs = hexs;
       return grid;
    }

    protected void checkBuilt()
    {
        if(built)
            throw new HexBuildException();
    }

    public Hexagon<T> getAt(Point p)
    {

        for(int i = 0; i < hexs.length; i++)
        {
            if(style.getOrientation() == HexagonOrientation.FLAT_TOP)
            {
                List<Point> points = hexs[i].getHexGeometry().getPoints();
                boolean inX = Utils.isBetween((float)p.y,
                        (float)(points.get(1).x*-HEX_SLOPE + p.y),
                        (float)(points.get(3).x*-HEX_SLOPE + p.y));
                boolean inY = Utils.isBetween((float)p.y, (float)points.get(4).y, (float)points.get(1).y);
                boolean inZ = Utils.isBetween((float)p.y,
                        (float)(points.get(3).x*HEX_SLOPE + p.y),
                        (float)(points.get(5).x*HEX_SLOPE + p.y));
                if(inX && inY && inZ)
                    return hexs[i];
            }
        }

        return null;
    }
}
