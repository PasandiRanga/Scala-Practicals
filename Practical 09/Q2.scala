object NumberPatternMatcher extends App {

  // Lambda function to match the number and return the appropriate message
  val matchNumber: Int => String = num => num match {
    case n if n <= 0 => "Negative/Zero is input"       // Negative or Zero
    case n if n % 2 == 0 => "Even number is given"     // Even number
    case _ => "Odd number is given"                    // Odd number
  }

  // Get input from the user
  println("Please enter an integer:")
  val inputNumber = scala.io.StdIn.readInt()

  // Use the matchNumber function to get the result
  val result = matchNumber(inputNumber)

  // Print the result
  println(result)
}
