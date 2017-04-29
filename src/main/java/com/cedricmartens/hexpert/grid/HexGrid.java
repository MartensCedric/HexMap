package com.cedricmartens.hexpert.grid;

import com.cedricmartens.hexpert.HexStyle;
import com.cedricmartens.hexpert.Hexagon;
import com.cedricmartens.hexpert.coordinate.AxialCoordinate;
import com.cedricmartens.hexpert.coordinate.Coordinate;
import com.cedricmartens.hexpert.coordinate.CubeCoordinate;
import com.cedricmartens.hexpert.coordinate.OffsetCoordinate;

import java.util.Random;

/**
 * Created by Cedric on 2017-04-29.
 */
public class HexGrid<T> extends HexGridCore
{
    private static Random rand = new Random();

    public Hexagon<T> getByCoordinate(Coordinate coordinate)
    {
        for(int i = 0; i < hexs.length; i++)
        {
            if(hexs[i].getCoordinate().equals(coordinate))
            {
                return hexs[i];
            }
        }
        return null;
    }

    public Hexagon<T> getRandom()
    {
        int x = rand.nextInt() % width/2 - 1;
        int y = rand.nextInt() % height/2 - 1;

        if(coordinate == CubeCoordinate.class)
        {
            int z = -x + -y;
            return getByCoordinate(new CubeCoordinate(x, y, z));
        }else if(coordinate == OffsetCoordinate.class)
        {
            return getByCoordinate(new OffsetCoordinate(x, y));
        }else if (coordinate == AxialCoordinate.class)
        {
            return getByCoordinate(new AxialCoordinate(x, y));
        }else
        {
            return null;
        }

    }

    public void setSeed(int seed)
    {
        rand = new Random(seed);
    }
}
