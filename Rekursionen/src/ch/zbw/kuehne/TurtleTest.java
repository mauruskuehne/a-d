package ch.zbw.kuehne;
import ch.aplu.turtle.*;

public class TurtleTest {
	
	public TurtleTest()
	{
		Turtle tu = new Turtle();	// Turtle im Zentrum des Frames erzeugt
		tu.hideTurtle(); 	      // Turtle unsichtbar
		
		tu.setX(50);				// Turtle auf X= 100 setzen
		tu.setY(-50);				// Turtle auf Y= -50 setzen
		tu.forward(10);				// zeichne 10 Einheiten vorwärts
		tu.right(45);				// drehe um 45 Grad nach rechts
		tu.forward(20);				// zeichne 20 Einheiten vorwärts
		tu.left(90);				// drehe 90 Grad nach links
		tu.back(100);				// zeichne 100 Einheiten rückwärts
		
		tu.setPos(20,20);	       // Turtle auf X= 20, Y=20 setzen
		tu.forward(20);				// zeichne 20 Einheiten vorwärts
	}

	/**
	 * @param args
	 */
/*	public static void main(String[] args) {
		// TODO Auto-generated method stub

		TurtleTest t = new TurtleTest();
	}
*/
}
