package asteroids;

//import java.awt.Rectangle;

import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.geom.Vector2f;

public class Bullet 
{		
	private Vector2f pos;
	private Vector2f speed;
	private float shipSpeed = 10f;
 
	private boolean active = true;
 
	//private int lived = 0;
	//private static int MAX_LIFETIME = 2000;
 
	public Bullet (Vector2f pos, Vector2f speed) throws SlickException
	{
		this.pos = pos;
		this.speed = speed;
	}
 
	public Bullet (Ship ship) throws SlickException
	{
		active = false;
	}
	
	public Bullet (Vector2f startPos, float rotation)
	{
		this.pos = startPos;
		float x = shipSpeed * (float) (Math.cos( (double) Math.toRadians(rotation)));
		float y = shipSpeed * (float) (Math.sin( (double) Math.toRadians(rotation)));
		this.speed = new Vector2f(x, y);
		System.out.println("bullet rotation: " + rotation);
	}
 
	public void update(int t)
	{
		if(active)
		{
			pos.add(speed);
			//lived += t;
			//if(lived > MAX_LIFETIME) active = false;
		}
	}
 
	public void render(GameContainer gc, Graphics g) throws SlickException 
	{
		if(active)
		{
			g.setColor(Color.red);
			g.fillOval(pos.getX()-10, pos.getY()-10, 20, 20);
		}
	}
 
	public boolean isActive()
	{
		return active;
	}
	/*Rectangle getCollisionBox(Image sprite, int offsetX, int offsetY, int offsetWidth, int offsetHeight)
	{
		return new Rectangle((int)pos.x + offsetX, (int)pos.y + offsetY, sprite.getWidth() + offsetWidth, sprite.getHeight() + offsetHeight);
		
	}*/
}