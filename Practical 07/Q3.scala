object PrimeFilter {
  // Function to check if a number is prime
  def isPrime(n: Int): Boolean = {
    if (n <= 1) false
    else if (n <= 3) true
    else if (n % 2 == 0 || n % 3 == 0) false
    else {
      var i = 5
      while (i * i <= n) {
        if (n % i == 0 || n % (i + 2) == 0) return false
        i += 6
      }
      true
    }
  }

  // Function to filter prime numbers from a list
  def filterPrime(numbers: List[Int]): List[Int] = {
    numbers.filter(number => isPrime(number))
  }

  def main(args: Array[String]): Unit = {
    val input = List(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)
    val output = filterPrime(input)
    println(output)  // Output: List(2, 3, 5, 7)
  }
}
