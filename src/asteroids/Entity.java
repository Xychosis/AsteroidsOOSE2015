package asteroids;

import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.geom.Vector2f;

public class Entity {
	
	protected Vector2f pos = new Vector2f(0,0);
	protected Vector2f vel = new Vector2f(0,0);
	protected Image image = null;
	
	public Entity() throws SlickException
	{

	}
	
	public void update() throws SlickException
	{
		
	}
}