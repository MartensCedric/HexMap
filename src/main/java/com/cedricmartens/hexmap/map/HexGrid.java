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
public class HexGrid<T> extends HexGridBuilder
{
    private static Random rand = new Random();

    public Hexagon<T> getByCoordinate(CoordinateSystem coordinateSystem)
    {
        for(int i = 0; i < hexs.length; i++)
        {
            if(hexs[i].getCoordinateSystem().equals(coordinateSystem))
            {
                return hexs[i];
            }
        }
        return null;
    }

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

    public boolean coordinateExists(CoordinateSystem coord)
    {
        if(coord instanceof CubeCoordinate)
        {
            CubeCoordinate c = (CubeCoordinate)coord;
            int limit = width / 2;

            return Utils.isBetween(c.getX(), -limit, limit)
                && Utils.isBetween(c.getY(), -limit, limit)
                && Utils.isBetween(c.getZ(), -limit, limit);
        }

        return false;
    }


    public List<Hexagon<T>> getNeighbors(Hexagon<T> hexagon)
    {
        if(coordinateSystem == CubeCoordinate.class)
        {
            int x = ((CubeCoordinate)hexagon.getCoordinateSystem()).getX();
            int y = ((CubeCoordinate)hexagon.getCoordinateSystem()).getY();
            int z = ((CubeCoordinate)hexagon.getCoordinateSystem()).getZ();

            List<Hexagon<T>> neighbors = new ArrayList<Hexagon<T>>();

            CubeCoordinate s1 = new CubeCoordinate(x + 1, y - 1, z);
            if(coordinateExists(s1))
                neighbors.add(getByCoordinate(s1));

            CubeCoordinate s2 = new CubeCoordinate(x - 1, y + 1, z);
            if(coordinateExists(s2))
                neighbors.add(getByCoordinate(s1));

            CubeCoordinate s3 = new CubeCoordinate(x , y - 1, z + 1);
            if(coordinateExists(s3))
                neighbors.add(getByCoordinate(s1));

            CubeCoordinate s4 = new CubeCoordinate(x, y + 1, z - 1);
            if(coordinateExists(s4))
                neighbors.add(getByCoordinate(s1));

            CubeCoordinate s5 = new CubeCoordinate(x + 1, y, z - 1);
            if(coordinateExists(s5))
                neighbors.add(getByCoordinate(s1));

            CubeCoordinate s6 = new CubeCoordinate(x - 1, y, z + 1);
            if(coordinateExists(s6))
                neighbors.add(getByCoordinate(s1));

            return neighbors;
        }

        return null;
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
        return getNeighbors(hex).size() <= 4;
    }

    public Hexagon<T> getAt(Point p)
    {
        Hexagon<T> closest = null;
        double closestDist = Double.MAX_VALUE;

        for(int i = 0; i < hexs.length; i++)
        {
            double dis = Utils.distanceToPoint(p.x, p.y,
                    hexs[i].getHexGeometry().getMiddlePoint().x,
                    hexs[i].getHexGeometry().getMiddlePoint().y);

            if(dis < closestDist)
            {
                closestDist = dis;
                closest = hexs[i];
            }
        }

        return closest;
    }
}
