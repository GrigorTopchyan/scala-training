package edu.training.scala.functional_programming

object Currying extends App {
  def curryedSum(x: Int)(y: Int) = x + y
  val onePlus = curryedSum(1)_
  println(onePlus)
  println(curryedSum(1)(2))
}
