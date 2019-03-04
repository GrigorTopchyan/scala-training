package edu.training.scala

import org.scalatest.{FlatSpec, Matchers}

class ExampleSpecTests extends FlatSpec with Matchers{
  behavior of "Examples"

  def ex1(a:  Seq[Double]): Seq[(Double,Double)] =
    a.map(x => (math.sin(x),math.cos(x)))

  it should "run ex1" in {
    ex1(Seq(0,0.1,0.2)) shouldEqual Seq(
      (math.sin(0),math.cos(0)),
      (math.sin(0.1),math.cos(0.1)),
      (math.sin(0.2),math.cos(0.2))
    )
  }

  def ex2(a: Seq[Double]):Int =
    a.count(x => math.cos(x) > math.sin(x))

  it should "run ex2" in {
    ex2(Seq(0,0.1,0.2)) shouldEqual 3
  }


  def ex3(a: Seq[Double], b: Seq[Double]):Seq[Double] =
    a.zip(b).map {case (x,y) => x - y}

  it should "run ex3" in {
    ex3(Seq(0,1.0,2.0),Seq(0,1.0,2.0)) shouldEqual Seq(0.0,0.0,0.0)
  }

  def ex4(a: Seq[Int]): Int =
    a.zip(a.drop(1)).count{case (x,y) => x > y}

  it should "run ex4" in {
    ex4(Seq(1,3,2,4)) shouldEqual 1
  }


  def ex5(i: Int, a: Seq[Int]):Seq[Int] = {
    a.sliding(2 * i + 1).map(seq => seq.max).toSeq
  }

  it should "run ex5" in {
    ex5(1,Seq(1,5,2,10,4,-1,20)) shouldEqual Seq(5,10,10,10,20)
  }

  def ex6(k: Int):Map[(Int,Int),Int] ={
    (1 to k).flatMap(i => (i to k).map(j => (i,j) -> i*j)).toMap
  }

  it should "run ex6" in {
    ex6(3) shouldEqual Map(
      (1,1) -> 1,
      (1,2) -> 2,
      (1,3) -> 3,
      (2,2) -> 4,
      (2,3) -> 6,
      (3,3) -> 9
    )
  }

  def ex7[Name,Address](data: Map[Name, Address]):Map[Address,Name] = {
    data.map{case (name,address) => (address,name)}
  }

  it should "run ex7" in {
    val data = Map("user1" -> "addres1","user2" -> "addres2","user3" -> "addres3")
    val expected = Map("addres1" -> "user1","addres2" -> "user2","addres3" -> "user3")
    ex7(data) shouldEqual expected
  }

  def ex8(seq: Seq[(String,Int)]): Map[String,Int]= {
    seq.groupBy{case (n,p) => n}
      .map{case (n,l) => n -> l.map(_._2).sum}
  }

  it should "run ex8" in {
    ex8(Seq(("apple",2),("pear",3),("apple",5))) shouldEqual Map("apple" -> 7,"pear" -> 3)
  }


  def ex9(seq: Seq[List[Int]]):Seq[List[Int]] = {
    seq.map(l => l.sorted.takeRight(3))
  }

  it should "run ex9" in {
    ex9(Seq(List(3,6,9,10,2,4),List(1,6,9,10,2,4),List(2,6,9,10,2,4))) shouldEqual Seq(List(6,9,10),List(6,9,10),List(6,9,10))
  }

  def ex10(set1: Set[Int], set2: Set[Int]) : Set[(Int,Int)]= {
    set1.flatMap(x => set2.map(y => (x,y)))
  }

  it should "run ex10" in {
    ex10(Set(1,2,3),Set(4,5,6)) shouldEqual Set((1,4),(1,5),(1,6),(2,4),(2,5),(2,6),(3,4),(3,5),(3,6))
  }


  def ex11(f: Int => Int, init: Int, limit: Int):Int = {
    Iterator.iterate(init)(f).takeWhile(_ <= limit).size
  }

  it should "run ex11" in{
    ex11(x => 2*x +1,1,1000) shouldEqual 9
  }
}
