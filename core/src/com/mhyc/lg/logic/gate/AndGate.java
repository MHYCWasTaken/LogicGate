package com.mhyc.lg.logic.gate;

import com.mhyc.lg.logic.node.NodeIn;
import com.mhyc.lg.logic.node.NodeOut;

/**
 * And gate
 * @author MHYC133
 * @date 2023/02/01 23:18
 */
public class AndGate extends Gate {

    private NodeIn in1, in2;
    private NodeOut out1;

    public AndGate() {
        in1 = new NodeIn(this);
        in2 = new NodeIn(this);
        out1 = new NodeOut(this);
        inNodes.add(in1);
        inNodes.add(in2);
        outNodes.add(out1);
    }
    
    @Override
    public boolean updateOuts() {
        if(out1.active == in1.active & in2.active) {
            return true;
        }
        out1.active = in1.active && in2.active;
        return false;
    }

}
