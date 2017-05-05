package com.cedricmartens.hexmap.map.freeshape;

import com.cedricmartens.hexmap.GeometryUtils;
import com.cedricmartens.hexmap.hexagon.*;
import com.cedricmartens.hexmap.coordinate.IndexedCoordinate;
import com.cedricmartens.hexmap.coordinate.Point;
import com.cedricmartens.hexmap.map.HexBuildException;
import com.cedricmartens.hexmap.map.HexBuilder;
import com.cedricmartens.hexmap.map.HexMap;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Cedric Martens on 2017-05-02.
 */
public class HexFreeShapeBuilder<T> extends HexBuilder<T>
{
    private List<Point> hexagons;

    public HexFreeShapeBuilder()
    {
        origin = new Point(0, 0);
        hexagons = new ArrayList<Point>();
        shape = HexagonShape.FREE;
    }

    public HexFreeShapeBuilder<T> setStyle(HexStyle style)
    {
        this.style = style;
        return this;
    }

    public void addHex(Point p)
    {
        hexagons.add(p);
    }

    public void addHexNextTo(int n, int side)
    {
        addHexNextTo(hexagons.get(n), side);
    }

    public void addHexNextTo(Point p, int side)
    {
        if(side >= 6)
            throw new HexBuildException();

        double degrees = side * 60;
        degrees += style.getOrientation() == HexagonOrientation.POINTY_TOP ? 0 : -30;
        double rad = Math.PI/180.0 * degrees;
        double x = p.x + GeometryUtils.getHexWidth(this.style.getSize(), this.style.getOrientation()) * Math.cos(rad);
        double y = p.y + GeometryUtils.getHexHeight(this.style.getSize(), this.style.getOrientation()) * Math.sin(rad);
        addHex(new Point(x, y));
    }

    public HexMap<T> build()
    {
        hexs = new Hexagon[hexagons.size()];

        for(int i = 0; i < hexs.length; i++)
        {
            hexs[i] = new Hexagon<T>(hexagons.get(i), new IndexedCoordinate(i), style);
        }

        for(int i = 0; i < hexs.length; i++)
        {
            HexGeometry geometry = hexs[i].getHexGeometry();

            List<Hexagon<T>> neighbors = new ArrayList<>();
            for(int j = 0; j < 6; j++)
            {
                double degrees = j * 60;
                degrees += style.getOrientation() == HexagonOrientation.POINTY_TOP ? 0 : -30;
                double rad = Math.PI/180.0 * degrees;
                double x = geometry.getMiddlePoint().x + geometry.getWidth() * Math.cos(rad);
                double y = geometry.getMiddlePoint().y + geometry.getHeight() * Math.sin(rad);
                Point p = new Point(x,y);

                for(int k = 0; k < hexs.length; k++)
                {
                    if(hexs[k].getHexGeometry().getMiddlePoint().equals(p))
                    {
                        neighbors.add(hexs[k]);
                    }
                }
            }

            hexs[i].setNeighbors(neighbors);
        }

        HexMap<T> grid = createGrid();
        built = true;

        return grid;
    }
}
