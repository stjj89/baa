package com.me.baa;

import java.util.Iterator;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.TimeUtils;

public class ArcherGame extends Table {
	private Actor backgroundStage;
//	private Array<EnemyArcher> enemyArchers;
//	private long lastCarTime = 0;
//	public final float lane2 = 390;
//	public final float lane1 = 240;
//	public final float lane0 = 90;
	private PlayerArcher playerArcher;

	public ArcherGame()
	{
		setBounds(0, 0, 800, 480);
		setClip(true);
		
		// Initialize the background
		backgroundStage = new Actor();
		backgroundStage.setWidth(getWidth());
		backgroundStage.setHeight(getHeight());
		backgroundStage.setPosition(getWidth(), 0);
		addActor(backgroundStage);
		
		// Initialize player and enemies
		playerArcher = new PlayerArcher(this);
		addActor(playerArcher);
//		enemyArchers = new Array<EnemyArcher>();
	}

	// TODO: possibly optimize
	public void movePlayer (float dx, float dy)
	{
		playerArcher.setPosition(playerArcher.getX() + dx, playerArcher.getY() + dy);
	}
	
	@Override
	public void act(float delta)
	{
		super.act(delta);

//		if (TimeUtils.nanoTime() - lastCarTime > 3000000000f)
//			spawnCar();

//		Iterator<EnemyArcher> iter = enemyArchers.iterator();
//		while (iter.hasNext()) {
//			EnemyArcher enemyCar = iter.next();
//			if (enemyCar.getBounds().x + enemyCar.getWidth() <= 0) {
//				iter.remove();
//				removeActor(enemyCar);
//			}
//			if (enemyCar.getBounds().overlaps(playerCar.getBounds())) {
//				iter.remove();
//				if (enemyCar.getX() > playerCar.getX()) {
//					if (enemyCar.getY() > playerCar.getY())
//						enemyCar.crash(true, true);
//					else
//						enemyCar.crash(true, false);
//				} else {
//					if (enemyCar.getY() > playerCar.getY())
//						enemyCar.crash(false, true);
//					else
//						enemyCar.crash(false, false);
//				}
//			}
//		}
	}

	private void spawnEnemy() {
//		int lane = MathUtils.random(0, 2);
//		float yPos = 0;
//		if (lane == 0)
//			yPos = lane0;
//		if (lane == 1)
//			yPos = lane1;
//		if (lane == 2)
//			yPos = lane2;
//		EnemyArcher enemyCar = new EnemyArcher(getWidth(), yPos);
//		enemyArchers.add(enemyCar);
//		addActor(enemyCar);
//		lastCarTime = TimeUtils.nanoTime();
	}

	@Override
	public void draw(SpriteBatch batch, float parentAlpha) {
		batch.setColor(Color.WHITE);
		super.draw(batch, parentAlpha);
	}
}