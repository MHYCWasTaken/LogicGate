package com.mhyc.lg;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.utils.ScreenUtils;
import com.mhyc.lg.screen.TitleScreen;

/**
 * Logic Gate
 * @author MHYC133
 * @date 2023/01/30 18:09
 */
public class LogicGate extends Game {

	Res res;

	TitleScreen titleScreen;
	
	@Override
	public void create () {

		// Res section
		res = new Res();
		res.init();

		Gdx.app.log(res.TAG, "LogicGate!");

		titleScreen = new TitleScreen(res);
		this.setScreen(titleScreen);
	}

	@Override
	public void render () {
		ScreenUtils.clear(1, 0, 0, 1);
		super.render();
	}
	
	@Override
	public void dispose () {
		if(res != null) {
			res.dispose();
		}
		if(titleScreen != null) {
			titleScreen.dispose();
		}
	}
}
