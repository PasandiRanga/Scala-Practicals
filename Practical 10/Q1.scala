// Rational.scala
class Rational(n: Int, d: Int) {
  require(d != 0, "Denominator cannot be zero")

  // Greatest common divisor
  private val g = gcd(n.abs, d.abs)
  val numerator: Int = n / g
  val denominator: Int = d / g

  // Auxiliary constructor to handle cases where only the numerator is provided
  def this(n: Int) = this(n, 1)

  // Negation method
  def neg: Rational = new Rational(-numerator, denominator)

  // Addition of two rational numbers
  def +(that: Rational): Rational =
    new Rational(
      numerator * that.denominator + that.numerator * denominator,
      denominator * that.denominator
    )

  // Subtraction of two rational numbers
  def -(that: Rational): Rational = this + that.neg

  // Multiplication of two rational numbers
  def *(that: Rational): Rational =
    new Rational(numerator * that.numerator, denominator * that.denominator)

  // Division of two rational numbers
  def /(that: Rational): Rational =
    new Rational(numerator * that.denominator, denominator * that.numerator)

  // Override toString for a nice display of the rational number
  override def toString: String =
    if (denominator == 1) s"$numerator" else s"$numerator/$denominator"

  // Helper method to compute the greatest common divisor
  private def gcd(a: Int, b: Int): Int =
    if (b == 0) a else gcd(b, a % b)
}

// Companion object for creating Rational instances
object Rational {
  def apply(n: Int, d: Int): Rational = new Rational(n, d)
  def apply(n: Int): Rational = new Rational(n)
}

// Main.scala
object MyMain {
  def main(args: Array[String]): Unit = {
    val x = Rational(3, 4)
    println(s"Original: $x")  // Outputs: Original: 3/4
    println(s"Negation: ${x.neg}")  // Outputs: Negation: -3/4

    // Further examples
    val y = Rational(5, 6)
    val z = x + y
    println(s"Addition: $x + $y = $z")  // Outputs: Addition: 3/4 + 5/6 = 19/12
  }
}
