package com.mhyc.lg.logic.node;

import com.mhyc.lg.logic.gate.Gate;

/**
 * 
 * @author MHYC133
 * @date 2023/03/18 17:28
 */
public class ModuleOutBuffer extends NodeOut {

    public int index;

    public ModuleOutBuffer(Gate belong) {
        super(belong);
    }

    @Override
    public int getIndex() {
        return index;
    }
    
}
