package com.mhyc.lg.logic.node;

import java.util.ArrayList;
import java.util.HashMap;

import com.badlogic.gdx.utils.Queue;
import com.mhyc.lg.logic.Wire;
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

	/*public SuperSource duplicate3() {
		SuperSource ss = new SuperSource();
		Queue<NodeIn> open = new Queue<NodeIn>();
		HashMap<Gate, Gate> gduped = new HashMap<Gate, Gate>();
		HashMap<NodeIn, NodeIn> nduped = new HashMap<NodeIn, NodeIn>();
		for (Switch sw : this.switchs) {
			NodeIn ni = sw.in;
			open.addLast(ni);
			if(!gduped.containsKey(ni.belong)) {
				gduped.put(ni.belong, ni.belong.duplicate());
			}
		}
		while (open.notEmpty()) {
			NodeIn ni = open.first();
			open.removeFirst();
			Gate gdup = gduped.get(ni.belong);
			gdup.inNodes.set(ni.getIndex(), ni.duplicate(gdup));
			if (gdup instanceof Light) {
				ss.end.addLight((Light) gdup);
			}
			if (gdup instanceof Switch) {
				ss.addSwitch((Switch) gdup);
			}
			for (NodeOut no : gdup.outNodes) {
				if(no.wire == null) {
					continue;
				}
				NodeOut nodup = no.duplicate(gdup);
				gdup.outNodes.set(no.getIndex(), nodup);
				Gate gx = no.wire.out.belong;
				if(!gduped.containsKey(gx)) {
					gduped.put(gx, gx.duplicate());
				}
				NodeIn nix = no.wire.out;
				NodeIn nixdup = new NodeIn(gduped.get(gx));
				gx.inNodes.set(nix.belong.inNodes.indexOf(nix), nixdup);
				Wire w = new Wire(nodup, nixdup);
				nodup.wire = w;
				nixdup.wire = w;
				open.addLast(nix);
			}
		}
		return ss;
	}*/

	public SuperSource duplicate() {
		SuperSource ss = new SuperSource();
		Queue<Gate> open = new Queue<Gate>();
		HashMap<Gate, Gate> duped = new HashMap<Gate, Gate>();
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
