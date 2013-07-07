package com.me.baa;

import com.badlogic.gdx.graphics.g2d.TextureRegion;

public abstract class Bow
{
	private ArcherGame archerGame;	// reference to the archer game
	private float damage;			// Bow damage
	private float chargeRate;		// % charge gained per pixel traversed when drawing bow
	private float arrowSpeed;		// Arrow speed (pixels per second)
	private float charge;			// Amount of charge held in drawn bow
	private TextureRegion proj;		// Texture for the bow's projectile
	
	/**
	 * Creates a Bow
	 * 
	 * @param game reference to the archer game
	 * @param damage bow damage
	 * @param chargeRate % charge gained per pixel traversed when drawing bow
	 * @param arrowSpeed arrow speed (pixels per second)
	 * @param projTexture texture for the bow's projectile
	 */
	public Bow( ArcherGame game, float damage, float chargeRate, float arrowSpeed, TextureRegion projTexture )
	{
		archerGame = game;
		this.damage = damage;
		this.chargeRate = chargeRate;
		this.arrowSpeed = arrowSpeed;
		proj = projTexture;
		charge = 0.0f;
	}
	
	/**
	 * Create a projectile from this bow
	 */
	public void fire()
	{
		// archerGame.createProjectile();
	}
	
	/**
	 * Updates the "charge" of the bow as it is being drawn
	 * 
	 * @param distance distances (in pixels) moved by mouse
	 */
	public void drawBow( float distance )
	{
		charge += chargeRate * distance;
	}
	
	/**
	 * Gets the damage of the bow
	 * @return damage of bow
	 */
	public float getDamage()
	{
		return damage;
	}
	
	/**
	 * Gets the charging rate of thebow
	 * @return charging rate of bow
	 */
	public float getChargeRate()
	{
		return chargeRate;
	}
	
	/**
	 * Gets the arrow speed of the bow
	 * @return arrow speed of bow (in pixels per second)
	 */
	public float getArrowSpeed()
	{
		return arrowSpeed;
	}
}
