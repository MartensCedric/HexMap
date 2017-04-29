package com.cedricmartens.hexpert.grid;

import com.cedricmartens.hexpert.HexStyle;
import com.cedricmartens.hexpert.Hexagon;
import com.cedricmartens.hexpert.coordinate.Coordinate;
import com.cedricmartens.hexpert.coordinate.CubeCoordinate;

/**
 * Created by Cedric on 2017-04-29.
 */
public class HexGrid<T> extends HexGridCore
{
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
}
