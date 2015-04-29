package asteroids;

import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.geom.Vector2f;
 
public class Bullet
{
	private Vector2f pos;
	private Vector2f speed;
	private int lived = 0;
 
	private boolean active = true;
 
	private static int MAX_LIFETIME = 2000;
 
	public Bullet (Vector2f pos, Vector2f speed)
	{
		this.pos = pos;
		this.speed = speed;
	}
 
	public Bullet (Ship ship)
	{
		active = false;
	}
 
	public void update(int t)
	{
		if(active)
		{
			Vector2f realSpeed = speed.copy();
			realSpeed.scale((t/1000.0f));
			pos.add(realSpeed);
 
			lived += t;
			if(lived > MAX_LIFETIME) active = false;
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
 
}