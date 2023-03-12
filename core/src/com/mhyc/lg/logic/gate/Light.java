package com.mhyc.lg.logic.gate;

import com.mhyc.lg.logic.node.NodeIn;
import com.mhyc.lg.logic.node.NodeOut;
import com.mhyc.lg.logic.node.SuperEnd;

/**
 * Light
 * @author MHYC133
 * @date 2023/02/01 23:18
 */
public class Light extends Gate {

    private NodeIn in;
    public NodeOut out;

    public Light(SuperEnd se) {
        in = new NodeIn(this);
        out = new NodeOut(this);
        this.inNodes.add(in);
        this.outNodes.add(out);
        if(se != null) {
            se.addLight(this);
        }
    }

    @Override
    public boolean updateOuts() {
        if(out.active == in.active) {
            return true;
        }
        out.active = in.active;
        return false;
    }

    public boolean getActive() {
        return in.active;
    }

    @Override
    public Light duplicate() {
        return new Light(null);
    }
    
}
