package edu.training.scala.rational

import scala.language.implicitConversions

object Client extends App {
  implicit def intToRational(x: Int): Rational = new Rational(x)
  val x = new Rational(1,2)
  val y = new Rational(2,3)
  val z = 2*x
  println(z)
  println(x + x * y)
}
