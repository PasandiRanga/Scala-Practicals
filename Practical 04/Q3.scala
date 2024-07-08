object NameFormatter {

  // Method to convert a string to upper case
  def toUpper(name: String): String = name.toUpperCase

  // Method to convert a string to lower case
  def toLower(name: String): String = name.toLowerCase

  // Method to format names using a given formatting function
  def formatNames(name: String)(format: String => String): String = format(name)

  def main(args: Array[String]): Unit = {
    // Test inputs
    val names = List("Benny", "Niroshan", "Saman", "Kumara")

    // Output the formatted names
    println(formatNames("Benny")(toUpper))         // Output: BENNY
    println(formatNames("Niroshan")(name => {
      val (firstTwo, rest) = name.splitAt(2)
      firstTwo.toUpperCase + rest
    }))                                            // Output: NIroshan
    println(formatNames("Saman")(toLower))         // Output: saman
    println(formatNames("Kumara")(name => {
      val (first, rest) = name.splitAt(name.length - 1)
      first + rest.toUpperCase
    }))                                            // Output: KumarA
  }
}
