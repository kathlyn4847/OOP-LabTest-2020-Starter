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

		float leftSide = 0;
		float rightSide = 0; 
		

		for(int i = 0 ; i < tasks.size() ; i ++)
        {
            float y = map(i, 0, tasks.size(), border, height - border);
            if (mouseX > leftSide && mouseX < rightSide + w 
                && mouseY > y && mouseY < y + h                 
                )
                {
                    tasks.add(tasks.get(i));
					//mouseDragged(i);
                    break;
                }

        }

    }

	public void mouseDragged()
	{
		int i=0;
		System.out.println("Mouse dragged");
			int c =0; //to change colour with colorMode(HSB)
			float border = width * 0.06f;

			noStroke();

			Tasks t = tasks.get(i);

			float start = 118; // space from edge of screen to start of grid
			float space = 22; //space between lines
			float range = t.getEnd() - t.getStart();
			float moveEnd = t.getEnd() + mouseX;

			range = moveEnd;

			float x = map(i, 1, tasks.size(), border/0.3f, width -70 );
			float y = map(t.getStart(),1 ,30, start, width - border);

			//make the rectangles
			fill(c , 255, 255);
			rect(y, ( x * 0.5f ) + 15, moveEnd, 35, 7);

			c = c+30; //change to next colour
		
		
		
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
		int c =0; //to change colour with colorMode(HSB)

		for (int i = 0 ; i < tasks.size() ; i ++)
		{
			noStroke();

			Tasks t = tasks.get(i);

			float start = 118; // space from edge of screen to start of grid
			float space = 22; //space between lines
			float range = t.getEnd() - t.getStart();

			float x = map(i, 1, tasks.size(), border/0.3f, width -70 );
			float y = map(t.getStart(),1 ,30, start, width - border);

			//rectangles
			fill(c , 255, 255);
			rect(y, ( x * 0.5f ) + 15, (range) * space, 35, 7);


			c = c+30; //change to next colour

			//tasks along side of window
			fill(255);
			textAlign(LEFT, CENTER);
			text(t.getName(), border/1.50f , (x*0.49f)+35);

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

