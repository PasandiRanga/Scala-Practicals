object MovieTheaterProfitCalculator extends App {
  // Constants
  val basePrice: Double = 15.0
  val baseAttendance: Int = 120
  val priceChange: Double = 5.0
  val attendanceChange: Int = 20
  val fixedCost: Double = 500.0
  val costPerAttendee: Double = 3.0

  def calculateAttendance(ticketPrice: Double): Int = {
    baseAttendance + ((basePrice - ticketPrice) / priceChange * attendanceChange).toInt
  }

  def calculateRevenue(ticketPrice: Double, attendance: Int): Double = {
    ticketPrice * attendance
  }

  def calculateCost(attendance: Int): Double = {
    fixedCost + (attendance * costPerAttendee)
  }

  def calculateProfit(ticketPrice: Double): Double = {
    val attendance = calculateAttendance(ticketPrice)
    val revenue = calculateRevenue(ticketPrice, attendance)
    val cost = calculateCost(attendance)
    revenue - cost
  }

  def findBestTicketPrice(minPrice: Double, maxPrice: Double, increment: Double): (Double, Double) = {
    var bestPrice: Double = minPrice
    var maxProfit: Double = calculateProfit(minPrice)
    var currentPrice: Double = minPrice + increment

    while (currentPrice <= maxPrice) {
      val currentProfit = calculateProfit(currentPrice)
      if (currentProfit > maxProfit) {
        maxProfit = currentProfit
        bestPrice = currentPrice
      }
      currentPrice += increment
    }
    (bestPrice, maxProfit)
  }

  val (bestPrice, maxProfit) = findBestTicketPrice(5.0, 50.0, 0.5)
  println(f"Best ticket price: Rs. $bestPrice%.2f")
  println(f"Maximum profit: Rs. $maxProfit%.2f")
}