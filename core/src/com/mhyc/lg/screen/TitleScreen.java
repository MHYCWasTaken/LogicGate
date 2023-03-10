package com.mhyc.lg.screen;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.graphics.GL20;
import com.mhyc.lg.Res;
import com.mhyc.lg.stage.TitleStage;


/**
 * title screen
 * @author MHYC133
 * @date 2023/01/30 18:12
 */
public class TitleScreen extends ScreenAdapter {

    Res res;
    
    TitleStage titleStage;

    public TitleScreen(Res res) {
        this.res = res;
        titleStage = new TitleStage(res);
    }

    @Override
    public void show() {
        Gdx.app.log(res.TAG, "TitleScreen!");
    }

    @Override
    public void render(float delta) {

        Gdx.gl.glClearColor(0.75F, 1, 0.98F, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

		titleStage.act();

		titleStage.draw();
        
    }

    @Override
    public void dispose() {
        if(titleStage != null) {
            titleStage.dispose();
        }
    }

}
