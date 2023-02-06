package com.mhyc.lg.logic.node;

import java.util.ArrayList;

import com.mhyc.lg.logic.gate.Light;

/**
 * Super end
 * @author MHYC133
 * @date 2023/02/05 18:10
 */
public class SuperEnd {

    public ArrayList<Light> lights = new ArrayList<Light>();

    public void addLight(Light l) {
        lights.add(l);
    }
    
}
