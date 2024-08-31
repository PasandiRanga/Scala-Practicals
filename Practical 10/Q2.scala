// Rational.scala
class MyRational(n: Int, d: Int) {
  require(d != 0, "Denominator cannot be zero")

  // Greatest common divisor
  private val g = gcd(n.abs, d.abs)
  val numerator: Int = n / g
  val denominator: Int = d / g

  // Auxiliary constructor to handle cases where only the numerator is provided
  def this(n: Int) = this(n, 1)

  // Negation method
  def neg: MyRational = new MyRational(-numerator, denominator)

  // Addition of two rational numbers
  def +(that: MyRational): MyRational =
    new MyRational(
      numerator * that.denominator + that.numerator * denominator,
      denominator * that.denominator
    )

  // Subtraction of two rational numbers
  def sub(that: MyRational): MyRational =
    new MyRational(
      numerator * that.denominator - that.numerator * denominator,
      denominator * that.denominator
    )

  // Multiplication of two rational numbers
  def *(that: MyRational): MyRational =
    new MyRational(numerator * that.numerator, denominator * that.denominator)

  // Division of two rational numbers
  def /(that: MyRational): MyRational =
    new MyRational(numerator * that.denominator, denominator * that.numerator)

  // Override toString for a nice display of the rational number
  override def toString: String =
    if (denominator == 1) s"$numerator" else s"$numerator/$denominator"

  // Helper method to compute the greatest common divisor
  private def gcd(a: Int, b: Int): Int =
    if (b == 0) a else gcd(b, a % b)
}

// Companion object for creating MyRational instances
object MyRational {
  def apply(n: Int, d: Int): MyRational = new MyRational(n, d)
  def apply(n: Int): MyRational = new MyRational(n)
}

// Main.scala
object RMain {
  def main(args: Array[String]): Unit = {
    val x = MyRational(3, 4)
    val y = MyRational(5, 8)
    val z = MyRational(2, 7)

    // Calculate y - z
    val difference = y.sub(z)
    println(s"y - z: $y - $z = $difference") // Outputs the result of y - z

    // Calculate x * (y - z)
    val result = x * difference
    println(s"x * (y - z): $x * ($y - $z) = $result") // Outputs the final result
  }
}
