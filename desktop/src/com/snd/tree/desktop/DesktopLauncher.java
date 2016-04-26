package com.snd.tree.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.snd.tree.TreeDraw;

public class DesktopLauncher {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
    //config.width = 1920;
    //config.height = 1080;
		config.fullscreen = false;
		new LwjglApplication(new TreeDraw(), config);
	}
}
