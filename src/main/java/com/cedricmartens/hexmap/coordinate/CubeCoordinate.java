package com.cedricmartens.hexmap.coordinate;

import com.cedricmartens.hexmap.hexagon.Hexagon;

/**
 * Created by 1544256 on 2017-04-28.
 */
public class CubeCoordinate implements CoordinateSystem
{
    private final int x;
    private final int y;
    private final int z;

    public CubeCoordinate(int x, int y, int z)
    {
        if(x + y + z != 0)
            throw new InvalidCubeCoordinate();

        this.x = x;
        this.y = y;
        this.z = z;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getZ() {
        return z;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CubeCoordinate that = (CubeCoordinate) o;

        if (x != that.x) return false;
        if (y != that.y) return false;
        return z == that.z;
    }

    @Override
    public String toString() {
        return "CubeCoordinate{" +
                "x=" + x +
                ", y=" + y +
                ", z=" + z +
                '}';
    }

    @Override
    public CubeCoordinate toCube() {
        return this;
    }

    @Override
    public IndexedCoordinate toIndexed() {

        if(equals(new CubeCoordinate(0, 0, 0)))
            return new IndexedCoordinate(0);

        int max = Math.max(Math.abs(this.x), Math.abs(this.y));
        max = Math.max(max, Math.abs(this.z));

        int totalHex = 0;
        for(int i = 1; i < max + 1; i++)
        {
            totalHex += 6*i;
        }

        int cursor = 1;
        int currentW = 1;

        while(cursor < totalHex)
        {
            int cubeX;
            int cubeY;
            int cubeZ;

            //UP
            for(int i = 0; i < currentW; i++)
            {
                cubeX = currentW;
                cubeY = -currentW + i;
                cubeZ = -i;

                if(new CubeCoordinate(cubeX, cubeY, cubeZ).equals(this))
                    return new IndexedCoordinate(cursor);

                cursor++;
            }

            //LEFT UP
            for(int i = 0; i < currentW; i++)
            {
                cubeX = currentW - i;
                cubeY = i;
                cubeZ = -currentW;

                if(new CubeCoordinate(cubeX, cubeY, cubeZ).equals(this))
                    return new IndexedCoordinate(cursor);

                cursor++;
            }

            //LEFT DOWN
            for(int i = 0; i < currentW; i++)
            {
                cubeX = -i;
                cubeY = currentW;
                cubeZ = -currentW + i;

                if(new CubeCoordinate(cubeX, cubeY, cubeZ).equals(this))
                    return new IndexedCoordinate(cursor);

                cursor++;
            }

            //DOWN
            for(int i = 0; i < currentW; i++)
            {
                cubeX = -currentW;
                cubeY = currentW - i;
                cubeZ = i;

                if(new CubeCoordinate(cubeX, cubeY, cubeZ).equals(this))
                    return new IndexedCoordinate(cursor);

                cursor++;
            }

            //DOWN RIGHT
            for(int i = 0; i < currentW; i++)
            {
                cubeX = -currentW + i;
                cubeY = -i;
                cubeZ = currentW;

                if(new CubeCoordinate(cubeX, cubeY, cubeZ).equals(this))
                    return new IndexedCoordinate(cursor);

                cursor++;
            }

            //UP RIGHT
            for(int i = 0; i < currentW; i++)
            {
                cubeX = i;
                cubeY = -currentW;
                cubeZ = currentW - i;

                if(new CubeCoordinate(cubeX, cubeY, cubeZ).equals(this))
                    return new IndexedCoordinate(cursor);

                cursor++;
            }
            currentW++;
        }
        return null;
    }

    @Override
    public OffsetCoordinate toOffset() {
        return null;
    }

    @Override
    public AxialCoordinate toAxial() {
        return null;
    }
}
