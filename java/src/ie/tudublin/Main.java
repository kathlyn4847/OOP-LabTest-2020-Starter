package ie.tudublin;

import processing.core.PApplet;

public class Main
{

    public void Gantt()
	{
		String[] a = {"MAIN"};
        processing.core.PApplet.runSketch( a, new Gantt());
    }
    
    public static void main(String[] arg)
    {
        Main main = new Main();
		main.Gantt();        
    }
}