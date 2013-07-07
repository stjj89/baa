package com.me.baa;

public class Bow
{
	private float damage;			// Bow damage
	private float chargeRate;		// % charge gained per pixel traversed when drawing bow
	private float arrowSpeed;		// Arrow speed (TODO: in what units?)
	
	public Bow ( float damage, float chargeRate, float arrowSpeed )
	{
		damage = damage;
		chargeRate = chargeRate;
		arrowSpeed = arrowSpeed;
	}
	
	public float getDamage()
	{
		return damage;
	}
	
	public float getChargeRate()
	{
		return chargeRate;
	}
	
	public float getArrowSpeed()
	{
		return arrowSpeed;
	}
}
