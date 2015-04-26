package asteroids;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.BasicGame;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;

public class GameWindow extends BasicGame
{	
	public Ship ship;
	//public Enemy asteroid;
	
	//public float x, y;
	public static int height = 900;
	public static int width = 600;
	
	Random r = new Random();
	
	public GameWindow(String gamename)
	{
		super(gamename);
	}
	
	@Override
	public void init(GameContainer gc) throws SlickException
	{
		// Hide the FPS
		gc.setShowFPS(false);
		
		ship = new Ship();
		
	}
	
	@Override
	public void update(GameContainer gc, int i) throws SlickException 
	{		
		ship.update();
	}

	@Override
	public void render(GameContainer gc, Graphics g) throws SlickException
	{
		ship.render();
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