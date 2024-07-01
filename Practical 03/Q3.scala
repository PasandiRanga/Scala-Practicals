object ArithmeticMean {
    def calculateArithmeticMean(num1:Int , num2:Int):Double ={
        val sum = num1 + num2
        val mean = sum.toDouble / 2.0
        BigDecimal(mean).setScale(2, BigDecimal.RoundingMode.HALF_UP).toDouble
    }

    def main(args: Array[String]): Unit = {
        val num1 = 10
        val num2 = 15
        val average = calculateArithmeticMean(num1, num2)
        println(s"The arithmetic mean of $num1 and $num2 is: $average")
    }
}