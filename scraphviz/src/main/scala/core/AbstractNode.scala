/* Copyright (c) 2010 Eamonn O'Brien-Strain, eob@well.com
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which is available at http://www.eclipse.org/legal/epl-v10.html
 */

package org.eamonn.scraphviz.core

abstract class AbstractNode( graph:AbstractGraph, name:String ) extends HasAtts{

  graph add this

  def shape(sh:Symbol) = { att('shape,sh); this }

  def label(lab:String) = { att('label,lab); this }

  override def toString = "\""+name+"\""
  def declaration = this+" "+atts
}
