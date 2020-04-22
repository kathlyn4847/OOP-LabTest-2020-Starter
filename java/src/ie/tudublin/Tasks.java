package ie.tudublin;

import processing.core.PApplet;

import processing.data.TableRow;

public class Tasks
{
    public int r;
    public int g;
    public int b;
    public int num;

    public Tasks(int r, int g, int b, int num)
    {
        this.r = r;
        this.g = g;
        this.b = b;
        this.num = num;
    }

    public Tasks(TableRow tr)
    {
        this(tr.getInt("r"), tr.getInt("g"), tr.getInt("b"), tr.getInt("value"));
    }

    public String toString()
    {
        return this.r + ", " + this.g + ", " + this.b;
    }

}