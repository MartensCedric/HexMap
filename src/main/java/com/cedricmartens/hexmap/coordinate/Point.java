package com.cedricmartens.hexmap.coordinate;

/**
 * Created by Cedric Martens on 2017-04-27.
 */

public class Point
{
    public final double x;
    public final double y;

    public Point(double x, double y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public boolean equals(Object o)
    {
        Point p = (Point)o;
        return Math.round(p.x * 100.0)/100.0 == Math.round(this.x * 100.0)/100.0
                && Math.round(p.y * 100.0)/100.0 == Math.round(this.y * 100.0)/100.0 ;
    }

    @Override
    public String toString() {
        return "Point{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }
}
