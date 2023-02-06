package com.mhyc.lg.logic.node;

import java.util.ArrayList;

import com.badlogic.gdx.utils.Queue;
import com.mhyc.lg.logic.gate.Gate;
import com.mhyc.lg.logic.gate.Switch;

/**
 * Super source for bfs
 * @author MHYC133
 * @date 2023/02/01 23:17
 */
public class SuperSource {

	public ArrayList<Switch> switchs = new ArrayList<Switch>();

	public void addSwitch(Switch sw) {
		switchs.add(sw);
		sw.in.active = false;
	}

	public void run() {
		Queue<NodeIn> open = new Queue<NodeIn>();
		for (Switch sw : switchs) {
			open.addLast(sw.in);
		}
		while(open.notEmpty()) {
			Gate g = open.first().belong;
			open.removeFirst();
			g.updateOuts();
			for (NodeOut no : g.outNodes) {
				if(no.wire == null) {
					continue;
				}
				no.wire.active = no.active;
				no.wire.out.active = no.active;
				open.addLast(no.wire.out);
			}
		}
	}

	public SuperSource duplicate() {
		SuperSource ss = new SuperSource();
		for (Switch sw : switchs) {
			ss.addSwitch(sw.duplicate());
		}
		
	}
	
}
