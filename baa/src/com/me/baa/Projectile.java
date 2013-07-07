package com.me.baa;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.scenes.scene2d.Actor;

public class Projectile extends Actor {
	private ArcherGame archerGame;
	private Rectangle bounds = new Rectangle();
	private int STATE; //0 for Birth, 1 for Flight, 2 for Death
	private AnimatedSprite sprite;
	private AnimatedSprite birth;
	private AnimatedSprite flying;
	private AnimatedSprite death;
	private float dx;
	private float dy;
	private float heading;
	private float speed = 50f;
	
	public Projectile (ArcherGame archerGame, float xloc, float yloc, float heading) {
		this.archerGame = archerGame;
		
		setSize(32, 32); //Sets the size
		setPosition(xloc, yloc); // Set start position
		setColor(Color.WHITE);
		
		//Initialize animations
		setBirth(new AnimatedSprite(6, 5, Assets.testanim), 0.05f);
		setFlying(new AnimatedSprite(1, 1, Assets.arrow), 1.0f);
		setDeath(new AnimatedSprite(6, 5, Assets.arrow), 0.5f);
		sprite = birth;
		
		//Set speeds
		this.heading = heading; //Heading is in DEGREES
		dx = (float) (speed * -Math.sin(Math.toRadians(heading)));
		dy = (float) (speed * Math.cos(Math.toRadians(heading)));
		this.rotate(heading);
		//Todo: Radians and Degrees conversion
		//Collision formulae
	}
	
	/**
	 * Sets the birth animation
	 * @param birth
	 * @param updateRate
	 */
	public void setBirth(AnimatedSprite birth, float updateRate){
		this.birth = birth;
		this.birth.changeUpdateRate(updateRate);
	}
	
	/**
	 * Sets the flying animation
	 * @param flying
	 * @param updateRate
	 */
	public void setFlying(AnimatedSprite flying, float updateRate){
		this.flying = flying;
		this.flying.changeUpdateRate(updateRate);
	}
	
	/**
	 * Sets the death animation
	 * @param death
	 * @param updateRate
	 */
	public void setDeath(AnimatedSprite death, float updateRate){
		this.death = death;
		this.death.changeUpdateRate(updateRate);
	}
	
	/**
	 * Adds functionality to reset origin
	 */
	public void setSize(float width, float height) {
		super.setSize(width, height);
		this.setOrigin( getWidth()/2, getHeight()/2 );
	}
	
	public void setSpeed(float speed){
		this.speed = speed;
	}
	
	/**
	 * This method is private, and simply deals with ending of birth and death animations
	 */
	private void updateAnimations() {
		//BUG PRONE: Does not occur if we skip the last frame of animation
		if(sprite.currentFrame == sprite.animFrames[sprite.animFrames.length-1]) //We are at our last frame
		{
			switch(STATE){
			case 0:
				STATE = 1;
				sprite = flying;
				break;
			case 1:
				//We don't need to do anything
				break;
			case 2:
				//Here, we can garbage collect - remove sprite from arraylist, etc.
				this.remove();
				break;
			}
		}
	}
	
	public void act(float delta) {
		super.act(delta);
		this.translate(delta*dx, delta*dy);
		updateAnimations();
		updateBounds();
	}

	//Don't need to care about these methods
	public void draw(SpriteBatch batch, float parentAlpha) {
		sprite.update();
		sprite.draw( batch, parentAlpha, this );
	}

	// Might not need this anymore
	private void updateBounds() {
		bounds.set(getX(), getY(), getWidth(), getHeight());
	}

	public Rectangle getBounds() {
		return bounds;
	}
}
