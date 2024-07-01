object Main {
  def reverseStringRecursive(input: String): String = {
    if (input.isEmpty) ""
    else reverseStringRecursive(input.tail) + input.head
  }

  def main(args: Array[String]): Unit = {
    val reversed = reverseStringRecursive("hello")
    println(reversed)  
  }
}
