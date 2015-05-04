package asteroids;

<<<<<<< HEAD
import java.awt.Rectangle;
=======
>>>>>>> 957a2a8ea59887164ed3fb1c00f37c0004f72867

import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.geom.Vector2f;

 
public class Bullet extends Entity
{
	protected float shotSpeed = 12.0f;
	protected boolean speedAdded = false;
	protected Image shotImage = null;
	
	public Bullet(Ship ship) throws SlickException
	{
		rotation = ship.getRotation();
		vel.x = (float) (shotSpeed * Math.sin(Math.toRadians(rotation)));
		vel.y = (float) (shotSpeed * Math.cos(Math.toRadians(rotation)));
		//AsteroidsGame.entities.get(AsteroidsGame.SHOTS).add(this);
		//Render.addChildAt(this, AsteroidsGame.SHOTS);
	}
	
	@Override
	public void update(GameContainer container, int delta) throws SlickException
	{
		super.update(container, delta);
	}
	
	public void render() {
		image.draw(pos.x,pos.y);
	}

	
	
	
	
	/*private Vector2f pos;
	private Vector2f speed;
	private int lived = 0;
 
	private boolean active = true;
 
	private static int MAX_LIFETIME = 2000;
 
	public Bullet (Vector2f pos, Vector2f speed) throws SlickException
	{
		this.pos = pos;
		this.speed = speed;
	}
 
	public Bullet (Ship ship) throws SlickException
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
<<<<<<< HEAD
	}
	Rectangle getCollisionBox(Image sprite, int offsetX, int offsetY, int offsetWidth, int offsetHeight)
	{
		return new Rectangle((int)pos.x + offsetX, (int)pos.y + offsetY, sprite.getWidth() + offsetWidth, sprite.getHeight() + offsetHeight);
		
	}
=======
	} */
 
>>>>>>> 957a2a8ea59887164ed3fb1c00f37c0004f72867
}