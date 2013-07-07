package com.me.baa;

import static com.badlogic.gdx.scenes.scene2d.actions.Actions.*;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.math.Vector2;

public class PlayerArcher extends Actor {
	private ArcherGame archerGame;
	private Rectangle bounds = new Rectangle();
	private Bow bow;
	private float charge;							// Amount of charge player has in drawn bow
	private AnimatedSprite sprite;
	private float speed = 200.0f;					// Archer speed in pixels per second
	private boolean pressWasHeld;					// Flag for whether or a mouse/screen press was held on last update 
	private float lastX, lastY;						// X and Y coords on last update (if press was held)
	private Vector2 pressToArcherV;					// Vector from pressed point to the archer sprite
	
	public PlayerArcher(ArcherGame archerGame) {
		this.archerGame = archerGame;
		setWidth(32);
		setHeight(32);
		this.setOrigin( getWidth()/2, getHeight()/2 ); // Origin is the center of the sprite
		setPosition( archerGame.getWidth() / 2, archerGame.getHeight() / 2); // Start in center of screen
		setColor(Color.WHITE);
		charge = 0;
		sprite = new AnimatedSprite(6, 5, Assets.testanim );
		sprite.changeUpdateRate(0.1f);
		pressWasHeld = false;
		lastX = lastY = 0.0f;
	}

	public void updateCharge(int oldX, int oldY, int newX, int newY)
	{
		double distanceMoved = Math.sqrt( (Math.pow( newX - oldX, 2 ) + Math.pow( newY - oldY, 2 ) ) );
		// TODO
	}
	
	public void rotate(int x, int y)
	{
		// System.out.println("Origin X=" + this.getOriginX() + " Origin Y=" + this.getOriginY());
		System.out.println("x=" + x + " y=" + y);
		System.out.println("MiddleX=" + (getX() + 16) + " MiddleY=" + (getY() + 16));
		System.out.println( ( MathUtils.atan2( y - (getY() + 16), x - (getX() + 16) ) ) * (180/Math.PI) );
	}
	
	// Movement logic for playerArcher handled ehre
	@Override
	public void act(float delta) {
		Vector2 a, b;
		super.act(delta);
		//updateBounds();	// Might not need this anymore
		
		updateArcherPosition(delta);
		updateBow(delta);
	}
	
	private void updateBow(float delta)
	{
		Vector2 pressedV, archerCenterV, heldV, pressedToHeldV;
		float angle;
		
		double distanceMoved;
		
		if (archerGame.pressed)
		{
			// TODO: THIS VECTOR MATH IS WRONG
			if (!pressWasHeld)
			{
				pressWasHeld = true;
				lastX = archerGame.pressedX;
				lastY = archerGame.pressedY;
				archerCenterV = new Vector2( getX() + getWidth()/2, getY() + getHeight()/2 );
				pressedV = new Vector2( archerGame.pressedX, archerGame.pressedY );
				pressToArcherV = archerCenterV.sub(pressedV);
				
			}
			else
			{
				// Make sure mouse is dragged "behind" the pressed point
				heldV = new Vector2( archerGame.currentX, archerGame.currentY );
				pressedV = new Vector2( archerGame.pressedX, archerGame.pressedY ); // could be saved instead
				pressedToHeldV = heldV.sub(pressedV);
				angle = (float) Math.acos( pressToArcherV.dot(pressedToHeldV) / ( pressToArcherV.len() * pressedToHeldV.len() ) );
				
//				System.out.println("Angle (rad) = " + angle);
				System.out.println(pressToArcherV.dot(pressedToHeldV) );
				if ( angle < (Math.PI / 2) )
				{
					distanceMoved = Math.sqrt( Math.pow( archerGame.pressedX - lastX, 2) + Math.pow(archerGame.pressedY - lastY, 2) );
					bow.drawBow( (float)distanceMoved );
				}
				
			}
		}
		else // No mouse/touch press
		{
			if (pressWasHeld)
			{
				bow.fire();
				pressWasHeld = false;
			}
		}
	}

	private void updateArcherPosition(float delta)
	{
		float proposedX, proposedY, dx, dy, moveDelta;
		
		// Calculate proposed move coordinates
				dx = 0;
				dy = 0;
				moveDelta = speed * delta;
				
				if (archerGame.wPressed)
					dy = moveDelta;
				if (archerGame.aPressed)
					dx = -moveDelta;
				if (archerGame.sPressed)
					dy = -moveDelta;
				if (archerGame.dPressed)
					dx = moveDelta;
				
				if ( (0 != dx) || (0 != dy) )
				{
					dx *= 0.7071; // 1/sqrt(2)
					dy *= 0.7071; // 1/sqrt(2)
				}
				
				proposedX = getX() + dx;
				proposedY = getY() + dy;
				
				// Check for collisions with obstacles and move if there are none
				if ( !checkObstacleCollisions(proposedX, proposedY) )
					setPosition(proposedX, proposedY);
	}
	
	// TODO: implement
	private boolean checkObstacleCollisions(float x, float y)
	{
		return false;
	}
	
	@Override
	public void draw(SpriteBatch batch, float parentAlpha) {
		batch.setColor(getColor().r, getColor().g, getColor().b, getColor().a);
		sprite.update();
		sprite.draw( batch, parentAlpha, this );
//		batch.draw( Assets.unit,
//				getX(), getY(), 
//				/*getWidth() / 2, getHeight() / 2*/ 0, 0 , /* these are offsets, might need to change */
//				getWidth(), getHeight(), 1, 1, getRotation());
	}

}
