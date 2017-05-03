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
    private List<Hexagon<T>> hexagons;

    public HexFreeShapeBuilder()
    {
        origin = new Point(0, 0);
        hexagons = new ArrayList<Hexagon<T>>();
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
        hexagons.add(new Hexagon<T>(p, new IndexedCoordinate(hexagons.size()),style));
    }

    public void addHexNextTo(int n, int side)
    {
        addHexNextTo(hexagons.get(n), side);
    }

    public void addHexNextTo(Hexagon<T> hexagon, int side)
    {
        if(side >= 6)
            throw new HexBuildException();

        double degrees = side * 60;
        degrees += style.getOrientation() == HexagonOrientation.POINTY_TOP ? 0 : -30;
        double rad = Math.PI/180.0 * degrees;
        double x = hexagon.getHexGeometry().getMiddlePoint().x + hexagon.getHexGeometry().getWidth() * Math.cos(rad);
        double y = hexagon.getHexGeometry().getMiddlePoint().y + hexagon.getHexGeometry().getHeight() * Math.sin(rad);
        addHex(new Point(x, y));
    }

    public HexGrid<T> build()
    {
        hexs = new Hexagon[hexagons.size()];

        for(int i = 0; i < hexagons.size(); i++)
        {
            hexs[i] = hexagons.get(i);
        }

        HexGrid<T> grid = createGrid();
        built = true;

        return grid;
    }
}
