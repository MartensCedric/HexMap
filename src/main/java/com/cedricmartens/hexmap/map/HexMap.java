package com.cedricmartens.hexmap.map;

import com.cedricmartens.hexmap.hexagon.Hexagon;
import com.cedricmartens.hexmap.coordinate.*;
import com.cedricmartens.hexmap.map.grid.HexGridBuilder;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by Cedric on 2017-04-29.
 */
public class HexMap<T> extends HexGridBuilder<T>
{
    private static Random rand = new Random();

    public Hexagon<T> getRandom()
    {
        int n = rand.nextInt(hexs.length);
        return getByCoordinate(new IndexedCoordinate(n));
    }

    public void setSeed(int seed)
    {
        rand = new Random(seed);
    }

    public List<Hexagon<T>> getOuterHexagons()
    {

        List<Hexagon<T>> outers = new ArrayList<>();
        for(int i = 0; i < hexs.length; i++)
        {
            if(isOuter(hexs[i]))
                outers.add(hexs[i]);
        }
        return outers;

    }

    public List<Hexagon<T>> getInnerHexagons()
    {
        List<Hexagon<T>> inners = new ArrayList<Hexagon<T>>();
        for(int i = 0; i < hexs.length; i++)
        {
            if(!isOuter(hexs[i]))
                inners.add(hexs[i]);
        }
        return inners;

    }

    public boolean isOuter(Hexagon<T> hex)
    {
        return hex.getNeighbors().size() <= 4;
    }
}
