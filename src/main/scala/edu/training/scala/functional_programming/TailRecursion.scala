package edu.training.scala.functional_programming

import scala.annotation.tailrec

object TailRecursion extends App {

  @tailrec
  def fromDigits(digits: Seq[Int], res: Int):Int = {
    if (digits.isEmpty) res
    else fromDigits(digits.drop(1),10 * res + digits.head)
  }

  def fromDigits(digits: Seq[Int]):Int = {
    digits.foldLeft(0){case (prev,x) => 10 * prev + x}
  }

  def fromDigits1(digits: Seq[Int]):Int = {
    digits.reduceLeft((prev,x) => 10 * prev + x)
  }


  def reverceInteger(n: Int):Int = {
    Iterator.iterate((n,0)){case (x,y) => (x/10, x%10)}
      .takeWhile(_ != (0,0))
      .drop(1)
      .map(_._2)
      .foldLeft(0){case (prev,x) => 10 * prev + x}
  }


  println(fromDigits(1 to 6,0))
  println(fromDigits(1 to 6))
  println(fromDigits1(1 to 6))
  println(reverceInteger(123456))
}
