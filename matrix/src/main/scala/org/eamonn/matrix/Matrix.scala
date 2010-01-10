
/*
 * Copyright (c) 2010 Eamonn O'Brien-Strain, eob@well.com
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which is available at http://www.eclipse.org/legal/epl-v10.html
 */


package org.eamonn.matrix

import Matrix._
import Row._

/** Methods that are added to List[List[Double]] by an implicit conversion */
class RichMatrix(m:Matrix){

  def T = transpose(m)

  def *(m2:Matrix) = mXm(m,m2)

  def toStr = "\n"+m.map{ 
    _.map{"\t" + _}.reduceLeft(_ + _)+"\n"
  }.reduceLeft(_ + _)

}


object Matrix{
  import util.Contract._

  /** A convenient alias */
  type Matrix = List[Row]

  def transpose(m:Matrix):Matrix = 
    if(m.head.isEmpty) Nil else m.map(_.head) :: transpose(m.map(_.tail))

  def mXv(m:Matrix, v:Row) = {
    requireEquals( rowCount(m), v.length )
    m.map{ dotProd(_,v) } reduceLeft ( _ + _ )
  }

  def mXm(m1:Matrix,m2:Matrix) = {
    requireEquals( colCount(m1), rowCount(m2) )
    transpose(m2).map{ mXv(m1,_) } reduceLeft ( _ + _ )
  }

  def rowCount(m:Matrix) = m.length
  def colCount(m:Matrix) = m.head.length


  /** effectively add RichMatrix methods to List[List[Double]] */
  implicit def pimpMatrix(v:Matrix) = new RichMatrix(v)

}