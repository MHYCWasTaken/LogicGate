package com.mhyc.lg;

import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.g2d.BitmapFont;

/**
 * Res
 * @author MHYC133
 * @date 2023/01/30 17:57
 */
public class Res {

    public final String TAG = "LogicGate";

    public AssetManager manager;

    public final int SCREEN_WIDTH = 1080;
    public final int SCREEN_HEIGHT = 690;

    public void init() {

        // Manager load assets
        manager = new AssetManager();
        manager.load("fonts/CrimsonText-SemiBold-64.fnt", BitmapFont.class);
        manager.load("fonts/CrimsonText-SemiBold-32.fnt", BitmapFont.class);
        manager.load("fonts/CrimsonText-SemiBold-18.fnt", BitmapFont.class);
        manager.load("fonts/CrimsonText-SemiBold-12.fnt", BitmapFont.class);
        manager.load("fonts/CrimsonText-Italic-64.fnt", BitmapFont.class);
        manager.load("fonts/CrimsonText-Italic-32.fnt", BitmapFont.class);
        manager.load("fonts/CrimsonText-Italic-18.fnt", BitmapFont.class);
        manager.load("fonts/CrimsonText-Italic-12.fnt", BitmapFont.class);
        manager.load("fonts/PublicSans-ExtraBold-64.fnt", BitmapFont.class);
        manager.load("fonts/PublicSans-ExtraBold-32.fnt", BitmapFont.class);
        manager.load("fonts/PublicSans-ExtraBold-18.fnt", BitmapFont.class);
        manager.load("fonts/PublicSans-ExtraBold-12.fnt", BitmapFont.class);
        manager.finishLoading();

        // Init other vars

    }

    public void dispose() {
        if(this.manager != null) {
            manager.dispose();
        }
    }
    
}
