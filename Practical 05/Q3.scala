object Fibonacci {

  def fibonacci(n: Int): Int = {
    if (n <= 1) n
    else fibonacci(n - 1) + fibonacci(n - 2)
  }

  def printFibonacci(n: Int): Unit = {
    def loop(i: Int): Unit = {
      if (i < n) {
        print(fibonacci(i) + " ")
        loop(i + 1)
      }
    }
    loop(0)
  }

  def main(args: Array[String]): Unit = {
    println("Enter the number of Fibonacci numbers to print:")
    val n = scala.io.StdIn.readInt()
    printFibonacci(n)
  }
}
