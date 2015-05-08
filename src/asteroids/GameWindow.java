package asteroids;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.BasicGame;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.geom.Vector2f;

public class GameWindow extends BasicGame
{	
	public Ship ship;
	public LinkedList<Bullet> bullets;
	public Bullet bullet;
	public LinkedList<Asteroid> asteroids;
	
	public boolean numAst = true;
	
	public static int height = 1280; //height of the screen
	public static int width = 1280; // width of the screen
	
	Image life;
	int lifes = 3;
	int score = 0;
	
	@Override
	public void render(GameContainer gc, Graphics g) throws SlickException
	{
		//render the lifes
		if(lifes == 3)
			life.draw(300,300);
		if(lifes >=2)
			life.draw(200,300);
		if(lifes>=1)
			life.draw(100,300);
				
		//render the ship
		ship.render();

		//string output for score
		g.drawString("score: " + score, 990, 300);
		
		//render the asteroids (since asteroids is a list, a for loop is created)
		for( Asteroid a: asteroids)
		{
			a.render();
		}
		
		//render the bullets (since bullets is a list, a for loop is created)
		for( Bullet b: bullets)
		{
			b.render();	
		}
	}
	
	@Override
	public void update(GameContainer gc, int t) throws SlickException 
	{		
		ship.update(gc,t);
		
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
		
		Iterator<Asteroid> j = asteroids.iterator();
		while(j.hasNext())
		{
			Asteroid a= j.next();
			if(a.isActive())
			{
				a.update(gc,t);
			}
			else
			{
				j.remove();
			}
		}
		
		//System.out.println(bullets.size());
		//if SPACE is pressed, add a new bullet to the list
		if(gc.getInput().isKeyPressed(Input.KEY_SPACE))
		{
			bullets.add(new Bullet(new Vector2f(ship.pos.x, ship.pos.y),ship.rotation));
		}
		
		// when numAst is true
		if(numAst)
		{
			// Run loop to spawn the defined number of asteroids at the start. The number is defined in the loop
			for(int index=0;index<6;index++)
			{
				asteroids.add(new Asteroid());
			}	
			numAst = false; // small trick. Otherwise the asteroids are created forever		
		}
		
		// Collision detection between bullets and asteroids
		for(int x=0;  x<bullets.size(); x++)
		{
			for(int y=0; y<asteroids.size();y++)
			{
				// When the bullet collides with an asteroid
				if(bullets.get(x).getCollisionBox(asteroids.get(y)))
				{
					//System.out.println("Bullet hit an asteroid");
					// Remove the asteroid that was hit, and spawn a new one at the same time. Also add 10 points to the total score
					asteroids.remove(asteroids.get(y));
					asteroids.add(new Asteroid());
					score += 10;
								
				}
			}
		}
		
		// Collision detection between ship and asteroids
			for(int y=0; y<asteroids.size();y++)
			{
				// When the ship collides with an asteroid
				if(ship.getCollisionBox(asteroids.get(y)))
				{
					//System.out.println("Ship hit an asteroid");
					// Remove the asteroid and decrement the total amount of lives by one
					asteroids.remove(asteroids.get(y));
					lifes--;	
				}
			}	
			// When there are no lives left
			if(lifes == 0)
			{
				gc.exit();//Exit the game
			}
	}
	
	@Override
	public void init(GameContainer gc) throws SlickException
	{
		gc.setShowFPS(false); // Hide the FPS
	
		// Spawn the game objects
		ship = new Ship();	
		asteroids = new LinkedList<Asteroid>();
		bullets = new LinkedList<Bullet>();
		life = new Image("data/heart.png");
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