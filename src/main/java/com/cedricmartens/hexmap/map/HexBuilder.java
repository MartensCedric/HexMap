package com.cedricmartens.hexmap.map;

import com.cedricmartens.hexmap.GeometryUtils;
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

    public void setHexs(Hexagon<T>[] hexs){this.hexs = hexs;}

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
                boolean inX = GeometryUtils.isBetweenSlopes(p, points.get(1), points.get(3), -GeometryUtils.HEX_SLOPE);
                boolean inY = GeometryUtils.isBetweenSlopes(p, points.get(1), points.get(4), 0);
                boolean inZ = GeometryUtils.isBetweenSlopes(p, points.get(3), points.get(5), GeometryUtils.HEX_SLOPE);;
                if(inX && inY && inZ)
                    return hexs[i];
            }
        }

        return null;
    }
}
