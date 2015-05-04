package asteroids;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;







<<<<<<< HEAD
=======

>>>>>>> 957a2a8ea59887164ed3fb1c00f37c0004f72867
import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.BasicGame;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.geom.Vector2f;

public class GameWindow extends BasicGame
{	
	
	//public Enemy asteroid;
	//public float x, y;
	
	public Ship ship;
	public Asteroid asteroid;
	public LinkedList<Bullet> bullets;
	
	public static int height = 900;
	public static int width = 600;
		
	Random r = new Random();
	
	@Override
	public void render(GameContainer gc, Graphics g) throws SlickException
	{
		
		ship.render();
		asteroid.render();
		
		/*for(Bullet b : bullets)
		{
			b.render(gc, g);
		}*/
		
	}
	
	@Override
	public void update(GameContainer gc, int t) throws SlickException 
	{		
		ship.update(gc,t);
		asteroid.update(gc, t);
		
		/*Iterator<Bullet> i = bullets.iterator();
		while(i.hasNext())
		{
			Bullet b = i.next();
			if(b.isActive())
			{
				b.update(t);
			}
			else
			{
				i.remove();
			}
		}
 
		System.out.println(bullets.size());
 
		if(gc.getInput().isKeyPressed(Input.KEY_SPACE))
		{
<<<<<<< HEAD
			bullets.add(new Bullet(new Vector2f(ship.pos.x,ship.pos.y), new Vector2f(ship.pos.x,ship.pos.y)));
		}
		/*if (Asteroid.getCollisionBox(Asteroid.asteroid,10,10,-20,-20).intersects(Ship.getCollisionBox(Ship.ship,5,5,-25,-25)))
		{
			System.out.println("There is Collision!!");
		}*/
		
=======
		bullets.add(new Bullet(new Vector2f(ship.pos.x,ship.pos.y), new Vector2f( ( 0.0025 * t) * Math.sin(Math.toRadians(ship.getRotation()))  )));
		}*/
>>>>>>> 957a2a8ea59887164ed3fb1c00f37c0004f72867
	}
	
	@Override
	public void init(GameContainer gc) throws SlickException
	{
		gc.setShowFPS(false); // Hide the FPS
		
		ship = new Ship();	
		
		for (int i=5; i < 6; i++)
		{
			asteroid = new Asteroid();
		}
		
<<<<<<< HEAD
		bullets = new LinkedList<Bullet>();
		
		
=======
		//bullets = new LinkedList<Bullet>();
>>>>>>> 957a2a8ea59887164ed3fb1c00f37c0004f72867
	}
	
	public GameWindow(String gamename)
	{
		super(gamename);
	}
		
	public static void main(String[] args)
	{
		
	
		try
		{
			// Define the game window, resolution et al.
			AppGameContainer appgc;
			appgc = new AppGameContainer(new GameWindow("Asteroids!"));
			appgc.setDisplayMode(height, width, false);
			appgc.setVSync(true);
			appgc.setTargetFrameRate(60);
			appgc.start();
			
		} 
		catch (SlickException ex)
		{
			Logger.getLogger(GameWindow.class.getName()).log(Level.SEVERE, null, ex);
		}
		
	}
}