object PatternMatchingExample {
  def main(args: Array[String]): Unit = {
    if (args.length != 1) {
      println("Please provide a single integer as input.")
      System.exit(1)
    }

    val input: Int = try {
      args(0).toInt
    } catch {
      case _: NumberFormatException =>
        println("Invalid input. Please provide a valid integer.")
        System.exit(1)
        0 
    }

    input match {
      case x if x <= 0 => println("Negative/Zero is input")
      case x if x % 2 == 0 => println("Even number is given")
      case _ => println("Odd number is given")
    }
  }
}
