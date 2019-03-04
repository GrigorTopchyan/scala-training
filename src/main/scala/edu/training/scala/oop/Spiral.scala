package edu.training.scala.oop
import Element.elem

object Spiral {
  val space: Element = elem(" ")
  val corner: Element = elem("+")

  def spiral(nEdges: Int, direction: Int): Element = {
    if(nEdges == 1)
      elem("+")
    else {
      val sp = spiral(nEdges - 1,(direction + 3)%4)
      def vertical = elem('|',1,sp.height)
      def horizontal = elem('-',sp.width,1)
      if (direction == 0)
        (corner beside horizontal) above (sp beside space)
      else if (direction == 1)
        (sp above space) beside (corner above vertical)
      else if (direction == 2)
        (space beside sp) above (horizontal beside corner)
      else
        (vertical above corner) beside (space above sp)
    }
  }

  def main(args: Array[String]): Unit = {
    val nSides = 11
    println(spiral(nSides,0))
  }
}
