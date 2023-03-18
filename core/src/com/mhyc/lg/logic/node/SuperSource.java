package com.mhyc.lg.logic.node;

import java.util.ArrayList;
import java.util.HashMap;

import com.badlogic.gdx.utils.Queue;
import com.mhyc.lg.logic.gate.Gate;
import com.mhyc.lg.logic.gate.Light;
import com.mhyc.lg.logic.gate.Switch;

/**
 * Super source for bfs
 * @author MHYC133
 * @date 2023/02/01 23:17
 */
public class SuperSource {

	public ArrayList<Switch> switchs = new ArrayList<Switch>();

	public SuperEnd end;

	public SuperSource() {
		this.end = new SuperEnd();
		end.head = this;
	}

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
			boolean flag = g.updateOuts();
			for (NodeOut no : g.outNodes) {
				if(no.wire == null) {
					continue;
				}
				no.wire.active = no.active;
				no.wire.out.active = no.active;
				if (!flag) {
					open.addLast(no.wire.out);
				}
			}
		}
	}

	public SuperSource duplicate() {
		SuperSource ss = new SuperSource();
		Queue<Gate> open = new Queue<Gate>();
		HashMap<Gate, Gate> duped = new HashMap<Gate, Gate>(16);
		for (Switch sw : this.switchs) {
			open.addLast(sw);
			ss.addSwitch(sw);
		}
		while (open.notEmpty()) {
			Gate g = open.first();
			System.out.println(open);
			open.removeFirst();
			if (g instanceof Light) {
				if (!ss.end.lights.contains(duped.get(g))) {
					ss.end.addLight((Light) duped.get(g));
				}
				System.out.println(" is light.");
				continue;
			}
			if (!duped.containsKey(g)) {
				duped.put(g, g.duplicate());
			}
			Gate gdup = duped.get(g);
			for (NodeOut no : g.outNodes) {
				if (no.wire == null) {
					continue;
				}
				NodeIn gxni = no.wire.out;
				Gate gx = gxni.belong;
				if (!duped.containsKey(gx)) {
					duped.put(gx, gx.duplicate());
				}
				Gate gxdup = duped.get(gx);
				Node.connect(gdup.outNodes.get(no.getIndex()), gxdup.inNodes.get(gxni.getIndex()));
				open.addLast(gx);
			}
		}
		return ss;
	}
	
}
