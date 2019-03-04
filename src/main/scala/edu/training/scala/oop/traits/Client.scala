package edu.training.scala.oop.traits

object Client extends App {
  val queue = new MyQueue
  queue.put(10)
  println(queue.get())

  val basicIntQueue = new BasicIntQueue with Incrementing with Doubling with Filtering
  basicIntQueue.put(-10)
  basicIntQueue.put(10)
  println(basicIntQueue.get())
}
