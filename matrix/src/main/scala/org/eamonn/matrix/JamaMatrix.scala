package org.eamonn.matrix

import Matrix._

class JamaMatrix(m:Matrix, jm:Jama.Matrix) {

  private var cachedJm = jm
  private var cachedM  = m

  private def asJm = {
    if(cachedJm==null){
      cachedJm = new Jama.Matrix( m.map{_.toArray}.toArray )
    }
    cachedJm
  }

  def asMatrix = {
    if(cachedM==null){
      cachedM = jm.getArray.map{_.toList}.toList
    }
    cachedM
  }

  def det = asJm.det

  def inverse = new JamaMatrix( null, asJm.inverse )

  override def toString = {
    "\n[ " + asMatrix.map{ "["+ _.mkString("\t")+"]" }.mkString("\n  ")+" ]\n"
  }

  //override def equals(obj:Any) = throw new Error 
  /* obj match {
    case that:Matrix => {
      println("case Matrix: "+this+"=="+that)
      asMatrix == that
    }
    case _ => {
      println(this+"=="+obj)
      super.equals(obj)
    }
  }*/

}

