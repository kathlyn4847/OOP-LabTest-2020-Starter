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
        drawGrid();
		displayTasks();
    }

	public void setup() 
	{

		loadTasks();
        printTasks();
		colorMode(HSB);

	}

	public void displayTasks()
	{
		colorMode(HSB);

		float border = width * 0.06f;
		int c =0;

		for (int i = 0 ; i < tasks.size() ; i ++)
		{
			noStroke();

			Tasks t = tasks.get(i);

			float start = 118;
			float space = 22;

			float x = map(i, 1, tasks.size(), border/0.3f, width -70 );
			float y = map(i, 1, tasks.size(), border/0.3f, width -70 );

			fill(c , 255, 255);
			rect(map(t.getStart(),1 ,30, start, width -70),
			     (x*0.5f) + 15, (t.getEnd() - t.getStart()) * space, 35, 7);

			c = c+30;

			fill(255);
			textAlign(LEFT, CENTER);
			text(t.getName(), border/1.50f , (y*0.49f)+35);

		}
		
	}
	
	public void drawGrid()
	{			
        textAlign(RIGHT, CENTER);
		background(0);

		float border = width * 0.06f;

        for(int i = 1 ; i <= 30 ; i ++)
        {
            float x = map(i, 1, 30, border +70, width -border);
			stroke(255);
            line(x, border, x, height -border );  
            text(i, x, border / 2);
        }

	}

}

