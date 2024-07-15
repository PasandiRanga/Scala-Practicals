import scala.io.StdIn._

case class Book(title: String, author: String, isbn: String)

object LibraryManagement {

  var library: Set[Book] = Set(
    Book("1984", "George Orwell", "1234567890"),
    Book("To Kill a Mockingbird", "Harper Lee", "2345678901"),
    Book("The Great Gatsby", "F. Scott Fitzgerald", "3456789012")
  )

  def main(args: Array[String]): Unit = {
    var continue = true
    while (continue) {
      println(
        """|
           |Library Management System
           |1. Display library collection
           |2. Add a new book
           |3. Remove a book by ISBN
           |4. Check if a book is in the library by ISBN
           |5. Search for a book by title
           |6. Display all books by a specific author
           |7. Exit
           |Choose an option: """.stripMargin)
      val choice = readLine().toInt
      choice match {
        case 1 => displayLibraryCollection()
        case 2 => addNewBook()
        case 3 => removeBookByISBN()
        case 4 => checkBookByISBN()
        case 5 => searchBookByTitle()
        case 6 => displayBooksByAuthor()
        case 7 => continue = false
        case _ => println("Invalid choice, please try again.")
      }
    }
  }

  def displayLibraryCollection(): Unit = {
    if (library.isEmpty) {
      println("The library is currently empty.")
    } else {
      println("Current Library Collection:")
      library.foreach(book => println(s"Title: ${book.title}, Author: ${book.author}, ISBN: ${book.isbn}"))
    }
  }

  def addNewBook(): Unit = {
    println("Enter the title of the book:")
    val title = readLine()
    println("Enter the author of the book:")
    val author = readLine()
    println("Enter the ISBN of the book:")
    val isbn = readLine()
    val newBook = Book(title, author, isbn)
    library += newBook
    println(s"Book '${title}' by ${author} added to the library.")
  }

  def removeBookByISBN(): Unit = {
    println("Enter the ISBN of the book to remove:")
    val isbn = readLine()
    val bookOption = library.find(_.isbn == isbn)
    bookOption match {
      case Some(book) =>
        library -= book
        println(s"Book '${book.title}' by ${book.author} removed from the library.")
      case None =>
        println(s"No book found with ISBN: $isbn")
    }
  }

  def checkBookByISBN(): Unit = {
    println("Enter the ISBN of the book to check:")
    val isbn = readLine()
    if (library.exists(_.isbn == isbn)) {
      println(s"Book with ISBN: $isbn is in the library.")
    } else {
      println(s"No book found with ISBN: $isbn")
    }
  }

  def searchBookByTitle(): Unit = {
    println("Enter the title of the book to search:")
    val title = readLine()
    val bookOption = library.find(_.title.equalsIgnoreCase(title))
    bookOption match {
      case Some(book) =>
        println(s"Book Found - Title: ${book.title}, Author: ${book.author}, ISBN: ${book.isbn}")
      case None =>
        println(s"No book found with title: $title")
    }
  }

  def displayBooksByAuthor(): Unit = {
    println("Enter the author's name to search for their books:")
    val author = readLine()
    val booksByAuthor = library.filter(_.author.equalsIgnoreCase(author))
    if (booksByAuthor.isEmpty) {
      println(s"No books found by author: $author")
    } else {
      println(s"Books by $author:")
      booksByAuthor.foreach(book => println(s"Title: ${book.title}, ISBN: ${book.isbn}"))
    }
  }
}