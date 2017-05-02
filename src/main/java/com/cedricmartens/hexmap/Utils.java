package com.cedricmartens.hexmap;

/**
 * Created by Cedric on 2017-04-29.
 */
public class Utils
{
    public static boolean isBetween(float n, float lowerLimit, float higherLimit)
    {
        return (n >= lowerLimit && n <= higherLimit);
    }

    public static boolean isInside(float x, float y, float lowX, float lowY, float highX, float highY)
    {
        return isBetween(x, lowX, highX) && isBetween(y, lowY, highY);
    }

    public static double distanceToPoint(double x1, double y1, double x2, double y2)
    {
        return Math.sqrt((x1 - x2) * (x1 - x2) + (y1 - y2) * (y1 - y2));
    }
}
