package com.mhyc.lg.logic;

import com.mhyc.lg.logic.gate.AndGate;
import com.mhyc.lg.logic.gate.Light;
import com.mhyc.lg.logic.gate.NotGate;
import com.mhyc.lg.logic.gate.OrGate;
import com.mhyc.lg.logic.gate.Router;
import com.mhyc.lg.logic.gate.Switch;
import com.mhyc.lg.logic.node.Node;
import com.mhyc.lg.logic.node.SuperEnd;
import com.mhyc.lg.logic.node.SuperSource;

/**
 * Test for modle part
 * @author MHYC133
 * @date 2023/02/01 23:17
 */
public class Test {
    public static void main(String[] args) {
        
        SuperSource xorGateSuperSource = new SuperSource();
        SuperEnd xorGateSuperEnd = new SuperEnd();

        OrGate or = new OrGate();
        AndGate and1 = new AndGate();
        AndGate and2 = new AndGate();
        NotGate not = new NotGate();
        Router r1 = new Router();
        Router r2 = new Router();

        Switch in1 = new Switch(xorGateSuperSource);
        Switch in2 = new Switch(xorGateSuperSource);
        Light l = new Light(xorGateSuperEnd);

        Node.connect(in1.out, r1.inNodes.get(0));
        Node.connect(in2.out, r2.inNodes.get(0));

        Node.connect(r1.outNodes.get(0), or.inNodes.get(0));
        Node.connect(r2.outNodes.get(0), or.inNodes.get(1));
        Node.connect(r1.outNodes.get(1), and1.inNodes.get(0));
        Node.connect(r2.outNodes.get(1), and1.inNodes.get(1));

        Node.connect(and1.outNodes.get(0), not.inNodes.get(0));

        Node.connect(not.outNodes.get(0), and2.inNodes.get(0));
        Node.connect(or.outNodes.get(0), and2.inNodes.get(1));

        Node.connect(and2.outNodes.get(0), l.inNodes.get(0));

        in1.setActive(false);
        in2.setActive(true);

        xorGateSuperSource.run();

        System.out.println(l.getActive());

    }
}
