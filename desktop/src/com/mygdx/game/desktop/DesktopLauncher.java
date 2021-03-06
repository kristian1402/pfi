package com.mygdx.game.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.mygdx.game.MyGdxGame;

public class DesktopLauncher {
	public static void main (String[] args) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		config.title = "PFI Projekt";
		config.width = 1024;  // 16:9 Aspect Ratio
		config.height = 576; // asdawdasdwaw
		new LwjglApplication(new MyGdxGame(), config);

	}
}
