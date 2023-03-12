package com.mhyc.lg.logic.gate;

import java.util.ArrayList;

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
			this.inNodes.add(sw.in);
			System.out.println("added a sw");
		}
		for (Light l : this.head.end.lights) {
			this.outNodes.add(l.out);
			System.out.println("added a l");
		}
	}

	/*  USELESS
	@Override
	public boolean updateOuts() {
		ArrayList<Boolean> nos = new ArrayList<Boolean>();
		for (NodeOut no : this.outNodes) {
			nos.add(no.active);
		}
		this.head.run();
		System.out.println("updated!");
		boolean flag = true;
		for (int i = 0; i < nos.size(); i++) {
			if(nos.get(i) != this.outNodes.get(i).active) {
				flag = false;
				break;
			}
		}
		return flag;
	}*/
	
	@Override
    public Module duplicate() {
        return new Module(template);
    }
	
}
