package com.cedricmartens.hexpert.grid;

import com.cedricmartens.hexpert.HexStyle;
import com.cedricmartens.hexpert.Hexagon;
import com.cedricmartens.hexpert.coordinate.CubeCoordinate;
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
    private HexStyle style;
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
        if(built || shape == null || getStyle().getOrientation() == null)
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

        int totalHex = 1;

        for(int i = 1; i < width; i++)
        {
            totalHex += 6*i;
        }
        hexs = new Hexagon[totalHex];

        if(getStyle().getOrientation() == HexagonOrientation.FLAT_TOP)
        {
            int currentW = 1;
            int cursor = 0;
            int posX = width/2 - 1;
            int posY = height/2 - 1;
            double x  = posX * getStyle().getSize() * 2 + getStyle().getSize();
            double y = posY * getStyle().getSize() * 2 * Math.sqrt(3)/2 + (getStyle().getSize() * 2 * Math.sqrt(3)/2)/2;
            Hexagon<T> middlePoint = new Hexagon<T>(new Point(x,y), new CubeCoordinate(0, 0, 0), getStyle());
            hexs[cursor] = middlePoint;
            cursor++;
            while(currentW < width)
            {
                int cubeX;
                int cubeY;
                int cubeZ;

                x-= middlePoint.getHexGeometry().getWidth()*0.75;
                y-= middlePoint.getHexGeometry().getHeight()/2;

                //UP
                for(int i = 0; i < currentW; i++)
                {
                    cubeX = currentW;
                    cubeY = -currentW + i;
                    cubeZ = -i;

                    Hexagon<T> hex = new Hexagon<T>(new Point(x, y), new CubeCoordinate(cubeX, cubeY, cubeZ), getStyle());
                    hexs[cursor] = hex;

                    y+= middlePoint.getHexGeometry().getHeight();
                    cursor++;
                }

                //LEFT UP
                for(int i = 0; i < currentW; i++)
                {
                    cubeX = currentW - i;
                    cubeY = i;
                    cubeZ = -currentW;

                    Hexagon<T> hex = new Hexagon<T>(new Point(x, y), new CubeCoordinate(cubeX, cubeY, cubeZ), getStyle());
                    hexs[cursor] = hex;

                    x-= middlePoint.getHexGeometry().getWidth()*0.75;
                    y+= middlePoint.getHexGeometry().getHeight()/2;
                    cursor++;
                }

                //LEFT DOWN
                for(int i = 0; i < currentW; i++)
                {
                    cubeX = -i;
                    cubeY = currentW;
                    cubeZ = -currentW + i;

                    Hexagon<T> hex = new Hexagon<T>(new Point(x, y), new CubeCoordinate(cubeX, cubeY, cubeZ), getStyle());
                    x-= middlePoint.getHexGeometry().getWidth()*0.75;
                    y-= middlePoint.getHexGeometry().getHeight()/2;
                    hexs[cursor] = hex;
                    cursor++;
                }

                //DOWN
                for(int i = 0; i < currentW; i++)
                {
                    cubeX = -currentW;
                    cubeY = currentW - i;
                    cubeZ = i;

                    Hexagon<T> hex = new Hexagon<T>(new Point(x, y), new CubeCoordinate(cubeX, cubeY, cubeZ), getStyle());
                    hexs[cursor] = hex;

                    y-= middlePoint.getHexGeometry().getHeight();
                    cursor++;
                }

                //DOWN RIGHT
                for(int i = 0; i < currentW; i++)
                {
                    cubeX = -currentW + i;
                    cubeY = -i;
                    cubeZ = currentW;

                    Hexagon<T> hex = new Hexagon<T>(new Point(x, y), new CubeCoordinate(cubeX, cubeY, cubeZ), getStyle());

                    x+= middlePoint.getHexGeometry().getWidth()*0.75;
                    y-= middlePoint.getHexGeometry().getHeight()/2;

                    hexs[cursor] = hex;
                    cursor++;
                }

                //UP RIGHT
                for(int i = 0; i < currentW; i++)
                {
                    cubeX = i;
                    cubeY = -currentW;
                    cubeZ = currentW - i;

                    Hexagon<T> hex = new Hexagon<T>(new Point(x, y), new CubeCoordinate(cubeX, cubeY, cubeZ), getStyle());
                    hexs[cursor] = hex;
                    x+= middlePoint.getHexGeometry().getWidth()*0.75;
                    y+= middlePoint.getHexGeometry().getHeight()/2;
                    cursor++;
                }
                currentW++;
            }
        }
    }

    private void buildRectangle()
    {
        if(width != height || layout == null)
            throw new HexBuildException();

        if(getStyle().getOrientation() == HexagonOrientation.FLAT_TOP
            && (layout != OffsetLayout.ODD_Q
            || layout != OffsetLayout.EVEN_Q))
        {
            throw new HexBuildException();
        }

        if(getStyle().getOrientation() == HexagonOrientation.POINTY_TOP
            && (layout != OffsetLayout.ODD_R
            || layout != OffsetLayout.EVEN_R))
        {
            throw new HexBuildException();
        }

        hexs = new Hexagon[width * height];

        if(getStyle().getOrientation() == HexagonOrientation.FLAT_TOP)
        {
            if(layout == OffsetLayout.EVEN_Q)
            {
                for(int i = 0; i < hexs.length; i++)
                {
                    OffsetCoordinate offset = new OffsetCoordinate(i % width, i / height);

                }
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

    public HexStyle getStyle() {
        return style;
    }

    public HexGrid setStyle(HexStyle style) {
        this.style = style;
        return this;
    }

    public Hexagon<T>[] getHexs() {
        return hexs;
    }
}
