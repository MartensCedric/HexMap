package com.cedricmartens.hexpert;

/**
 * Created by Cedric Martens on 2017-04-27.
 */

public class HexGrid
{
    private Point origin;
    private HexagonShape shape;
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

    public HexGrid setWidth(int width)
    {
	    this.width = width;
        return this;
    }

    public HexGrid setHeight(int height)
    {
	    this.height = height;
        return this;
    }

    public HexGrid setOrigin(Point origin) 
    {
        this.origin = origin;
        return this;
    }

    public HexGrid setShape(HexagonShape shape) 
    {
        this.shape = shape;
        return this;
    }

    public HexGrid build()
    {
        switch(shape)
	{
		case LINE :
			if((width < 1 || height < 1) 
			|| (width != 1 && height != 1))
			{

			}
		break;
	}
	    return null;
    }
}
