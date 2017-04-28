package com.cedricmartens.hexpert.grid;

import com.cedricmartens.hexpert.Hexagon;
import com.cedricmartens.hexpert.coordinate.OffsetCoordinate;
import com.cedricmartens.hexpert.coordinate.Point;

/**
 * Created by Cedric Martens on 2017-04-27.
 */

public class HexGrid<T>
{
    private Point origin;
    private Hexagon<T>[] hexs;
    private OffsetLayout layout;
    private HexagonShape shape;
    private HexagonOrientation orientation;
    private int width;
    private int height;
    private boolean built;

    public HexGrid()
    {
        origin = new Point(0, 0);
        width = 1;
        height = 1;
	    built = false;
    }

    public HexGrid build()
    {
        if(built || shape == null || orientation == null)
            throw new HexBuildException();

            switch(shape)
            {
                case LINE :
                    buildLine();
                break;
                    
                case RECTANGLE:
                    buildRectangle();
                    break;
                
                case HEXAGON:
                    buildHexagon();
                    break;
            }
            built = true;
            return null;
    }

    private void buildHexagon()
    {
        if(width != height || width % 2 == 0)
            throw new HexBuildException();
    }

    private void buildRectangle()
    {
        if(width != height || layout == null)
            throw new HexBuildException();

        if(orientation == HexagonOrientation.FLAT_TOP
            && (layout != OffsetLayout.ODD_Q
            || layout != OffsetLayout.EVEN_Q))
        {
            throw new HexBuildException();
        }

        if(orientation == HexagonOrientation.POINTY_TOP
            && (layout != OffsetLayout.ODD_R
            || layout != OffsetLayout.EVEN_R))
        {
            throw new HexBuildException();
        }

        hexs = new Hexagon[width * height];

        if(orientation == HexagonOrientation.FLAT_TOP)
        {
            for(int i = 0; i < hexs.length; i++)
            {
                OffsetCoordinate offset = new OffsetCoordinate(i % width, i / height);
                //TODO Add hexstyle
            }
        }else{

        }
    }

    private void buildLine()
    {
        if(width != 1 && height != 1)
            throw new HexBuildException();
    }


    public HexGrid setWidth(int width)
    {
        if(width < 1)
            throw new IllegalArgumentException();

        if(built)
            throw new HexBuildException();

        this.width = width;
        return this;
    }

    public HexGrid setHeight(int height)
    {
        if(height < 1)
            throw new IllegalArgumentException();

        if(built)
            throw new HexBuildException();

        this.height = height;
        return this;
    }

    public HexGrid setOrigin(Point origin)
    {
        if(built)
            throw new HexBuildException();

        this.origin = origin;
        return this;
    }

    public HexGrid setShape(HexagonShape shape)
    {
        if(built)
            throw new HexBuildException();

        this.shape = shape;
        return this;
    }

    public HexGrid setOffsetLayout(OffsetLayout layout)
    {
        this.layout = layout;
        return this;
    }

    public HexagonOrientation getOrientation() {
        return orientation;
    }

    public void setOrientation(HexagonOrientation orientation) {
        this.orientation = orientation;
    }

}
