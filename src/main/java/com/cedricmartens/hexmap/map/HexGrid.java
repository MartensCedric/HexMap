package com.cedricmartens.hexmap.map;

import com.cedricmartens.hexmap.hexagon.Hexagon;
import com.cedricmartens.hexmap.Utils;
import com.cedricmartens.hexmap.coordinate.*;
import com.cedricmartens.hexmap.map.grid.HexGridBuilder;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by Cedric on 2017-04-29.
 */
public class HexGrid<T> extends HexGridBuilder<T>
{
    private static Random rand = new Random();

    public Hexagon<T> getRandom()
    {
        int x = rand.nextInt(width/2);
        int y = rand.nextInt(height/2);

        if(coordinateSystem == CubeCoordinate.class)
        {
            int z = -x + -y;
            return getByCoordinate(new CubeCoordinate(x, y, z));
        }
        else if(coordinateSystem == OffsetCoordinate.class)
        {
            return getByCoordinate(new OffsetCoordinate(x, y));
        }
        else if (coordinateSystem == AxialCoordinate.class)
        {
            return getByCoordinate(new AxialCoordinate(x, y));
        }
        else
        {
            return null;
        }

    }

    public void setSeed(int seed)
    {
        rand = new Random(seed);
    }

    public List<Hexagon<T>> getOuterHexagons()
    {
        if(coordinateSystem == CubeCoordinate.class)
        {
            List<Hexagon<T>> outers = new ArrayList<>();
            for(int i = 0; i < hexs.length; i++)
            {
                if(isOuter(hexs[i]))
                    outers.add(hexs[i]);
            }
            return outers;
        }

        return null;
    }

    public List<Hexagon<T>> getInnerHexagons()
    {
        if(coordinateSystem == CubeCoordinate.class)
        {
            List<Hexagon<T>> inners = new ArrayList<Hexagon<T>>();
            for(int i = 0; i < hexs.length; i++)
            {
                if(!isOuter(hexs[i]))
                    inners.add(hexs[i]);
            }
            return inners;
        }

        return null;
    }

    public boolean isOuter(Hexagon<T> hex)
    {
        return hex.getNeighbors().size() <= 4;
    }
}
