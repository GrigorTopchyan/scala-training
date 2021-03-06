package edu.training.scala.oop

class LineElement(s: String) extends ArrayElement(Array(s)) {
  override def width: Int = s.length
  override def height: Int = 1
}
