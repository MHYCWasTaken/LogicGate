package com.mhyc.lg.logic.gate;

import java.util.ArrayList;

import com.mhyc.lg.logic.node.ModuleInBuffer;
import com.mhyc.lg.logic.node.ModuleOutBuffer;
import com.mhyc.lg.logic.node.NodeIn;
import com.mhyc.lg.logic.node.NodeOut;
import com.mhyc.lg.logic.node.SuperSource;

/**
 * Sub system instance
 * @author MHYC133
 * @date 2023/02/04 09:30
 */
public class Module extends Gate {

	public ModuleTemplate template;

	public SuperSource head;

	public Module(ModuleTemplate template) {
		this.template = template;
		this.head = template.head.duplicate();
		System.out.println("in module duplicate complete!");
		for (Switch sw : this.head.switchs) {
			ModuleInBuffer mib = new ModuleInBuffer(this);
			this.inNodes.add(mib);
			mib.index = head.switchs.indexOf(sw);
			System.out.println("added a sw");
		}
		for (Light l : this.head.end.lights) {
			ModuleOutBuffer mob = new ModuleOutBuffer(this);
			this.outNodes.add(mob);
			mob.index = head.end.lights.indexOf(l);
			System.out.println("added a l");
		}
	}

	@Override
	public boolean updateOuts() {
		ArrayList<Boolean> nos = new ArrayList<Boolean>();
		for (NodeOut no : this.outNodes) {
			nos.add(no.active);
		}
		for (NodeIn ni : this.inNodes) {
			this.head.switchs.get(ni.getIndex()).in.active = ni.active;
		}
		this.head.run();
		for (NodeOut no : this.outNodes) {
			no.active = this.head.end.lights.get(no.getIndex()).out.active;
		}
		System.out.println("updated!");
		boolean flag = true;
		for (int i = 0; i < nos.size(); i++) {
			if(nos.get(i) != this.outNodes.get(i).active) {
				flag = false;
				break;
			}
		}
		return flag;
	}
	
	@Override
    public Module duplicate() {
        return new Module(template);
    }
	
}
