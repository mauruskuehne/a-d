package ch.zbw.kuehne;

import ch.aplu.turtle.Turtle;

public class Quadrate {

	Turtle tu = new Turtle();
		  
	Quadrate()
	{
		tu.hideTurtle();
		tu.setX(-50);
		tu.setY(-200);
		//tu.right(90);
		
		zeichne();
	}

	void zeichne()
	{
		
		zeichneQuadrate(100);
		
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
	
	void zeichneQuadrate(double width)
	{
		if(width < 1)
		{
			zeichneEinQuadrat(width);
			return;
		}
		
		zeichneEinQuadrat(width);
		double currPosX = tu.getX();
		double currPosY = tu.getY();
		
		//rechte Seite
		tu.setPos(currPosX + width + (width/4), currPosY + width + (width/4));
		zeichneQuadrate(width / 2);
		
		tu.setPos(currPosX - (width/2) - (width/4), currPosY + width + (width/4));
		zeichneQuadrate(width / 2);
	}
	
	void zeichneEinQuadrat(double height)
	{
		tu.forward(height);
		tu.right(90);
		tu.forward(height);
		tu.right(90);
		tu.forward(height);
		tu.right(90);
		tu.forward(height);
		tu.right(90);
	}
		

	public static void main(String[] args)
	{
		new Quadrate();
	}
}
