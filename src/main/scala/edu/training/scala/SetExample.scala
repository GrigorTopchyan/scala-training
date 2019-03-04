package edu.training.scala
import scala.collection.mutable

object SetExample extends App {
//  var imutableSet = Set("A","B","C")
//  var mutableSet = mutable.Set("A","B","C")
//  imutableSet += "D"
//  mutableSet += "D"
//  println(imutableSet)
//  println(mutableSet)

  //println(Seq(1,5,2,10,4,-1,20).sliding(3).map(list => list.max))
//  val k = 3
//  val res = (1 to k).flatMap(i => {(i to k).map(j => ((i,j),i*j))}).toMap
//  println(res)


//
//  println(Seq(("apple",2),("pear",3),("apple",5))
//    .groupBy{case (x,y) => x}
//    .map(e => e._1 -> e._2.map(t => t._2).sum ))

  val res  = Iterator.iterate((123456,0)){case (x,y) => (x/10, x%10)}
    .takeWhile{case (x,y) => x != 0 || y != 0}
    .map(_._2)
    .toList
   // .reverse

  println(res)
}
