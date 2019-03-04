package edu.training.scala.fp

object ByNameParameters extends App {
  var assertionsEnabled = true

  def myAssert(predicate: () => Boolean): Unit =
    if (assertionsEnabled && !predicate())
      throw new AssertionError


  def byNameAssert(predicate: => Boolean): Unit =
    if (assertionsEnabled && !predicate)
      throw new AssertionError

  def boolAssert(predicate: Boolean): Unit =
    if(assertionsEnabled && !predicate)
      throw new AssertionError


  myAssert(() => 5 > 4)
  boolAssert(5 > 4)
  //Lazy
  byNameAssert(5 > 3)
  assertionsEnabled = false
  byNameAssert(5/0 == 0)
}
