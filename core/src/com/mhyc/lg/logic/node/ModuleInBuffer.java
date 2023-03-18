package com.mhyc.lg.logic.node;

import com.mhyc.lg.logic.gate.Gate;

/**
 * 
 * @author MHYC133
 * @date 2023/03/18 17:28
 */
public class ModuleInBuffer extends NodeIn {

    public int index;

    public ModuleInBuffer(Gate belong) {
        super(belong);
    }

    @Override
    public int getIndex() {
        return index;
    }
    
}
