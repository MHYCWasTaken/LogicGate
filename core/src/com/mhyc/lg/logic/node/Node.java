package com.mhyc.lg.logic.node;

import com.mhyc.lg.logic.Wire;
import com.mhyc.lg.logic.gate.Gate;

/**
 * Node
 * @author MHYC133
 * @date 2023/01/30 20:27
 */
public class Node {

    public boolean active;

    public Gate belong;

    public Wire wire;

    public Node(Gate belong) {
        this.belong = belong;
    }

    public void disconnect() {
        if(this.wire == null) {
            return;
        }
        Wire w = this.wire;
        w.out.wire = null;
        w.in.wire = null;
        w.out = null;
        w.in = null;
    }

    public int getIndex() {
        return 0;
    }

    public static void connect(NodeOut from, NodeIn to) {
        from.disconnect();
        Wire w = new Wire(from, to);
        from.wire = w;
        to.wire = w;
    }

    public Node duplicate(Gate g) {
        return new Node(g);
    }
    
}
