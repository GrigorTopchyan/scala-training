package edu.training.scala.rational

class Rational(n: Int, d: Int) extends Ordered[Rational]{
  require(d != 0)
  private val g = gcd(n,d)
  val numer: Int = n/g
  val denom: Int = d/g

  def this(n: Int) = this(n,1)
  override def toString: String = numer + "/" + denom

  def +(that: Rational):Rational = new Rational(that.denom * this.numer + that.numer * this.denom,this.denom * that.denom)
  def +(i:Int) = new Rational(numer + i * denom,denom)
  def -(that: Rational):Rational = new Rational(this.denom * that.numer - this.numer * that.denom,this.denom * that.denom)
  def -(i:Int) = new Rational(numer - i * denom,denom)
  def *(that: Rational) = new Rational(this.numer * that.numer,this.denom * that.denom)
  def *(i: Int) = new Rational(numer * i,denom)
  def /(that: Rational) = new Rational(this.numer * that.denom,this.denom * that.numer)
  def /(i: Int) = new Rational(numer,denom * i)

  def lessThan(that: Rational): Boolean = this.numer * that.denom < this.denom * that.numer
  def max(that: Rational): Rational = if(this.lessThan(that)) that else this
  private def gcd(a:Int, b: Int):Int = if(b == 0) a else gcd(b, a % b)

  override def compare(that: Rational): Int = this.numer * that.denom - this.denom * that.numer
}
