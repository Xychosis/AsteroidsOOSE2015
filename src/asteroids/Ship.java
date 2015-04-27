package asteroids;



import org.newdawn.slick.Image;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;


public class Ship {

	Image ship;
	public static Input input = new Input(0);
	public float dx, dy;
	public float x, y;
	private float speed = 10;
	

	
	public Ship() throws SlickException
	{
		
		// Load image, and subtract the image height/width from the ship's positioning
		ship = new Image("data/ship.png");
		y = (GameWindow.width / 2) - ship.getWidth();
		x = (GameWindow.height / 2) - ship.getHeight();
		
		
	}
	
	
	
	public void render()
	{
		ship.draw(x, y);
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
			ship.rotate(-2);
		}
	
		if(input.isKeyDown(Input.KEY_D))
		{
			ship.rotate(2);
		}
		
		if(input.isKeyDown(Input.KEY_SPACE))
		{
			
		
		}
		
		// Apply movement to the ship
		x += dx;
		y += dy;

	    dx *= 0.98;
	    dy *= 0.98;
	    
	    // Wrapper
	    // Wraps height
	    if (0 > x + ship.getHeight())
		{
			x = GameWindow.height;
		} else if (x > GameWindow.height)
		{
			x = -ship.getHeight();
		}
	    // Wraps width
		if (0 > y + ship.getWidth())
		{
			y = GameWindow.width;
		} else if (y > GameWindow.width)
		{
			y = -ship.getWidth();
		}
	}
}