package edu.training.scala.fp

object Currying extends App {
  def curryedSum(x: Int)(y: Int) = x + y
  val onePlus = curryedSum(1)_
  println(onePlus)
  println(curryedSum(1)(2))
}
