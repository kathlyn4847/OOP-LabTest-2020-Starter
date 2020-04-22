package ie.tudublin;

import java.util.ArrayList;

import processing.core.PApplet;
import processing.data.Table;
import processing.data.TableRow;

public class Gantt extends PApplet
{	
	ArrayList<Tasks> tasks = new ArrayList<Tasks>();
	
	public void settings()
	{
		size(800, 600);
	}

	public void loadTasks()
	{
		Table table = loadTable("tasks.csv", "header");
    	for(TableRow row:table.rows())
    	{
        	Tasks t = new Tasks(row);
        	tasks.add(t);
    	}
	}

	public void printTasks()
	{
		for(Tasks t:tasks)
        {
            System.out.println(t);
        }
		
	}
	
	public void mousePressed()
	{
		System.out.println("Mouse pressed");	
	}

	public void mouseDragged()
	{
		System.out.println("Mouse dragged");
	}

	
	
	public void setup() 
	{
	}
	
	public void draw()
	{			
		background(0);
	}
}
