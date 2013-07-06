/*
 * Adopted from http://theinvader360.blogspot.co.uk/2013/05/street-race-swipe-libgdx-scene2d.html
 */

package com.me.baa;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class Assets {
	public static TextureAtlas atlas;
	public static TextureRegion unit, unit2;

	public static void load() {
		// Find atlas
		atlas = new TextureAtlas(Gdx.files.internal("images.pack"));
		
		// Load assets
		unit = atlas.findRegion("unit");
	}

	public static void dispose() {
		atlas.dispose();
	}
}