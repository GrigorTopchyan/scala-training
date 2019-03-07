package edu.training.scala

import org.scalatest.prop.{GeneratorDrivenPropertyChecks, TableDrivenPropertyChecks}
import org.scalatest.{FlatSpec, Matchers}

class CarryHowardCorespondence extends FlatSpec with Matchers with GeneratorDrivenPropertyChecks with TableDrivenPropertyChecks{
  behavior of "Curry-Howard correspondence"

  it should "verify example 1" in {
    def f1[A]: ((A,Unit)) => A = {case (c,b) => c}
    def f2[A]: A => (A,Unit) = a => (a,())

    forAll { n: Int => f1(f2(n)) shouldEqual n }
    forAll { x:(String,Unit) => f2(f1(x)) shouldEqual x }
  }

  it should "verify example 2" in {
    def f1[A,B,C]:(((A,B),C)) => (A,(B,C)) = {
      case((x,y),z) => (x,(y,z))
    }

    def f2[A,B,C]:((A,(B,C))) => ((A,B),C) = {
      case(x,(y,z)) => ((x,y),z)
    }

    forAll{x:((Int,Boolean),String) => f2(f1(x)) shouldEqual x}
    forAll{x:(Int,(Boolean,String)) => f1(f2(x)) shouldEqual x}
  }

  it should "verify example 3" in {
    def f1[A,B,C]: ((Either[A,B],C)) => Either[(A,C),(B,C)] = {
      case(eab,c) => eab match {
        case Left(a) => Left((a,c))
        case Right(b) => Right((b,c))
      }
    }
    def f2[A,B,C]: Either[(A,C),(B,C)] =>(Either[A,B],C) = {
      case Left((x, y)) => (Left(x), y)
      case Right((x, y)) => (Right(x), y)
    }

    forAll { x:(Either[Int,Boolean],String) => f2(f1(x))}
    forAll { x: Either[(Int,String),(Boolean,String)] => f1(f2(x))}
  }

  it should "verify example 4" in {
    def f1[A,B,C]: (Either[A,B] => C) => (A => C,B => C) = {
      p => (a => p(Left(a)), b => p(Right(b)))
    }

    def f2[A,B,C]: ((A => C,B => C)) => Either[A,B] => C = {
      case(ac,bc) => {
        case Left(x) => ac(x)
        case Right(x) => bc(x)
      }
    }

    forAll{(p: Either[Int, Boolean] => String) =>
      val p12: Either[Int,Boolean] => String = f2(f1(p))
      forAll{(ab:Either[Int,Boolean]) => p(ab) shouldEqual p12(ab)}
    }

    forAll{p: (Int => String,Boolean => String) =>
      val p21: (Int => String,Boolean => String) = f1(f2(p))
      forAll {(a: Int, b: Boolean) =>
        p._1(a) shouldEqual p21._1(a)
        p._2(b) shouldEqual p21._2(b)
      }
    }
  }
}
