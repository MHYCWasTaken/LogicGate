package com.mhyc.lg.logic;

import com.mhyc.lg.logic.node.NodeIn;
import com.mhyc.lg.logic.node.NodeOut;

/**
 * Wire
 * @author MHYC133
 * @date 2023/02/01 23:19
 */
public class Wire {

    public NodeOut in;
    public NodeIn out;

    public boolean active;

    public Wire(NodeOut in, NodeIn out) {
        this.in = in;
        this.out = out;
    }
    
}
