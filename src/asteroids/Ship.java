package asteroids;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Image;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;

public class Ship extends Entity 
{

	public float accelForce    = (float) 0.0025;
	public static Input input = null;
	private double rotAmt = 0.1;
	public float x,y;
	public float dx,dy;
	public float speed = 10;
	
	Image ship = new Image("data/ship3.png");
	
	public Ship() throws SlickException
	{
		// Load image, and subtract the image height/width from the ship's positioning
		image = ship;
		input = new Input(0);
		pos.y = (GameWindow.width / 2) - image.getWidth() / 2;
		pos.x = (GameWindow.height / 2) - image.getHeight() / 4;
	}
	
	public void update(GameContainer container, int delta) throws SlickException
	{
		// Player movements
		
		if(input.isKeyDown(Input.KEY_A))
		{
			rotation -= rotAmt * delta;
			image.rotate((float)(-rotAmt * delta));
		}
	
		if(input.isKeyDown(Input.KEY_D))
		{
			rotation += rotAmt * delta;
			image.rotate((float) (rotAmt * delta));
			//image.rotate(2);
		}
		
		if(input.isKeyDown(Input.KEY_W))
		{	
			dx += Math.cos(Math.toRadians(ship.getRotation())) * speed * 0.01; 
			dy += Math.sin(Math.toRadians(ship.getRotation())) * speed * 0.01; 	
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
	
	public void render()
	{
		image.draw(pos.x, pos.y);
	}


	public float getX() {
		return pos.x;
	}
	
	public float getY() {
		return pos.y;
	}
	
	public float getXVel() {
		return vel.x;
	}
	
	public float getYVel() {
		return vel.y;
	}
	
	
	public float getRotation() {
		
		return rotation;
	}

	
}