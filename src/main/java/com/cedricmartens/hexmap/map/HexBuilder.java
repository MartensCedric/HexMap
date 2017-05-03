package com.cedricmartens.hexmap.map;

import com.cedricmartens.hexmap.hexagon.HexStyle;
import com.cedricmartens.hexmap.hexagon.Hexagon;
import com.cedricmartens.hexmap.hexagon.HexagonShape;
import com.cedricmartens.hexmap.coordinate.CoordinateSystem;
import com.cedricmartens.hexmap.coordinate.Point;

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

    public abstract HexBuilder<T> build();

    protected HexGrid<T> createGrid() {

       HexGrid grid = new HexGrid();
       grid.setOrigin(origin);
       grid.setShape(shape);
       grid.setStyle(style);
       grid.setCoordinateSystem(coordinateSystem);
       grid.hexs = hexs;
       return grid;
    }
}
