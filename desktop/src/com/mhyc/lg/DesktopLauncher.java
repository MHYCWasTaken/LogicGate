package com.mhyc.lg;

import com.badlogic.gdx.backends.lwjgl3.Lwjgl3Application;
import com.badlogic.gdx.backends.lwjgl3.Lwjgl3ApplicationConfiguration;

/**
 * Core main class
 * @author MHYC133
 * @date 2023/01/30 17:58
 */
public class DesktopLauncher {
	public static void main (String[] arg) {

		LogicGate logicGate = new LogicGate();

		Lwjgl3ApplicationConfiguration config = new Lwjgl3ApplicationConfiguration();
		config.setForegroundFPS(60);
		config.setTitle("LogicGate");
		config.setWindowedMode(1080, 690);
		config.setResizable(false);

		new Lwjgl3Application(logicGate, config);
	}
}

/*
 * macOS your application needs to be started with the -XstartOnFirstThread JVM argument
 */