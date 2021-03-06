/* Copyright (c) 2010 Eamonn O'Brien-Strain, eob@well.com
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which is available at http://www.eclipse.org/legal/epl-v10.html
 */

package org.eamonn.scraphviz.core

class DiNode( graph:DiGraph, name:String ) 
  extends AbstractNode(graph,name)
{

	def ->(that:DiNode) = new DiEdge(graph,this,that)

}
