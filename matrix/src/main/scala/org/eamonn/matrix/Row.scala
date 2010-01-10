/*
 * Copyright (c) 2010 Eamonn O'Brien-Strain, eob@well.com
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which is available at http://www.eclipse.org/legal/epl-v10.html
 */

package org.eamonn.matrix

import Row._

/** Methods that are added to List[Double] by an implicit conversion */
class RichRow(v:Row){

  /** dot product */
  def *(v2:Row)   = dotProd( v, v2 )

  /** vector addition */
  def add(v2:Row) = vPlusV( v, v2 )

  /** convert to column vector */
  def T = v.map{ List(_) }

  /** As row matrix */
  def asMatrix = List( v )

}


object Row{
  import util.Contract._

  /** A convenient alias */
  type Row = List[Double]


  def dotProd(v1:Row,v2:Row) = {
    requireEquals( v1.length, v2.length )
    v1.zip( v2 ).map{ t:(Double,Double) => t._1 * t._2 }.reduceLeft(_ + _)
  }

  def vPlusV(v1:Row,v2:Row) = {
    requireEquals( v1.length, v2.length )
    v1.zip( v2 ).map{ t:(Double,Double) => t._1 + t._2 }
  }

  /** effectively add RichRow methods to List[Double] */
  implicit def pimpRow(v:Row) = new RichRow(v)


}
