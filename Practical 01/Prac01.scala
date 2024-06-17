object DiskAreaCalculator {
  def areaOfDisk(radius: Double): Double = {
    3.14 * radius * radius
  }

  def main(args: Array[String]): Unit = {
    val radius = 5.0
    val area = areaOfDisk(radius)
    println(s"The area of a disk with radius $radius is $area")
  }
}
