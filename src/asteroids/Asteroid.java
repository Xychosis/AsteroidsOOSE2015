package asteroids;

import java.util.Random;

import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

public class Asteroid extends Entity {
	
	public float dx, dy;
	public int dir;
	
	Random random = new Random();
	
	public Asteroid() throws SlickException
	{
		// Initialize asteroid graphics, and determine starting position
		pos.y = random.nextInt(GameWindow.height);
		pos.x = random.nextInt(GameWindow.width);
		Setup();
	}
	
	private void Setup() throws SlickException { 
		image = new Image("data/asteroids.png");
		
		// Generate random numbers to determine speed
		dx = random.nextInt(5);
		dy = random.nextInt(5);
				
		// Generate a random number to determine direction
		dir = random.nextInt(3);
	}
	
	public void render()
	{
		image.draw(pos.x, pos.y);
	}

	@Override
	public void update()
	{
		// Check for the direction of the asteroid, then apply the movement to it
		if (dir == 0)
		{
			pos.x += dx;
			pos.y += dy;
		} else if (dir == 1)
		{
			pos.x -= dx;
			pos.y -= dy;
		} else if (dir == 2)
		{
			pos.x -= dx;
			pos.y += dy;
		} else if (dir == 3) {
			pos.x += dx;
			pos.y -= dy;	
		}

		// Wraps height
	    if (0 > pos.x + image.getHeight())
		{
			pos.x = GameWindow.height;
		} else if (pos.x > GameWindow.height)
		{
			pos.x = -image.getHeight();
		}
	    
	    // Wraps width
		if (0 > pos.y + image.getWidth())
		{
			pos.y = GameWindow.width;
		} else if (pos.y > GameWindow.width)
		{
			pos.y = -image.getWidth();
		}
	}
}