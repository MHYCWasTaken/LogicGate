package com.mhyc.lg.logic.gate;

import com.mhyc.lg.logic.node.NodeIn;
import com.mhyc.lg.logic.node.NodeOut;
import com.mhyc.lg.logic.node.SuperSource;

/**
 * Switch
 * @author MHYC133
 * @date 2023/02/01 23:19
 */
public class Switch extends Gate {

    public NodeIn in;
    public NodeOut out;

    public Switch(SuperSource ss) {
        out = new NodeOut(this);
        in = new NodeIn(this);
        outNodes.add(out);
        inNodes.add(in);
        if(ss != null) {
            ss.addSwitch(this);
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

    public void changeActive() {
        in.active = !in.active;
    }

    public void setActive(boolean active) {
        in.active = active;
        updateOuts();
    }

    @Override
    public Switch duplicate() {
        return new Switch(null);
    }

}
