package com.me.baa;

import java.util.ArrayList;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL10;
import com.badlogic.gdx.input.GestureDetector;
import com.badlogic.gdx.input.GestureDetector.GestureListener;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.scenes.scene2d.Stage;

public class GameScreen implements Screen, GestureListener, InputProcessor {
	private Stage stage;
	private ArcherGame archerGame;
	private boolean wPressed, aPressed, sPressed, dPressed;
	private boolean mousePressed;
	private float pressedX, pressedY;							// Coordinates of mouse press
	private float bowCharge;									// % of bow charged [0-100]
	//public static ArrayList<Arrow> arrows;						// All arrows in the game

	public GameScreen() {
		stage = new Stage();
		archerGame = new ArcherGame();
		stage.addActor(archerGame);
		wPressed = false;
		aPressed = false;
		sPressed = false;
		dPressed = false;
		mousePressed = false;
		pressedX = 0.0f;
		pressedY = 0.0f;
	}

	public void resize(int width, int height) {
		stage.setViewport(baaGame.WIDTH, baaGame.HEIGHT, true);
		stage.getCamera().translate(-stage.getGutterWidth(),
				-stage.getGutterHeight(), 0);
	}

	@Override
	public void render(float delta) {
		Gdx.gl.glClearColor(0, 0, 0, 1);
		Gdx.gl.glClear(GL10.GL_COLOR_BUFFER_BIT);
		stage.act(delta);
		stage.draw();
		if ( wPressed || aPressed || sPressed || dPressed )
			keyboardPressedHandler();
		if ( mousePressed )
			mousePressedHandler();
		
		
		// Draw
	}
	
	private void mousePressedHandler()
	{
		
	}
	
	private void keyboardPressedHandler()
	{
		float dx = 0;
		float dy = 0;
		float moveDelta = 4.0f;
		
		if (wPressed)
			dy = moveDelta;
		if (aPressed)
			dx = -moveDelta;
		if (sPressed)
			dy = -moveDelta;
		if (dPressed)
			dx = moveDelta;
		
		if ( (0 != dx) || (0 != dy) )
		{
			dx *= 0.7071; // 1/sqrt(2)
			dy *= 0.7071; // 1/sqrt(2)
		}
		
		archerGame.movePlayer(dx, dy);
	}

	@Override
	public void show() {
		Gdx.input.setInputProcessor(new GestureDetector(this));
	}

	@Override
	public void hide() {
		Gdx.input.setInputProcessor(null);
	}

	@Override
	public void resume() {
	}

	@Override
	public void pause() {
	}

	@Override
	public void dispose() {
	}

	/*
	 * ================
	 * TOUCH GESTURES
	 * ================
	 */
	
	// For implementing flings/swipes
	@Override
	public boolean fling(float velocityX, float velocityY, int button) {
		//		if (velocityY < -100)
		//			archerGame.playerArcher.tryMoveUp();
		//		if (velocityY > 100)
		//			archerGame.playerArcher.tryMoveDown();
		return false;
	}
	
	@Override
	public boolean tap(float x, float y, int count, int button) {
		return false;
	}

	@Override
	public boolean touchDown(float x, float y, int pointer, int button) {
		return false;
	}

	@Override
	public boolean longPress(float x, float y) {
		return false;
	}

	@Override
	public boolean pan(float x, float y, float deltaX, float deltaY) {
		return false;
	}

	@Override
	public boolean zoom(float initialDistance, float distance) {
		return false;
	}

	@Override
	public boolean pinch(Vector2 initialPointer1, Vector2 initialPointer2,
			Vector2 pointer1, Vector2 pointer2) {
		return false;
	}

	/*
	 * ================
	 * KEYBOARD INPUTS
	 * ================
	 */

	@Override
	public boolean keyDown (int keycode) {
		
		switch (keycode)
		{
		case Input.Keys.W:
			wPressed = true;
			break;
		case Input.Keys.A:
			aPressed = true;
			break;
		case Input.Keys.S:
			sPressed = true;
			break;
		case Input.Keys.D:
			dPressed = true;
			break;
		}
		
		return false;
	}

	@Override
	public boolean keyUp (int keycode) {
		
		switch (keycode)
		{
		case Input.Keys.W:
			wPressed = false;
			break;
		case Input.Keys.A:
			aPressed = false;
			break;
		case Input.Keys.S:
			sPressed = false;
			break;
		case Input.Keys.D:
			dPressed = false;
			break;
		}
		
		return false;
	}

	@Override
	public boolean keyTyped (char character)
	{
		return false;
	}

	@Override
	// Note: x and y wrt origin on the top left
	public boolean touchDown (int x, int y, int pointer, int button)
	{
		mousePressed = true;
		pressedX = x;
		pressedY = -y; // To be consistent with movement y axis
		
		//System.out.println("pressedX=" + pressedX + " pressedY=" + pressedY);
		
		return false;
	}

	@Override
	public boolean touchUp (int x, int y, int pointer, int button)
	{
		
		mousePressed = false;
		pressedX = 0.0f;
		pressedY = 0.0f;
		
		return false;
	}

	@Override
	public boolean touchDragged (int x, int y, int pointer) {
		return false;
	}

	@Override
	public boolean mouseMoved (int x, int y) {
		archerGame.rotate(x, y);
		
		return false;
	}

	@Override
	public boolean scrolled (int amount) {
		return false;
	}

}