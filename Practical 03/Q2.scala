object FilterStrings {
  def filterStringsByLength(strings: List[String]): List[String] = {
    strings.filter(_.length > 5)
  }

  def main(args: Array[String]): Unit = {
    val inputList = List("apple", "banana", "grapefruit", "kiwi", "orange")
    val filteredList = filterStringsByLength(inputList)
    println("Original List: " + inputList)
    println("Filtered List (length > 5): " + filteredList)
  }
}
