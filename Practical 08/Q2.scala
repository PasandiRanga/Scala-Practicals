object NumberCategorizer {
  def main(args: Array[String]): Unit = {
    // Prompt user for input
    println("Please enter an integer:")
    val input = scala.io.StdIn.readLine().toInt

    // Lambda functions for each case
    val multipleOfThree = (n: Int) => n % 3 == 0
    val multipleOfFive = (n: Int) => n % 5 == 0

    // Pattern matching based on the input
    input match {
      case n if multipleOfThree(n) && multipleOfFive(n) => println("Multiple of Both Three and Five")
      case n if multipleOfThree(n) => println("Multiple of Three")
      case n if multipleOfFive(n) => println("Multiple of Five")
      case _ => println("Not a Multiple of Three or Five")
    }
  }
}
