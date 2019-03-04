package edu.training.scala.oop.traits

trait Incrementing extends IntQueue {
  abstract override def put(x: Int): Unit = super.put(x + 1)

}
