package Astr_pack;

import java.awt.*;

public class AsteroidPlayer {
	// define the shape of the Player
	final double[] origXPts = {14,-10,-6,-10}, origYPts = {0,-8,0,8};
	final int radius = 6; // radius of circle used to approximate the Player
	
	double x, y, angle, xVelocity, yVelocity, acceleration,
		velocityDecay, rotationalSpeed; //variables used in movement
	boolean turningLeft, turningRight, accelerating, active;
	int[] xPts, yPts; //store the current locations of the points used to draw the Player
					
	int BulletDelay, BulletDelayLeft; //used to determine the rate of firing

	public AsteroidPlayer (double x, double y, double angle, double acceleration,
			double velocityDecay, double rotationalSpeed,
			int BulletDelay){
			// this.x refers to the Player's x, x refers to the x parameter
			this.x=x;
			this.y=y;
			this.angle=angle;
			this.acceleration=acceleration;
			this.velocityDecay=velocityDecay;
			this.rotationalSpeed=rotationalSpeed;
			xVelocity=0; // not moving
			yVelocity=0;
			turningLeft=false; // not turning
			turningRight=false;
			accelerating=false; // not accelerating
			xPts=new int[4]; // allocate space for the arrays
			yPts=new int[4];
			this.BulletDelay=BulletDelay; // # of frames between Bullets
			BulletDelayLeft=0; // ready to shoot
			}


public void draw(Graphics g){
	//rotate the points, translate them to the Player's location (by adding x and y), then round them by adding .5 and casting them as integers (which truncates any decimal place)
	
	if(accelerating && active){ 
	//calculate the polygon for the Player, then draw it
	for(int i=0;i<3;i++){
	xPts[i]=(int)(origXPts[i]*Math.cos(angle)- //rotate
	origYPts[i]*Math.sin(angle)+
	x+.5); //translate and round
	yPts[i]=(int)(origXPts[i]*Math.sin(angle)+ //rotate
	origYPts[i]*Math.cos(angle)+
	y+.5); //translate and round
	}
	g.setColor(Color.white);
	g.fillPolygon(xPts,yPts,3); // 4 is the number of points
	}
}

public void move(int scrnWidth, int scrnHeight){
if(BulletDelayLeft>0) //move() is called every frame that the game is run, so this ticks down the Bullet delay
BulletDelayLeft--; 
if(turningLeft) //this is backwards from typical polar coordinates
angle-=rotationalSpeed; //because positive y is downward.
if(turningRight) //Because of that, adding to the angle is rotating clockwise (to the right)
angle+=rotationalSpeed;
if(angle>(2*Math.PI)) //Keep angle within bounds of 0 to 2*PI
angle-=(2*Math.PI);
else if(angle<0)
angle+=(2*Math.PI);
if(accelerating){ //adds accel to velocity in direction pointed
//calculates components of accel and adds them to velocity
xVelocity+=acceleration*Math.cos(angle);
yVelocity+=acceleration*Math.sin(angle);
}
x+=xVelocity; //move the Player by adding velocity to position
y+=yVelocity;
xVelocity*=velocityDecay; //slows Player down by percentages
yVelocity*=velocityDecay; //should be a decimal between 0 and 1
if(x<0) //wrap the Player around to the opposite side of the screen when it goes out of the screen's bounds
x+=scrnWidth; 
else if(x>scrnWidth)
x-=scrnWidth;
if(y<0)
y+=scrnHeight;
else if(y>scrnHeight)
y-=scrnHeight;
}

public void setAccelerating(boolean accelerating){
this.accelerating=accelerating; //start or stop accelerating the Player
}

public void setTurningLeft(boolean turningLeft){
this.turningLeft=turningLeft; //start or stop turning the Player
}
public void setTurningRight(boolean turningRight){
this.turningRight=turningRight;
}
public double getX(){
return x; // returns the Player’s x location
}
public double getY(){
return y;
}
public double getRadius(){
return radius; // returns radius of circle that approximates the Player
}
public boolean canShoot(){
if(BulletDelayLeft>0) //checks to see if the Player is ready to shoot again yet or if it needs to wait longer
return false; 
else
return true;
}

public AsteroidsBullet shoot(){
BulletDelayLeft = BulletDelay; //set delay till next bullet can be fired
//a life of 40 makes the bullet travel about the width of the
//screen before disappearing
return new AsteroidsBullet(x,y,angle,xVelocity,yVelocity,40);
}
}
