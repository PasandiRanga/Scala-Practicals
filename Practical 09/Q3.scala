object NameFormatter extends App {

  // Method to convert a string to upper case
  val toUpper: String => String = _.toUpperCase

  // Method to convert a string to lower case
  val toLower: String => String = _.toLowerCase

  // Method to format the name based on the provided formatting function
  def formatNames(name: String)(formatFunction: String => String): String = {
    formatFunction(name)
  }

  // Test inputs
  val names = List(
    formatNames("Benny")(toUpper),                 // BENNY
    formatNames("Niroshan")(name => name.substring(0, 2).toUpperCase + name.substring(2).toLowerCase), // NIroshan
    formatNames("Saman")(toLower),                 // saman
    formatNames("Kumara")(name => name.substring(0, name.length - 1).toLowerCase + name.last.toUpper)  // KumarA
  )

  // Print the formatted names
  names.foreach(println)
}
