object RunningTimeCalculator {
  def main(args: Array[String]): Unit = {
    val easyPace = 8 
    val tempoPace = 7 

  
    val easyDistance1 = 2 
    val tempoDistance = 3 
    val easyDistance2 = 2 

    val timeEasy1 = easyPace * easyDistance1
    val timeTempo = tempoPace * tempoDistance
    val timeEasy2 = easyPace * easyDistance2

    val totalTime = timeEasy1 + timeTempo + timeEasy2

    println(s"The total running time is $totalTime minutes")
  }
}
