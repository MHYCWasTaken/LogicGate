package com.mhyc.lg.logic.node;

import com.mhyc.lg.logic.gate.Gate;

/**
 * Node out
 * @author MHYC133
 * @date 2023/01/30 20:33
 */
public class NodeOut extends Node {

    public NodeOut(Gate belong) {
        super(belong);
    }
    
    @Override
    public NodeOut duplicate(Gate g) {
        return new NodeOut(g);
    }

    @Override
    public int getIndex() {
        return this.belong.outNodes.indexOf(this);
    }

}
