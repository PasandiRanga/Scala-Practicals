

import scala.io.StdIn.readLine
import scala.util.Try

object StudentRecords {

  def main(args: Array[String]): Unit = {
    val studentInfo = getStudentInfoWithRetry()
    printStudentRecord(studentInfo)
  }

  def getStudentInfo(name: String, marks: Int, totalMarks: Int): (String, Int, Int, Double, Char) = {
    val percentage = (marks.toDouble / totalMarks) * 100
    val grade = percentage match {
      case p if p >= 90 => 'A'
      case p if p >= 75 => 'B'
      case p if p >= 50 => 'C'
      case _ => 'D'
    }
    (name, marks, totalMarks, percentage, grade)
  }


  def printStudentRecord(record: (String, Int, Int, Double, Char)): Unit = {
    val (name, marks, totalMarks, percentage, grade) = record
    println(s"Student Name: $name")
    println(s"Marks: $marks / $totalMarks")
    println(f"Percentage: $percentage%.2f%%")
    println(s"Grade: $grade")
  }


  def validateInput(name: String, marksStr: String, totalMarksStr: String): (Boolean, Option[String]) = {
    if (name.isEmpty) {
      (false, Some("Name cannot be empty."))
    } else if (!name.forall(_.isLetter)) {
      (false, Some("Name must contain only alphabetic characters."))
    } else {
      val marksOpt = Try(marksStr.toInt).toOption
      val totalMarksOpt = Try(totalMarksStr.toInt).toOption

      (marksOpt, totalMarksOpt) match {
        case (Some(marks), Some(totalMarks)) if marks >= 0 && marks <= totalMarks =>
          (true, None)
        case (Some(_), Some(totalMarks)) if totalMarks < 0 =>
          (false, Some("Total possible marks must be a positive integer."))
        case (Some(_), Some(_)) =>
          (false, Some("Marks must be a non-negative integer and less than or equal to total possible marks."))
        case _ =>
          (false, Some("Invalid input for marks or total possible marks. Please enter positive integers."))
      }
    }
  }
  

  def getStudentInfoWithRetry(): (String, Int, Int, Double, Char) = {
    var isValid = false
    var studentRecord: (String, Int, Int, Double, Char) = ("", 0, 0, 0.0, 'D')

    while (!isValid) {
      println("Enter student's name:")
      val name = readLine()
      println("Enter student's marks:")
      val marks = readLine()
      println("Enter total possible marks:")
      val totalMarks = readLine()

      val (valid, errorMessage) = validateInput(name, marks, totalMarks)

      if (valid) {
        studentRecord = getStudentInfo(name, marks.toInt, totalMarks.toInt)
        isValid = true
      } else {
        println(s"Error: ${errorMessage.getOrElse("Invalid input")}. Please try again.")
      }
    }

    studentRecord
  }
}
