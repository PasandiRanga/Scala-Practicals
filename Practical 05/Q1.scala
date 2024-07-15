import scala.io.StdIn.readLine

object InventoryManagementSystem {

  def getProductList(): List[String] = {
    def loop(products: List[String]): List[String] = {
      val productName = readLine("Enter product name (or type 'done' to finish): ")
      if (productName.toLowerCase == "done") {
        products
      } else {
        loop(products :+ productName)
      }
    }
    loop(Nil)
  }

  def printProductList(productList: List[String]): Unit = {
    productList.zipWithIndex.foreach {
      case (product, index) => println(s"${index + 1}. $product")
    }
  }

  def getTotalProducts(productList: List[String]): Int = {
    productList.length
  }

  def main(args: Array[String]): Unit = {
    val productList = getProductList()
    println("\nProduct List:")
    printProductList(productList)
    println(s"\nTotal number of products: ${getTotalProducts(productList)}")
  }
}
