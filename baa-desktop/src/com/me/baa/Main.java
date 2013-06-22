package com.me.baa;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;

public class Main {
	public static void main(String[] args) {
		LwjglApplicationConfiguration cfg = new LwjglApplicationConfiguration();
		cfg.title = "baa";
		cfg.useGL20 = false;
		cfg.width = 480;
		cfg.height = 320;
		//My first change - Ant
		new LwjglApplication(new baaGame(), cfg);
	}
}
