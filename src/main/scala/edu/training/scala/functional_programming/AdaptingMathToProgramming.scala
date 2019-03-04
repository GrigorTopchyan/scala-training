package edu.training.scala.functional_programming

import scala.collection.immutable

object AdaptingMathToProgramming {
  val n = 100
  val f : Int => Int= ???
  val p : Int => Boolean = ???
  val S : Set[Int] = ???

  //x → √x²+1
  val g = (x:Double) => math.sqrt(x * x + 1)

  //sequence[1,2,3, ... ,100 ]
  val seq = 1 to n

  //sequence[f(1),f(2),f(3), ... ,f(100) ]
  val seqf = (1 to n).map(f)

  //∀k such that 1 <= k <= n p(k) holds
  (1 to n).forall(p)

  //∃k such that 1 <= k <= n p(k) holds
  (1 to n).exists(p)

  //∑k∈S:P(k) holds f(k)
  S.filter(p).map(f).sum

}
