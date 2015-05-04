package asteroids;

import java.awt.Rectangle;
import java.util.Random;

import org.newdawn.slick.Image;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;

public class Asteroid extends Entity {
	
	public float maxSpeed;
	public float minSpeed;
	Random random = new Random();
	Image asteroid = new Image("data/asteroids.png");
	public Asteroid() throws SlickException
	{
		pos.y = random.nextInt(GameWindow.height);
		pos.x = random.nextInt(GameWindow.width);
		init();
		
	}

	private void init() throws SlickException
	{ 
		image = asteroid;
		
	}
	
	public void render()
	{
		image.draw(pos.x, pos.y);
	}

	public void update()
	{
		
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
	Rectangle getCollisionBox(Image sprite, int offsetX, int offsetY, int offsetWidth, int offsetHeight)
	{
		return new Rectangle((int)pos.x + offsetX, (int)pos.y + offsetY, sprite.getWidth() + offsetWidth, sprite.getHeight() + offsetHeight);
	}
	}
	

