package ie.tudublin;

import processing.core.PApplet;

import processing.data.TableRow;

public class Tasks
{
    public String task;
    public int start;
    public int end;

    //Constructor
    public Tasks(String task, int start, int end)
    {
        this.task = task;
        this.start = start;
        this.end = end;
    }

    public Tasks(TableRow tr)
    {
        this(tr.getString("Task"), tr.getInt("Start"), tr.getInt("End"));
    }

    public String toString()
    {
        return this.task + ", " + this.start + ", " + this.end;
    }

    public String getName() {
        return task;
    }

}