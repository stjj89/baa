/*
 * Adopted from http://theinvader360.blogspot.co.uk/2013/05/street-race-swipe-libgdx-scene2d.html
 */

package com.me.baa;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class Assets {
	public static TextureAtlas atlas;
	public static TextureRegion unit;
	public static TextureRegion arrow;
	public static TextureRegion powerBar;
	public static TextureRegion background;
	public static TextureRegion testanim;

	public static void load() {
		// Find atlas
		atlas = new TextureAtlas(Gdx.files.internal("images.pack"));
		
		// Load assets

		unit 		= atlas.findRegion("unit");
		arrow 		= atlas.findRegion("arrow");
		powerBar 	= atlas.findRegion("powerBar");
		background 	= atlas.findRegion("sampleLevel");
		testanim = atlas.findRegion("animation_sheet");
	}

	public static void dispose() {
		atlas.dispose();
	}
}