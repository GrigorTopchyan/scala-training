package edu.training.scala.fp

object RecursiveTypes extends App {
  val apple = new Apple
  val orange = new Orange
  val orange1 = new Orange

//  orange.compireTo(apple)
  orange.compireTo(orange1)

}

trait Fruit[T <: Fruit[T]]{
  final def compireTo(other: Fruit[T]): Boolean = ???
}

class Apple extends Fruit[Apple]
class Orange extends Fruit[Orange]


sealed trait IntList
final case object Empty extends IntList
final case class NonEmpty(head: Int, tail: IntList) extends IntList

sealed trait List[A]
final case object Nil extends List[Nothing]
final case class ::[A](head: A,tail: List[A]) extends List[A]
