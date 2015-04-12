package Astr_pack;

import java.awt.*;

public class AsteroidsBullet {
	final double bulletSpeed=12; //the speed at which the bullets move, in pixels per frame
	double x,y,xVelocity,yVelocity; //variables for movement 
	int lifeLeft; //causes the bullet to eventually disappear if it doesn’t hit anything
	public AsteroidsBullet(double x, double y, double angle, double playerXVel,
	double playerYVel, int lifeLeft){
	this.x=x;
	this.y=y;
	// add the velocity of the player to the bullet velocity (so the bullet's velocity is relative to the player's velocity) 

	xVelocity=bulletSpeed*Math.cos(angle)+playerXVel;
	yVelocity=bulletSpeed*Math.sin(angle)+playerYVel;
	// the number of frames the bullet will last for before disappearing if it doesn't hit anything
	this.lifeLeft=lifeLeft;
	}
	public void move(int scrnWidth, int scrnHeight){
	lifeLeft--; // used to make bullet disappear if it goes too long without hitting anything
	x+=xVelocity; // move the bullet
	y+=yVelocity;
	if(x<0) // wrap the bullet around to the opposite side of the screen if needed
	x+=scrnWidth;  
	else if(x>scrnWidth)
	x-=scrnWidth;
	if(y<0)
	y+=scrnHeight;
	else if(y>scrnHeight)
	y-=scrnHeight;
	}
	public void draw(Graphics g){
	g.setColor(Color.yellow); //set bullet color
	//draw circle of radius 3 centered at the closest point with integer coordinates (.5 added to x-1 and y-1 for rounding)
	g.fillOval((int)(x-.5), (int)(y-.5), 3, 3);
	}
	public double getX(){
	return x;
	}
	public double getY(){
	return y;
	}
	public int getLifeLeft(){
	return lifeLeft;
	}
	}