package com.me.baa;

import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.GL10;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.Texture.TextureFilter;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.Game;

public class baaGame extends Game {
	// New stuff
	public final static int WIDTH = 1280;
	public final static int HEIGHT = 768;
	private GameScreen gameScreen;

	// Old stuff
//	private OrthographicCamera camera;
//	private SpriteBatch batch;
//	private Texture texture;
//	private Sprite sprite;
//	
//	Texture basicUnit;
//	Rectangle unit;
	
	@Override
	public void create() {		
		Assets.load();
		gameScreen = new GameScreen();
		setScreen(gameScreen);
		Gdx.input.setInputProcessor(gameScreen);
		
		// Old stuff
//		float w = Gdx.graphics.getWidth();
//		float h = Gdx.graphics.getHeight();
//		
//		camera = new OrthographicCamera(1, h/w);
//		batch = new SpriteBatch();
//		
//		texture = new Texture(Gdx.files.internal("data/libgdx.png"));
//		texture.setFilter(TextureFilter.Linear, TextureFilter.Linear);
//		
//		TextureRegion region = new TextureRegion(texture, 0, 0, 512, 275);
//		
//		sprite = new Sprite(region);
//		sprite.setSize(0.9f, 0.9f * sprite.getHeight() / sprite.getWidth());
//		sprite.setOrigin(sprite.getWidth()/2, sprite.getHeight()/2);
//		sprite.setPosition(-sprite.getWidth()/2, -sprite.getHeight()/2);
//		
//		// Load basic placeholder image
//		basicUnit = new Texture(Gdx.files.internal("data/unit.png"));
//		unit = new Rectangle();
//		unit.x = w/2;
//		unit.y = h/2;
//		unit.width = 32;
//		unit.height = 32;
	}

	@Override
	public void dispose() {
		// New stuff
		Assets.dispose();
		gameScreen.dispose();
		
		// Old stuff
//		batch.dispose();
//		texture.dispose();
	}

//	@Override
//	public void render() {		
//		Gdx.gl.glClearColor(1, 0, 1, 1);
//		Gdx.gl.glClear(GL10.GL_COLOR_BUFFER_BIT);
//		
//		batch.setProjectionMatrix(camera.combined);
//		batch.begin();
//		sprite.draw(batch);
//		batch.draw(basicUnit, unit.x, unit.y);
//		batch.end();
//	}
//
//	@Override
//	public void resize(int width, int height) {
//	}
//
//	@Override
//	public void pause() {
//	}
//
//	@Override
//	public void resume() {
//	}
}
