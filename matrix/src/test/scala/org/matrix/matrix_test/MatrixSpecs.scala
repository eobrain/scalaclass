/*
 * Copyright (c) 2010 Eamonn O'Brien-Strain, eob@well.com
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which is available at http://www.eclipse.org/legal/epl-v10.html
 */

package org.eamonn.matrix_test

import util.Contract._
import matrix.Matrix._
import matrix.Row._
import org.specs._

object  MatrixSpecs extends Specification {
  checkPreconditions = true

  val M = List(
    List( 1.0, 2.0, 3.0 ),
    List( 4.0, 5.0, 6.0 )
  )
  val MT = List(
    List( 1.0, 4.0 ),
    List( 2.0, 5.0 ),
    List( 3.0, 6.0 )
  )

  val v = List( 7.0, 8.0, 9.0 )

  "a matrix supports transpose" in {
    (M T)  must_==  MT
  }

  "you can multiply a matrix by a vector" in {
    v.asMatrix * MT  must_==  7+16+27 + 28+40+54 
  }

  "you can multiply a vector by a matrix" in {
    MT * (v T)  must_==  v.asMatrix * M
  }

  "you can multiply matrices together" in {
    M * MT  must_== 1+4+9 + 4+10+18 + 4+10+18 + 16+25+36
  }

}
