package asteroids;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

public class Shot extends Bullet
{

	
	
	public static float fireDelay = 300f;
	//private float life            = 700f;
	private float modShotSpeed    = 0; 
	
	
	public Shot(Ship ship) throws SlickException 
	{
		super(ship);
		image =  new Image("data/ship3.jpg");
		pos.x = ship.getX() + ship.getWidth() / 2 - this.getWidth() / 2;
		pos.y = ship.getY();
		shotSpeed += modShotSpeed;
		image.rotate(rotation);
	}
	
	@Override
	public void update(GameContainer container, int delta) throws SlickException {
		/*life -= delta;
		if (life <= 0) {
			//if (AsteroidsGame.entities.get(AsteroidsGame.SHOTS).contains(this))
				//AsteroidsGame.entities.get(AsteroidsGame.SHOTS).remove(this);
			Render.removeChild(this);
		}
		else
			super.update(container, delta);*/
	} 
}
