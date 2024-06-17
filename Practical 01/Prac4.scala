object BookstoreCostCalculator {
  def main(args: Array[String]): Unit = {
    val coverPrice = 24.95
    val discount = 0.40
    val numberOfCopies = 60
    val shippingCostFirst50 = 3.00
    val shippingCostAdditional = 0.75

    val discountedPrice = coverPrice * (1 - discount)

    val totalBookCost = discountedPrice * numberOfCopies

    val shippingCost = shippingCostFirst50 + (if (numberOfCopies > 50) (numberOfCopies - 50) * shippingCostAdditional else 0)

    val totalWholesaleCost = totalBookCost + shippingCost

    println(s"The total wholesale cost for $numberOfCopies copies is Rs. $totalWholesaleCost")
  }
}
