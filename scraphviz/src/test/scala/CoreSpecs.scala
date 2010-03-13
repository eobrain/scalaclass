/* Copyright (c) 2010 Eamonn O'Brien-Strain, eob@well.com
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which is available at http://www.eclipse.org/legal/epl-v10.html
 */
package org.eamonn.test_scraphviz

import scraphviz.core.DiGraph
import org.specs._
import java.io.File

object CoreSpecs extends Specification {

  "can handle dot manual Figure 1" in {

		val out = new File("Small_graph.png")
		if(out.exists){
			out.delete()
		}

		new DiGraph{
			label = "Small graph"
			"main" -> "parse" -> "execute";
			"main" -> "init";
			"main" -> "cleanup";
			"execute" -> "make_string";
			"execute" -> "printf"
			"init" -> "make_string";
			"main" -> "printf";
			"execute" -> "compare";
		}.png()

		out must exist
	}


}
