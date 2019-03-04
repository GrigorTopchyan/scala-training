package edu.training.scala

import scala.io.Source

object ReadingFromFile extends App {
  val filePath = "aaa.txt"
  val lines = Source.fromFile(filePath).getLines().toList

}
