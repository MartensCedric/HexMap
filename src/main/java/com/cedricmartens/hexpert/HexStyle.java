package com.cedricmartens.hexpert;

import com.cedricmartens.hexpert.grid.HexagonOrientation;

/**
 * Created by 1544256 on 2017-04-28.
 */
public class HexStyle
{
    private double size;
    private HexagonOrientation orientation;

    public HexStyle(double size, HexagonOrientation orientation) {
        setSize(size);
        setOrientation(orientation);
    }

    public double getSize() {
        return size;
    }

    public void setSize(double size)
    {
        if(size <= 0)
            throw new IllegalArgumentException();
        this.size = size;
    }

    public HexagonOrientation getOrientation() {
        return orientation;
    }

    public void setOrientation(HexagonOrientation orientation) {
        this.orientation = orientation;
    }
}
