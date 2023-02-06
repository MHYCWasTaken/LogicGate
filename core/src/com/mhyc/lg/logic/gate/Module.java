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
		for (Switch sw : head.switchs) {
			this.inNodes.add(sw.in);
		}
		
	}

	@Override
	public void updateOuts() {
		this.head.run();
	}
	
}
