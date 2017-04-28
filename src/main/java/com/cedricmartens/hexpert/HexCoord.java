package com.cedricmartens.hexpert;

import com.cedricmartens.hexpert.coordinate.Point;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Cedric Martens on 2017-04-27.
 */

public class HexCoord
{
    private HexagonOrientation orientation;
    private Point middlePoint;
    private List<Point> points;
    private double size;

    public HexCoord(Point middlePoint, double size, HexagonOrientation orientation)
    {
        if(size <= 0)
            throw new IllegalArgumentException();

        this.middlePoint = middlePoint;
        this.size = size;
        this.points = new ArrayList<Point>();
        this.orientation = orientation;

        for(int i = 0; i < 6; i++)
        {
            double degrees = i * 60;
            degrees += orientation == HexagonOrientation.POINTY_TOP ? 30 : 0;
            double rad = Math.PI/180.0 * degrees;
            points.add(i, new Point(
                middlePoint.x + size * Math.cos(rad),
                middlePoint.y + size * Math.sin(rad))
            );
        }
    }

    public Point getMiddlePoint() {
        return middlePoint;
    }

    public List<Point> getPoints()
    {
        return points;
    }

    public double getHeight()
    {
        return orientation == HexagonOrientation.POINTY_TOP ?
                size * 2 :
                Math.sqrt(3)/2 * getWidth();
    }

    public double getWidth()
    {
        return orientation == HexagonOrientation.POINTY_TOP ?
                Math.sqrt(3)/2 * getHeight() :
                size * 2;
    }
}
