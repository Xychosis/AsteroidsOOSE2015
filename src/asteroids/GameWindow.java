package asteroids;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.BasicGame;
import org.newdawn.slick.Game;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.geom.Vector2f;

public class GameWindow extends BasicGame
{	
	public Ship ship;
	public LinkedList<Bullet> bullets;
	
	// Define the asteroids. Make more to correspond with the amount of asteroids that the game should have
	public Asteroid asteroid1;
	public Asteroid asteroid2;
	public Asteroid asteroid3;
	public Asteroid asteroid4;
	public Asteroid asteroid5;
	
	public static int height = 1280;
	public static int width = 720;
		
	Random r = new Random();
	
	@Override
	public void render(GameContainer gc, Graphics g) throws SlickException
	{
		ship.render();
		
		asteroid1.render();
		asteroid2.render();
		asteroid3.render();
		asteroid4.render();
		asteroid5.render();
		
		for(Bullet b : bullets)
		{
			b.render(gc, g);
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
		
		/*if (Asteroid.getCollisionBox(Asteroid.asteroid,10,10,-20,-20).intersects(Ship.getCollisionBox(Ship.ship,5,5,-25,-25)))
		{
			System.out.println("There is Collision!!");
		}*/
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