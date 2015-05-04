package asteroids;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.Renderable;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.geom.Vector2f;

public class Entity implements Renderable {
	
	protected Vector2f pos = new Vector2f(0,0);
	protected Vector2f vel = new Vector2f(0,0);
	protected Image image = null;
	protected float rotation = 0;
	protected float scale = 1.0f;
	
	public Entity() throws SlickException
	{
	}

	public void update(GameContainer container, int delta) throws SlickException 
	{
		pos.x += vel.x;
		pos.y -= vel.y;
	}
	
	public float getX()
	{
		return pos.x;
	}
	
	public float getY()
	{
		return pos.y;
	}
	
	public float getWidth()
	{
		return image.getWidth() * scale;
	}
	
	public float getHeight()
	{
		return image.getHeight() * scale;
	}
	
	public void render(GameContainer container, Graphics g) throws SlickException
	{
		image.setRotation(rotation);
		image.draw(pos.x - image.getWidth()/2, pos.y - image.getHeight()/2, scale);
	}

	@Override
	public void draw(float arg0, float arg1) {
		// TODO Auto-generated method stub	
	}


	
	
}