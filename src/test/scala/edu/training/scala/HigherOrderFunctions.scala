package edu.training.scala

import org.scalatest.{FlatSpec, Matchers}

class HigherOrderFunctions extends FlatSpec with Matchers {

  def compose[X,Y,Z](f: X => Y, g: Y => Z):X => Z = x => g(f(x))

  it should "run compose" in {
    val c = compose[Int,Boolean,String](x => x%2 == 0,x => x.toString)
    c(25) shouldEqual "false"
  }

  def twice[T](f : T => T): T => T = x => f(f(x))

  it should "run twice " in {
    val c = twice[Int](x => x + 3)
    c(3) shouldEqual 9
  }
}
