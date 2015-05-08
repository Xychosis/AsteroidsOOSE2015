package asteroids;



import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.geom.Vector2f;

public class Bullet extends Entity
{		
	//private Vector2f pos;
	private Vector2f speed;
	private float shipSpeed = 10f;
	Image bullet = new Image("data/bullet.png");
 
	private boolean active = true;
	private float lived;
 
	//private int lived = 0;
	//private static int MAX_LIFETIME = 2000;
 
	/*public Bullet (Vector2f pos, Vector2f speed) throws SlickException
	{
		this.pos = pos;
		this.speed = speed;
	
	}
 
	public Bullet (Ship ship) throws SlickException
	{
		active = false;
		
	}*/
	
	public Bullet (Vector2f startPos, float rotation) throws SlickException
	{
		//active = false;
		//this.pos = pos;
		//this.speed = speed;
		this.pos = startPos;
		
		float x = shipSpeed * (float) (Math.cos( (double) Math.toRadians(rotation)));
		float y = shipSpeed * (float) (Math.sin( (double) Math.toRadians(rotation)));
		this.speed = new Vector2f(x, y);
		//System.out.println("bullet rotation: " + rotation);
		image = bullet;
	}
 
	public void update(float t)
	{
		//System.out.println("tempo:" + t);
	
//		
		
		if(active)
		{
			pos.add(speed);
			
			lived += t;
			//if(lived > MAX_LIFETIME) active = false;
		}
		
		if(lived >= 1000)
		{
			active  = false;
		 }
		
		//System.out.println(lived);
		
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
		if(active)
		{
			image.draw(pos.getX(), pos.getY());
		
			//g.setColor(Color.red);
			//g.fillOval(pos.getX(), pos.getY()-10, 20, 20);
		}
	}
 
	public boolean isActive()
	{
		return active;
	}
	
	boolean getCollisionBox(Asteroid other)
	{
		return (this.pos.x - this.image.getWidth()/2 < other.pos.x + other.image.getWidth()/2) &&
                (other.pos.x - other.image.getWidth()/2 < this.pos.x + this.image.getWidth()/2) &&
                (this.pos.y - this.image.getHeight()/2< other.pos.y + other.image.getHeight()/2) &&
                (other.pos.y - other.image.getHeight()/2 < this.pos.y + this.image.getHeight()/2);
		
	}

	
}