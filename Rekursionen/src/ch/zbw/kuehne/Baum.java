package ch.zbw.kuehne;

import ch.aplu.turtle.Turtle;

public class Baum {

	Turtle tu = new Turtle();
		  
	Baum()
	{
		tu.hideTurtle();
		tu.setX(0);
		tu.setY(-200);
		//tu.right(90);
		
		zeichne();
	}

	void zeichne()
	{
		zeichneBaum(200);
		
		/*
		tu.hideTurtle(); 	      // Turtle unsichtbar
		
		tu.setX(50);				// Turtle auf X= 100 setzen
		tu.setY(-50);				// Turtle auf Y= -50 setzen
		tu.forward(10);				// zeichne 10 Einheiten vorwärts
		tu.right(45);				// drehe um 45 Grad nach rechts
		tu.forward(20);				// zeichne 20 Einheiten vorwärts
		tu.left(90);				// drehe 90 Grad nach links
		tu.back(100);				// zeichne 100 Einheiten rückwärts
		
		tu.setPos(20,20);	       // Turtle auf X= 20, Y=20 setzen
		tu.forward(20);				// zeichne 20 Einheiten vorwärts*/
	}
	
	void zeichneBaum(float height)
	{
		if(height < 5)
		{
			tu.forward(height);
			tu.back(height);
			return;
		}
		
		tu.forward(height);
		tu.left(45);
		zeichneBaum(height / 2);
		tu.right(90);
		zeichneBaum(height / 2);
		tu.left(45);
		tu.back(height);
		
	}
		

	public static void main(String[] args)
	{
		new Baum();
	}
}
