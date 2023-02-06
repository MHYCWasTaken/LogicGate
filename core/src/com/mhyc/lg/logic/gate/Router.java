package com.mhyc.lg.logic.gate;

import com.mhyc.lg.logic.node.NodeIn;
import com.mhyc.lg.logic.node.NodeOut;

/**
 * Duplicate the input
 * @author MHYC133
 * @date 2023/02/01 23:19
 */
public class Router extends Gate {

    private NodeIn in1;
    private NodeOut out1, out2;

    public Router() {
        in1 = new NodeIn(this);
        out1 = new NodeOut(this);
        out2 = new NodeOut(this);
        inNodes.add(in1);
        outNodes.add(out1);
        outNodes.add(out2);
    }

    @Override
    public void updateOuts() {
        out1.active = in1.active;
        out2.active = in1.active;
    }
    
}
