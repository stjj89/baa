package com.me.baa;

import static com.badlogic.gdx.scenes.scene2d.actions.Actions.*;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Actor;

public class BackgroundLevel extends Actor {
	private TextureRegion image;
	
	public BackgroundLevel(	float width, 					// Width of the background
							float height,					// Height of the background
							TextureRegion backgroundImage)	// Background image
	{
		setWidth(width);
		setHeight(height);
		setPosition(0, 0);
		this.image = backgroundImage;
	}

	@Override
	public void draw(SpriteBatch batch, float parentAlpha) {
		super.draw(batch, parentAlpha);
		batch.draw(image, getX(), getY(), getWidth(), getHeight() );
	}
}

