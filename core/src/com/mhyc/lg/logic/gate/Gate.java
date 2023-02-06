package com.mhyc.lg.logic.gate;

import java.util.ArrayList;

import com.mhyc.lg.logic.node.NodeIn;
import com.mhyc.lg.logic.node.NodeOut;

/**
 * A simple gate
 * @author MHYC133
 * @date 2023/02/01 23:18
 */
public class Gate {

    public ArrayList<NodeIn> inNodes = new ArrayList<NodeIn>();
    public ArrayList<NodeOut> outNodes = new ArrayList<NodeOut>();
    
    public void updateOuts() {
        return;
    }

}
