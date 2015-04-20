package asteroids;

import org.newdawn.slick.BasicGame;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;

public class Player {

	Image ship;
	public static Input input = new Input(0);
	private float dx, dy;
	private float x, y;
	private float speed = 10;
	
	public Player() throws SlickException
	{
		ship = new Image("data/ship.png");
		x = 400;
		y = 300;
	}
	
	void wrapper (Image ship)
	{
		//Screen wrap
		if (y < 0-(ship.getHeight()))
		{
			y = GameWindow.height;
		}
		if (y > GameWindow.height)
		{
			y = 0-(ship.getHeight());
		}
		if (x < 0-(ship.getWidth()))
		{
			x = GameWindow.width;
		}
		if (x > GameWindow.width)
		{
			x = 0-(ship.getWidth());
		}
	}
	
	public void render()
	{
		ship.draw(x, y);
	}

	public void update()
	{
		// Player movement
		if(input.isKeyDown(Input.KEY_W))
		{
			dx += Math.sin(Math.toRadians(ship.getRotation())) * speed * 0.01;
			dy += -Math.cos(Math.toRadians(ship.getRotation())) * speed * 0.01;
		}
	
		if(input.isKeyDown(Input.KEY_A))
		{
			ship.rotate(-2);
		}
	
		if(input.isKeyDown(Input.KEY_D))
		{
			ship.rotate(2);
		}
	
		x += dx;
		y += dy;

	    dx *= 0.98;
	    dy *= 0.98;
	}
}