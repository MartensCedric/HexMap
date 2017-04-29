package com.cedricmartens.hexpert.grid;

import com.cedricmartens.hexpert.HexStyle;
import com.cedricmartens.hexpert.Hexagon;
import com.cedricmartens.hexpert.coordinate.CubeCoordinate;
import com.cedricmartens.hexpert.coordinate.OffsetCoordinate;
import com.cedricmartens.hexpert.coordinate.Point;

/**
 * Created by Cedric Martens on 2017-04-27.
 */

public class HexGridBuilder<T> extends HexGridCore
{
    private boolean built;

    public HexGridBuilder()
    {
        setOrigin(new Point(0, 0));
        setWidth(1);
        setHeight(1);
        built = false;
    }

    public HexGrid<T> build()
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


        return createHexGrid();
    }

    private void buildHexagon()
    {
        if(width != height || width % 2 == 0)
            throw new HexBuildException();

        int totalHex = 1;
        coordinate = CubeCoordinate.class;

        for(int i = 1; i < width/2 + 1; i++)
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
            double x  = posX * getStyle().getSize() * 2 + getStyle().getSize() + getOrigin().getX();
            double y = posY * getStyle().getSize() * 2 * Math.sqrt(3)/2 + (getStyle().getSize() * 2 * Math.sqrt(3)/2)/2  + getOrigin().getY();
            Hexagon<T> middlePoint = new Hexagon<T>(new Point(x,y), new CubeCoordinate(0, 0, 0), getStyle());
            hexs[cursor] = middlePoint;
            cursor++;
            while(currentW < width/2 + 1)
            {
                int cubeX;
                int cubeY;
                int cubeZ;

                x+= middlePoint.getHexGeometry().getWidth()*0.75;
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

    public HexGridBuilder<T> setWidth(int width)
    {
        if(width < 1)
            throw new IllegalArgumentException();

        checkBuilt();
        this.width = width;
        return this;
    }

    public HexGridBuilder<T> setHeight(int height)
    {
        if(height < 1)
            throw new IllegalArgumentException();

        checkBuilt();
        this.height = height;
        return this;
    }

    public HexGridBuilder<T> setOrigin(Point origin)
    {
        checkBuilt();
        this.origin = origin;
        return this;
    }


    public HexGridBuilder setShape(HexagonShape shape)
    {
        checkBuilt();
        this.shape = shape;
        return this;
    }

    public HexGridBuilder setOffsetLayout(OffsetLayout layout)
    {
        this.layout = layout;
        return this;
    }
    public HexGridBuilder setStyle(HexStyle style)
    {
        checkBuilt();
        this.style = style;
        return this;
    }

    private void checkBuilt()
    {
        if(built)
            throw new HexBuildException();
    }

    private HexGrid<T> createHexGrid()
    {
        HexGrid<T> grid = new HexGrid<T>();
        grid.shape = this.shape;
        grid.hexs = this.hexs;
        grid.coordinate = this.coordinate;
        grid.origin = this.origin;
        grid.height = this.height;
        grid.width = this.width;
        grid.style = this.style;
        return grid;
    }
}
