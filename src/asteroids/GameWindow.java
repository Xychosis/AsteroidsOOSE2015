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
	
	public static int height = 1000; //height of the screen
	public static int width = 1000; // width of the screen
		
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
	
		for(int i=0;  i<bullets.size(); i++)
		{
			if (asteroid1.getCollisionBox(asteroid1.image,10,10,asteroid1.image.getWidth()-20,asteroid1.image.getHeight()-20).intersects(bullets.get(i).getCollisionBox(bullets.get(i).image,5,5,-25,-25))
			 || asteroid2.getCollisionBox(asteroid2.image,10,10,asteroid2.image.getWidth()-20,asteroid2.image.getHeight()-20).intersects(bullets.get(i).getCollisionBox(bullets.get(i).image,5,5,-25,-25))
			 || asteroid3.getCollisionBox(asteroid3.image,10,10,asteroid3.image.getWidth()-20,asteroid3.image.getHeight()-20).intersects(bullets.get(i).getCollisionBox(bullets.get(i).image,5,5,-25,-25))
			 || asteroid4.getCollisionBox(asteroid4.image,10,10,asteroid4.image.getWidth()-20,asteroid4.image.getHeight()-20).intersects(bullets.get(i).getCollisionBox(bullets.get(i).image,5,5,-25,-25))
			 || asteroid5.getCollisionBox(asteroid5.image,10,10,asteroid5.image.getWidth()-20,asteroid5.image.getHeight()-20).intersects(bullets.get(i).getCollisionBox(bullets.get(i).image,5,5,-25,-25)))
				{
					System.out.println("Bullet hit an asteroid");
					//System.out.println("bang!");
				}
			
			//System.out.println(bullets.get(i));
			
		}
		
	
		
		
		// Collision detection between ship and asteroids
		if (asteroid1.getCollisionBox(asteroid1.image,10,10,asteroid1.image.getWidth()-20,asteroid1.image.getHeight()-20).intersects(ship.getCollisionBox(ship.image,20,20,ship.image.getWidth()-25,ship.image.getHeight()-25)))
		{		
			System.out.println("Ship hit asteroid #1");
			asteroid1.active = false;
		}
		
		else if(asteroid2.getCollisionBox(asteroid2.image,10,10,asteroid2.image.getWidth()-20,asteroid2.image.getHeight()-20).intersects(ship.getCollisionBox(ship.image,20,20,ship.image.getWidth()-25,ship.image.getHeight()-25)))
		{
			System.out.println("Ship hit asteroid #2");
			asteroid2.active = false;
		}
		
		else if(asteroid3.getCollisionBox(asteroid3.image,10,10,asteroid3.image.getWidth()-20,asteroid3.image.getHeight()-20).intersects(ship.getCollisionBox(ship.image,20,20,ship.image.getWidth()-25,ship.image.getHeight()-25)))
		{
			System.out.println("Ship hit asteroid #3");
			asteroid3.active = false;
		}
		
		else if( asteroid4.getCollisionBox(asteroid4.image,10,10,asteroid4.image.getWidth()-20,asteroid4.image.getHeight()-20).intersects(ship.getCollisionBox(ship.image,20,20,ship.image.getWidth()-25,ship.image.getHeight()-25)))
		{
			System.out.println("Ship hit asteroid #4");
			asteroid4.active = false;
		}
		
		else if(asteroid5.getCollisionBox(asteroid5.image,10,10,asteroid5.image.getWidth()-20,asteroid5.image.getHeight()-20).intersects(ship.getCollisionBox(ship.image,20,20,ship.image.getWidth()-25,ship.image.getHeight()-25)))
		{
			System.out.println("Ship hit asteroid #5");
			asteroid5.active = false;
		}
		
		// Draw rectangles on objects for debugging
		/*g.drawRect(asteroid1.pos.x+10,asteroid1.pos.y+10,asteroid1.image.getWidth()-20,asteroid1.image.getHeight()-20);
		g.drawRect(asteroid2.pos.x+10,asteroid2.pos.y+10,asteroid2.image.getWidth()-20,asteroid2.image.getHeight()-20);
		g.drawRect(asteroid3.pos.x+10,asteroid3.pos.y+10,asteroid3.image.getWidth()-20,asteroid3.image.getHeight()-20);
		g.drawRect(asteroid4.pos.x+10,asteroid4.pos.y+10,asteroid4.image.getWidth()-20,asteroid4.image.getHeight()-20);
		g.drawRect(asteroid5.pos.x+10,asteroid5.pos.y+10,asteroid5.image.getWidth()-20,asteroid5.image.getHeight()-20);
		g.drawRect(ship.pos.x+5,ship.pos.y+5,ship.image.getWidth()-25,ship.image.getHeight()-25);*/	
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