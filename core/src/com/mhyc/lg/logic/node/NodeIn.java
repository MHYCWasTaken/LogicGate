package com.mhyc.lg.logic.node;

import com.mhyc.lg.logic.gate.Gate;

/**
 * Node in
 * @author MHYC133
 * @date 2023/01/30 20:33
 */
public class NodeIn extends Node {

    public NodeIn(Gate belong) {
        super(belong);
    }

    @Override
    public NodeIn duplicate(Gate g) {
        return new NodeIn(g);
    }
    
    @Override
    public int getIndex() {
        return this.belong.inNodes.indexOf(this);
    }

}
