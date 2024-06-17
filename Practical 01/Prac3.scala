object SphereVolumeCalculator {
  def volumeOfSphere(radius: Double): Double = {
    (4.0 / 3.0) * 3.14 * radius * radius * radius
  }

  def main(args: Array[String]): Unit = {
    val radius = 5.0
    val volume = volumeOfSphere(radius)
    println(s"The volume of a sphere with radius $radius is $volume")
  }
}
