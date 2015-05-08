package asteroids;

import java.util.Iterator;
import java.util.LinkedList;

import java.util.logging.Level;
import java.util.logging.Logger;
import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.BasicGame;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.geom.Vector2f;

public class GameWindow extends BasicGame
{	
	public Ship ship;
	public LinkedList<Bullet> bullets;
	public Bullet bullet;
	
	// Define the asteroids. Make more to correspond with the amount of asteroids that the game should have
	public Asteroid asteroid1, asteroid2, asteroid3, asteroid4, asteroid5;
	
	public static int height = 800; //height of the screen
	public static int width = 600; // width of the screen
		
	//Random r = new Random();
	
	@Override
	public void render(GameContainer gc, Graphics g) throws SlickException
	{
		//render the ship, bullet and asteroids
		ship.render();
		
		asteroid1. render();
		asteroid2.render();
		asteroid3.render();
		asteroid4.render();
		asteroid5.render();
		
		
		//since bullets is a list, a for loop is created
		for( Bullet b: bullets)
		{
			b.render();	
		}
	
		
		// Collision detection between bullets and asteroids
		for(int i=0;  i<bullets.size(); i++)
		{
			
			if(bullets.get(i).getCollisionBox(asteroid1))
			{
				System.out.println("Bullet hit an asteroid");
				asteroid1.active = false;
			}
		
			else if(bullets.get(i).getCollisionBox(asteroid2))
			{
				System.out.println("Bullet hit an asteroid");
				asteroid2.active = false;
			}
			
			else if(bullets.get(i).getCollisionBox(asteroid3))
			{
				System.out.println("Bullet hit an asteroid");
				asteroid3.active = false;
			}
			
			else if(bullets.get(i).getCollisionBox(asteroid4))
			{
				System.out.println("Bullet hit an asteroid");
				asteroid4.active = false;
			}
			
			else if(bullets.get(i).getCollisionBox(asteroid5))
			{
				System.out.println("Bullet hit an asteroid");
				asteroid5.active = false;
			}
		}
		
		
		// Collision detection between ship and asteroids
		
		if(ship.getCollisionBox(asteroid1))
		{
			System.out.println("Bullet hit an asteroid");
			asteroid1.active = false;
		}
	
		else if(ship.getCollisionBox(asteroid2))
		{
			System.out.println("Bullet hit an asteroid");
			asteroid2.active = false;
		}
		
		else if(ship.getCollisionBox(asteroid3))
		{
			System.out.println("Bullet hit an asteroid");
			asteroid3.active = false;
		}
		
		else if(ship.getCollisionBox(asteroid4))
		{
			System.out.println("Bullet hit an asteroid");
			asteroid4.active = false;
		}
		
		else if(ship.getCollisionBox(asteroid5))
		{
			System.out.println("Bullet hit an asteroid");
			asteroid5.active = false;
		}
		
	}
	
	@Override
	public void update(GameContainer gc, int t) throws SlickException 
	{		
		ship.update(gc,t);
		
		asteroid1.update(gc,t);
		asteroid2.update(gc,t);
		asteroid3.update(gc,t);
		asteroid4.update(gc,t);
		asteroid5.update(gc,t);
		
		Iterator<Bullet> i = bullets.iterator();
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
 
		//System.out.println(bullets.size());
		
		if(gc.getInput().isKeyPressed(Input.KEY_SPACE))
		{
			bullets.add(new Bullet(new Vector2f(ship.pos.x, ship.pos.y),ship.rotation));
		}
	}
	
	@Override
	public void init(GameContainer gc) throws SlickException
	{
		gc.setShowFPS(false); // Hide the FPS
		
		ship = new Ship();	
		
		// Create asteroids
		asteroid1 = new Asteroid();
		asteroid2 = new Asteroid();
		asteroid3 = new Asteroid();
		asteroid4 = new Asteroid();
		asteroid5 = new Asteroid();
		
		bullets = new LinkedList<Bullet>();
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