package com.me.baa;

import static com.badlogic.gdx.scenes.scene2d.actions.Actions.*;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.scenes.scene2d.Actor;

public class PlayerArcher extends Actor {
	private ArcherGame archerGame;
	private Rectangle bounds = new Rectangle();
	
	public PlayerArcher(ArcherGame archerGame) {
		this.archerGame = archerGame;
		setWidth(32);
		setHeight(32);
		setPosition( archerGame.getWidth() / 2, archerGame.getHeight() / 2); // Start in enter of screen
		setColor(Color.YELLOW); // Can we change this color?
	}

	@Override
	public void act(float delta) {
		super.act(delta);
		updateBounds();	// Might not need this anymore
	}

	@Override
	public void draw(SpriteBatch batch, float parentAlpha) {
		batch.setColor(getColor().r, getColor().g, getColor().b, getColor().a);
		batch.draw( Assets.unit,
				getX(), getY(), 
				/*getWidth() / 2, getHeight() / 2*/ 0, 0 , /* these are offsets, might need to change */
				getWidth(), getHeight(), 1, 1, getRotation());
	}

	// Might not need this anymore
	private void updateBounds() {
		bounds.set(getX(), getY(), getWidth(), getHeight());
	}

//	public void tryMoveUp() {
//		if ((getActions().size == 0) && (lane != 2))
//			moveToLane(lane + 1);
//	}
//
//	public void tryMoveDown() {
//		if ((getActions().size == 0) && (lane != 0))
//			moveToLane(lane - 1);
//	}
//
//	private void moveToLane(int lane) {
//		this.lane = lane;
//
//		switch (lane) {
//		case 0:
//			addAction(moveTo(getX(), archerGame.lane0 - getHeight() / 2, 0.5f));
//			break;
//		case 1:
//			addAction(moveTo(getX(), archerGame.lane1 - getHeight() / 2, 0.5f));
//			break;
//		case 2:
//			addAction(moveTo(getX(), archerGame.lane2 - getHeight() / 2, 0.5f));
//			break;
//		}
//	}

	public Rectangle getBounds() {
		return bounds;
	}
}
