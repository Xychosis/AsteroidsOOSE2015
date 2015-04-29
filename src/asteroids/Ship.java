package asteroids;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Image;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;

public class Ship extends Entity {

	public static Input input = new Input(0);
	public float dx, dy;
	private float speed = (float) 10;
	Image ship = new Image("data/ship.png");;
	
	public Ship() throws SlickException
	{
		// Load image, and subtract the image height/width from the ship's positioning
		image = ship;
		pos.y = (GameWindow.width / 2) - image.getWidth();
		pos.x = (GameWindow.height / 2) - image.getHeight();
	}
	
	public void render()
	{
		image.draw(pos.x, pos.y);
	}

	public void update()
	{
		// Player movement
		if(input.isKeyDown(Input.KEY_W))
		{
			dx += Math.sin(Math.toRadians(ship.getRotation())) * speed * 0.01;
			dy += -Math.cos(Math.toRadians(ship.getRotation())) * speed * 0.01;
		}
	
		if(input.isKeyDown(Input.KEY_A))
		{
			image.rotate(-2);
		}
	
		if(input.isKeyDown(Input.KEY_D))
		{
			image.rotate(2);
		}
		
		if(input.isKeyDown(Input.KEY_SPACE))
		{
			// bullet here
		}
		// Apply movement to the ship
		pos.x += dx;
		pos.y += dy;

	    dx *= 0.98;
	    dy *= 0.98;
	    
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