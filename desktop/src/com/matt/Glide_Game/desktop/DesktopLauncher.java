package com.matt.Glide_Game.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.matt.Glide_Game.Constants;
import com.matt.Glide_Game.MyGdxGame;

public class DesktopLauncher {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		config.width = Constants.WIDTH;
		config.height = Constants.HEIGHT;
		config.title = Constants.TITLE;
		new LwjglApplication(new MyGdxGame(), config);
	}
}
