object TemperatureConverter {
  def celsiusToFahrenheit(celsius: Double): Double = {
    celsius * 1.8 + 32
  }

  def main(args: Array[String]): Unit = {
    val celsius = 35.0
    val fahrenheit = celsiusToFahrenheit(celsius)
    println(s"The temperature $celsius Celsius is equal to $fahrenheit Fahrenheit")
  }
}
