object SalaryCalculator {
  val nRate = 250
  val otRate = 85
  val taxRate = 0.12

  def takeHomeSalary(nHours: Int, otHours: Int): Double = {
    val salary = (nHours * nRate) + (otHours * otRate)
    val tax = salary * taxRate
    val takeHome = salary - tax
    takeHome
  }

  def main(args: Array[String]): Unit = {
    val nHours = 40
    val otHours = 30
    val thSalary = takeHomeSalary(nHours, otHours)
    
    println(s"Take-home salary = Rs. $thSalary")
  }
}