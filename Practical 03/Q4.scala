object SumEvenNumbers {
  def sumOfEvenNumbers(numbers: List[Int]): Int = {
    var sum = 0
    for (number <- numbers) {
      if (number % 2 == 0) {
        sum += number
      }
    }
    sum
  }

  def main(args: Array[String]): Unit = {
    val numbers = List(1, 2, 3, 4, 5, 6)
    println(s"Sum of even numbers = ${sumOfEvenNumbers(numbers)}")
  }
}

