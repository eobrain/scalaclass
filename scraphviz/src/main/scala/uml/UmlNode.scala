/* Copyright (c) 2010 Eamonn O'Brien-Strain, eob@well.com
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which is available at http://www.eclipse.org/legal/epl-v10.html
 */
package org.eamonn.scraphviz.uml

import core.DiNode

class UmlNode(graph:Uml,label:String) extends DiNode(graph,label){

	shape('record)

	def <>-(that:UmlNode) = {
		this -> that arrowtail 'diamond arrowhead 'none
		that
	}
	def -<>(that:UmlNode) = {that <>- this; that}

	def <|-(that:UmlNode) = {
		(that -> this) arrowhead 'onormal arrowtail 'none arrowsize 2
		that
	}

	def -|>(that:UmlNode) = { that <|- this ; that }


	def -->(that:UmlNode) = {
		(this -> that) arrowhead 'vee style 'dashed
		that
	} 

	def <--(that:UmlNode) = { that --> this; that }

}
