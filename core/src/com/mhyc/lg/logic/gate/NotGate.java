package com.mhyc.lg.logic.gate;

import com.mhyc.lg.logic.node.NodeIn;
import com.mhyc.lg.logic.node.NodeOut;

/**
 * And gate
 * @author MHYC133
 * @date 2023/02/01 23:18
 */
public class NotGate extends Gate {

    private NodeIn in1;
    private NodeOut out1;

    public NotGate() {
        in1 = new NodeIn(this);
        out1 = new NodeOut(this);
        inNodes.add(in1);
        outNodes.add(out1);
    }
    
    @Override
    public void updateOuts() {
        out1.active = !in1.active;
    }

}
