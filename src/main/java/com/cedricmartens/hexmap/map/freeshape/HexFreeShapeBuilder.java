package com.cedricmartens.hexmap.map.freeshape;

import com.cedricmartens.hexmap.hexagon.HexGeometry;
import com.cedricmartens.hexmap.hexagon.HexStyle;
import com.cedricmartens.hexmap.hexagon.Hexagon;
import com.cedricmartens.hexmap.coordinate.CoordinateSystem;
import com.cedricmartens.hexmap.coordinate.IndexedCoordinate;
import com.cedricmartens.hexmap.coordinate.Point;
import com.cedricmartens.hexmap.map.HexBuildException;
import com.cedricmartens.hexmap.map.HexBuilder;
import com.cedricmartens.hexmap.hexagon.HexagonOrientation;
import com.cedricmartens.hexmap.hexagon.HexagonShape;
import com.cedricmartens.hexmap.map.HexGrid;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Cedric Martens on 2017-05-02.
 */
public class HexFreeShapeBuilder<T> extends HexBuilder
{
    private List<HexGeometry> hexGeometries;

    public HexFreeShapeBuilder()
    {
        origin = new Point(0, 0);
        hexGeometries = new ArrayList<HexGeometry>();
        shape = HexagonShape.FREE;
    }

    public HexFreeShapeBuilder<T> setStyle(HexStyle style)
    {
        this.style = style;
        return this;
    }

    public HexFreeShapeBuilder<T> setCoordinateSystem(Class<? extends CoordinateSystem> coordinateSystem)
    {
        this.coordinateSystem = coordinateSystem;
        return this;
    }

    public void addHex(Point p)
    {
        hexGeometries.add(new HexGeometry(p, style));
    }

    public void addHexNextTo(int n, int side)
    {
        addHexNextTo(hexGeometries.get(n), side);
    }

    public void addHexNextTo(HexGeometry hexGeometry, int side)
    {
        if(side >= 6)
            throw new HexBuildException();

        double degrees = side * 60;
        degrees += style.getOrientation() == HexagonOrientation.POINTY_TOP ? 0 : -30;
        double rad = Math.PI/180.0 * degrees;
        double x = hexGeometry.getMiddlePoint().x + style.getSize() * Math.cos(rad);
        double y = hexGeometry.getMiddlePoint().y + style.getSize() * Math.sin(rad);
        hexGeometries.add(new HexGeometry(new Point(x, y), style));
    }

    public HexGrid<T> build()
    {
        hexs = new Hexagon[hexGeometries.size()];

        for(int i = 0; i < hexGeometries.size(); i++)
        {
            hexs[i] = new Hexagon(hexGeometries.get(i), new IndexedCoordinate(i), style);
        }

        HexGrid<T> grid = createGrid();
        built = true;

        return grid;
    }
}
