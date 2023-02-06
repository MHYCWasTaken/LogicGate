package com.mhyc.lg.stage;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Label.LabelStyle;
import com.badlogic.gdx.utils.viewport.StretchViewport;
import com.mhyc.lg.Res;

/**
 * The non-active parts of TitleScreen
 * @author MHYC133
 * @date 2023/01/30 19:10
 */
public class TitleStage extends Stage {

    Res res;
    
    BitmapFont crimsonTextSemiBold32; 
    Label.LabelStyle styleLabel;
    Label title;

    public TitleStage(Res res) {

        Gdx.app.log(res.TAG, "TitleStage!");

        this.setViewport(new StretchViewport(res.SCREEN_WIDTH, res.SCREEN_HEIGHT));
        this.res = res;

        crimsonTextSemiBold32 = res.manager.get("fonts/CrimsonText-SemiBold-32.fnt");
        styleLabel = new LabelStyle(crimsonTextSemiBold32, new Color(1, 1, 1, 1));
        title = new Label("Logic Gate", styleLabel);
        title.setPosition(100, 100);
        Gdx.app.log(res.TAG, "Stage Title added!");
        this.addActor(title);
    }

    @Override
    public void dispose() {
        if(crimsonTextSemiBold32 != null) {
            crimsonTextSemiBold32.dispose();
        }
    }
    
}
