package asteroids;

import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;

public class FireShot 
{
	
	public static void fireShot(Ship ship, Input input) throws SlickException {
		Shot shot = new Shot(ship); 
	}
}
