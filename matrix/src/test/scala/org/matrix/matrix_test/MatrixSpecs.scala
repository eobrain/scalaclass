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

  val M_X_MT = List(
    List( 1+4+9.0,   4+10+18.0  ),
    List( 4+10+18.0, 16+25+36.0 )
  )

  val v = List( 7.0, 8.0, 9.0 )

  val v_X_MT = List(List( 7+16+27.0, 28+40+54.0 ))

  "a matrix supports transpose" in {
    (M T)  must_==  MT
  }

  "you can multiply a matrix by a vector" in {
    v.asMatrix * MT  must_==  v_X_MT
  }

  "you can multiply a vector by a matrix" in {
      MT * (v T)      must_==  ((v.asMatrix * M) T)
    ((MT * (v T)) T)  must_==   (v.asMatrix * M)
  }

  "you can multiply matrices together" in {
    M * MT  must_== M_X_MT
  }

  "Example from Paulson Book" in {
    val A = List(List( 2.0, 0.0 ),
		 List( 3.0,-1.0 ),
		 List( 0.0, 1.0 ),
		 List( 1.0, 1.0 ))
    val B = List(List( 1.0,  0.0, 2.0 ),
		 List( 4.0, -1.0, 0.0 ))
    val C = List(List(  2.0,  0.0, 4.0 ),
		 List( -1.0,  1.0, 6.0 ),
		 List(  4.0, -1.0, 0.0 ),
		 List(  5.0, -1.0, 2.0 ))
    A * B  must_==  C
  }

}
