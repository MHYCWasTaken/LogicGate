package com.mhyc.lg.logic.gate;

import com.mhyc.lg.logic.node.SuperEnd;
import com.mhyc.lg.logic.node.SuperSource;

/**
 * Contains basic informations about this module
 * Also use to create new module by an existing module template
 * @author MHYC133
 * @date 2023/02/04 09:30
 */
public class ModuleTemplate {

	public String name;
	public String description;

	public SuperSource head;
	public SuperEnd end;
	
}
