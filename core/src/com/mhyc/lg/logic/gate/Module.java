package com.mhyc.lg.logic.gate;

import java.util.ArrayList;

import com.mhyc.lg.logic.node.NodeOut;
import com.mhyc.lg.logic.node.SuperEnd;
import com.mhyc.lg.logic.node.SuperSource;

/**
 * Sub system instance
 * @author MHYC133
 * @date 2023/02/04 09:30
 */
public class Module extends Gate {

	public ModuleTemplate template;

	public SuperSource head;
	public SuperEnd end;

	public Module(ModuleTemplate template) {
		this.template = template;
		this.head = template.head;
		this.end = template.end;
		for (Switch sw : head.switchs) {
			this.inNodes.add(sw.in);
		}
		for (Light lt : end.lights) {
			this.outNodes.add(lt.out);
		}
	}

	@Override
	public boolean updateOuts() {
		ArrayList<Boolean> nos = new ArrayList<Boolean>();
		for (NodeOut no : this.outNodes) {
			nos.add(no.active);
		}
		this.head.run();
		boolean flag = true;
		for (int i = 0; i < nos.size(); i++) {
			if(nos.get(i) != this.outNodes.get(i).active) {
				flag = false;
				break;
			}
		}
		return flag;
	}
	
}
