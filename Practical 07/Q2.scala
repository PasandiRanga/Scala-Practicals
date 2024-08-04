object SquareCalculator {
  // Function to calculate the square of each number in the list
  def calculateSquare(numbers: List[Int]): List[Int] = {
    numbers.map(number => number * number)
  }

  def main(args: Array[String]): Unit = {
    val input = List(1, 2, 3, 4, 5)
    val output = calculateSquare(input)
    println(output)  // Output: List(1, 4, 9, 16, 25)
  }
}
