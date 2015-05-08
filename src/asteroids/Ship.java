package asteroids;



import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Image;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;

public class Ship extends Entity {

	public static Input input = null;
	Image ship = new Image("data/ship-2.png");
	private double rotAmt = 0.3;
	public float accelForce = (float) 0.0055;
	public double forceX, forceY;
	public boolean active = true;
	
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
		// Ship movement
		
		if(input.isKeyDown(Input.KEY_A))
		{
			rotation -= rotAmt * delta;
			image.rotate((float)(-rotAmt * delta));
		}
	
		if(input.isKeyDown(Input.KEY_D))
		{
			rotation += rotAmt * delta;
			image.rotate((float) (rotAmt * delta));
		}
		
		if(input.isKeyDown(Input.KEY_W))
		{	
			forceY = (accelForce * delta) * Math.sin(Math.toRadians(rotation));
			forceX = (accelForce * delta) * Math.cos(Math.toRadians(rotation));
			
			vel.x += (float)forceX;
			vel.y += (float)forceY;
		}
		
		// Apply movement to the ship
		pos.x += vel.x;
		pos.y += vel.y;
		
		// Apply velocity decay
		vel.x *= 0.98;
	    vel.y *= 0.98;
	    
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
		
		super.update(container, delta);
	}
	
	public void render()
	{
		if(active)
		image.draw(pos.x, pos.y);
	}
	
	/*Rectangle getCollisionBox(Image sprite, int offsetX, int offsetY, int offsetWidth, int offsetHeight)
	{
		return new Rectangle((int)pos.x + offsetX, (int)pos.y + offsetY, sprite.getWidth() + offsetWidth, sprite.getHeight() + offsetHeight);
	}*/
	
	boolean getCollisionBox(Asteroid other)
	{
		return (this.pos.x - this.image.getWidth()/2 < other.pos.x + other.image.getWidth()/2) &&
                (other.pos.x - other.image.getWidth()/2 < this.pos.x + this.image.getWidth()/2) &&
                (this.pos.y - this.image.getHeight()/2< other.pos.y + other.image.getHeight()/2) &&
                (other.pos.y - other.image.getHeight()/2 < this.pos.y + this.image.getHeight()/2);
		
	}


}