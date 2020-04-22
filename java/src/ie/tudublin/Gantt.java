package ie.tudublin;

import java.util.ArrayList;

import processing.core.PApplet;
import processing.data.Table;
import processing.data.TableRow;

public class Gantt extends PApplet
{	

	ArrayList<Tasks> tasks = new ArrayList<Tasks>();

	float border;
    float left;

	float w;
    float h;

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

	public void draw()
    {
        displayTasks();
        drawGrid();
    }

	public void setup() 
	{
		loadTasks();
        printTasks();
		colorMode(HSB);

	}

	
	public void drawGrid()
	{			
        stroke(255, 255, 255);
        textAlign(RIGHT, CENTER);
		background(0);

		float border = width * 0.06f;

		for (int i = 1 ; i < tasks.size() ; i ++)
		{
			float y = map(i, 1, tasks.size(), border+100, width -100 );
			Tasks t = tasks.get(i);
			textAlign(LEFT, CENTER);
			text(t.getName(), border/1.75f , y/1.60f);
		}

        for(int i = 1 ; i <= 30 ; i ++)
        {
            float x = map(i, 1, 30, border +70, width -border);
            line(x, border, x, height -border );  
            fill(255);
            text(i, x, border / 2);
        }

	}

	public void displayTasks()
	{
		
		
	}

}

