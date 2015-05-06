package asteroids;

//import java.awt.Rectangle;
import java.util.Random;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Image;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.geom.Vector2f;

public class Asteroid extends Entity {
	
	public float dx, dy;
	public int dir;
	public float size;
	Image asteroid = new Image("data/asteroids.png");
	Image asteroidSmall = new Image("data/asteroids.png");
	
	Random random = new Random();
	
	public Asteroid() throws SlickException
	{
		// Initialize asteroid graphics, and determine starting position
		pos.y = random.nextInt(GameWindow.height);
		pos.x = random.nextInt(GameWindow.width);
		image = asteroid;
		Setup();
	}
	
	public void SplitAsteroid (float size, Vector2f spawnPos) throws SlickException
	{
		// Initialize smaller asteroids
		pos.y = spawnPos.x;
		pos.x = spawnPos.y;
		image = asteroidSmall;
		Setup();
	}

	private void Setup() throws SlickException
	{ 
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

	public void update(GameContainer container, int delta)
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
	/*Rectangle getCollisionBox(Image sprite, int offsetX, int offsetY, int offsetWidth, int offsetHeight)
	{
		return new Rectangle((int)pos.x + offsetX, (int)pos.y + offsetY, sprite.getWidth() + offsetWidth, sprite.getHeight() + offsetHeight);
	}*/
}