package com.me.baa;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Actor;

public class AnimatedSprite {

	Animation                       theAnimation;          
	TextureRegion[]                 animFrames;             
	TextureRegion                   currentFrame;          
	float stateTime;
	
	//Takes in a texture region, split into columns and rows.
	//Change the frame rate in a separate method
	
	public AnimatedSprite( int FRAME_COLS, int FRAME_ROWS, TextureRegion textureIn ) {
		int width = textureIn.getRegionWidth();
		int height = textureIn.getRegionHeight();
		TextureRegion[][] tmp = textureIn.split(width / FRAME_COLS, height / FRAME_ROWS);
		animFrames = new TextureRegion[FRAME_COLS * FRAME_ROWS];
		int index = 0;
		for (int i = 0; i < FRAME_ROWS; i++) {
			for (int j = 0; j < FRAME_COLS; j++) {
				animFrames[index++] = tmp[i][j];
			}
		}
		theAnimation = new Animation(0.025f, animFrames);              
		stateTime = 0f;                       
		currentFrame = theAnimation.getKeyFrame(stateTime, true);
	}
	
	public void changeUpdateRate(float updateRate)
	{
		theAnimation = new Animation(updateRate, animFrames);
	}

	//Only if we want to step our animation forward
	public void update()
	{
		stateTime += Gdx.graphics.getDeltaTime();
		currentFrame = theAnimation.getKeyFrame(stateTime, true);  
	}
	
	public void draw(SpriteBatch batch, float parentAlpha, Actor drawn ) 
	{
		batch.draw( currentFrame, 
				drawn.getX(), drawn.getY(),
				0, 0,
				drawn.getWidth(), drawn.getHeight(),
				1, 1, drawn.getRotation());
	}
}

