package com.cedricmartens.hexmap.map;

import com.cedricmartens.hexmap.Utils;
import com.cedricmartens.hexmap.hexagon.*;
import com.cedricmartens.hexmap.coordinate.CoordinateSystem;
import com.cedricmartens.hexmap.coordinate.Point;

import java.util.List;

/**
 * Created by Cedric on 2017-04-29.
 */
public abstract class HexBuilder<T>
{
    protected boolean built = false;
    protected Point origin;
    protected Hexagon<T>[] hexs;
    protected HexagonShape shape;
    protected HexStyle style;

    protected Class<? extends CoordinateSystem> coordinateSystem;

    public Class<? extends CoordinateSystem> getCoordinateSystem() {
        return coordinateSystem;
    }

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

    public abstract HexGrid<T> build();

    protected HexGrid<T> createGrid() {

       HexGrid grid = new HexGrid();
       grid.setOrigin(origin);
       grid.setShape(shape);
       grid.setStyle(style);
       grid.setCoordinateSystem(coordinateSystem);
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
        if(!built)
            throw new RuntimeException();
        // TODO: 2017-05-04 add child class to the builder and extend children instead

        for(int i = 0; i < hexs.length; i++)
        {
            if(style.getOrientation() == HexagonOrientation.FLAT_TOP)
            {
                List<Point> points = hexs[i].getHexGeometry().getPoints();
                boolean inY = Utils.isBetween((float)p.y, (float)points.get(4).y, (float)points.get(1).y);
            }

            // TODO: 2017-05-04 finish this shit 
        }



        return null;
    }
}
