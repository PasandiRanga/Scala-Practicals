object InterestCalculator extends App {

  // Function to calculate interest
  val calculateInterest: Double => Double = deposit => {
    deposit match {
      case d if d <= 20000    => d * 0.02   // 2% for deposits up to Rs. 20,000
      case d if d <= 200000   => d * 0.04   // 4% for deposits up to Rs. 200,000
      case d if d <= 2000000  => d * 0.035  // 3.5% for deposits up to Rs. 2,000,000
      case d if d > 2000000   => d * 0.065  // 6.5% for deposits over Rs. 2,000,000
    }
  }

  // Get deposit amount from the user
  println("Enter the deposit amount in Rs.: ")
  val depositAmount = scala.io.StdIn.readLine().toDouble

  // Calculate the interest
  val interest = calculateInterest(depositAmount)

  // Display the result
  println(s"The interest for a deposit of Rs. $depositAmount is Rs. $interest")
}
