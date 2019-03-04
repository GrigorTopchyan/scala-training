package edu.training.scala.functional_programming

object FPDemo extends App {
  def factorial(n: Int): Int = (1 to n).product
  def isPrime(n: Int): Boolean = (1 until n).forall(n % _ != 0)
  def countEven(s:Set[Int]): Int = s.filter(_ % 2 != 0).sum
}
