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
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.scenes.scene2d.Stage;

public class GameScreen implements Screen, GestureListener, InputProcessor {
	private Stage stage;
	private ArcherGame archerGame;
	private boolean wPressed, aPressed, sPressed, dPressed;
	private boolean mousePressed;
	private float pressedX, pressedY;							// Coordinates of mouse press
	private float bowCharge;									// % of bow charged [0-100]
	//public static ArrayList<Arrow> arrows;					// All arrows in the game

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
		
		// Draw
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
	public boolean keyDown (int keycode)
	{	
		switch (keycode)
		{
		case Input.Keys.W:
			archerGame.wPressed = true;
			//wPressed = true;
			break;
		case Input.Keys.A:
			archerGame.aPressed = true;
			//aPressed = true;
			break;
		case Input.Keys.S:
			archerGame.sPressed = true;
			//sPressed = true;
			break;
		case Input.Keys.D:
			archerGame.dPressed = true;
			//dPressed = true;
			break;
		}
		
		return true;
	}

	@Override
	public boolean keyUp (int keycode)
	{
		
		switch (keycode)
		{
		case Input.Keys.W:
			archerGame.wPressed = false;
			//wPressed = false;
			break;
		case Input.Keys.A:
			archerGame.aPressed = false;
			//aPressed = false;
			break;
		case Input.Keys.S:
			archerGame.sPressed = false;
			//sPressed = false;
			break;
		case Input.Keys.D:
			archerGame.dPressed = false;
			//dPressed = false;
			break;
		}
		
		return true;
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
		archerGame.pressed = true;
		
		// Transform screen coordinates to world coordinates
		Vector3 pos = new Vector3(x, y, 0);
		stage.getCamera().unproject(pos);
		//System.out.println("transforemd: x = " + pos.x + ", y = " + (baaGame.HEIGHT - pos.y));
		pos.y = baaGame.HEIGHT - pos.y;
		
		// Do not give coordinates in black bar areas
		if (pos.x < 0)
			archerGame.pressedX = 0;
		else if (pos.x > baaGame.WIDTH)
			archerGame.pressedX = baaGame.WIDTH;
		else
			archerGame.pressedX = pos.x;
		
		if (pos.y < 0)
			archerGame.pressedY = 0;
		else if (pos.y > baaGame.HEIGHT)
			archerGame.pressedY = baaGame.HEIGHT;
		else
			archerGame.pressedY = pos.y;
	
		
		return true;
	}

	@Override
	public boolean touchUp (int x, int y, int pointer, int button)
	{
		archerGame.pressed = false;
		archerGame.pressedX = 0.0f;
		archerGame.pressedY = 0.0f;
		
//		mousePressed = false;
//		pressedX = 0.0f;
//		pressedY = 0.0f;
		
		return true;
	}

	@Override
	public boolean touchDragged (int x, int y, int pointer) {
		return false;
	}

	@Override
	public boolean mouseMoved (int x, int y) {	
		// Transform screen coordinates to world coordinates
		Vector3 pos = new Vector3(x, y, 0);
		stage.getCamera().unproject(pos);
		//System.out.println("transforemd: x = " + pos.x + ", y = " + (baaGame.HEIGHT - pos.y));
		pos.y = baaGame.HEIGHT - pos.y;
		
		// Do not give coordinates in black bar areas
		if (pos.x < 0)
			archerGame.currentX = 0;
		else if (pos.x > baaGame.WIDTH)
			archerGame.currentX = baaGame.WIDTH;
		else
			archerGame.currentX = pos.x;
		
		if (pos.y < 0)
			archerGame.currentY = 0;
		else if (pos.y > baaGame.HEIGHT)
			archerGame.currentY = baaGame.HEIGHT;
		else
			archerGame.currentY = pos.y;
		
		return true;
	}

	@Override
	public boolean scrolled (int amount) {
		return false;
	}

}