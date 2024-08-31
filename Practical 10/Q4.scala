object LetterCounter {

  def countLetterOccurrences(words: List[String]): Int = {
    // Use map to transform the words into their respective lengths
    val lengths = words.map(_.length)
    
    // Use reduce to sum up the lengths to get the total count of letter occurrences
    val totalLetters = lengths.reduce(_ + _)
    
    totalLetters
  }

  def main(args: Array[String]): Unit = {
    val words = List("apple", "banana", "cherry", "date")
    val totalCount = countLetterOccurrences(words)
    println(s"Total count of letter occurrences: $totalCount")
  }
}
