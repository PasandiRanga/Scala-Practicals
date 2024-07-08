object InventoryManagement {

  var itemNames: Array[String] = Array("Apples", "Oranges", "Bananas")
  var itemQuantities: Array[Int] = Array(10, 20, 30)

  def displayInventory(): Unit = {
    println("Inventory:")
    for (i <- itemNames.indices) {
      println(s"${itemNames(i)}: ${itemQuantities(i)}")
    }
  }

  def restockItem(itemName: String, quantity: Int): Unit = {
    val index = itemNames.indexOf(itemName)
    if (index != -1) {
      itemQuantities(index) += quantity
      println(s"$quantity units of $itemName have been added. New quantity: ${itemQuantities(index)}")
    } else {
      println(s"""Item "$itemName" does not exist in the inventory.""")
    }
  }

  def sellItem(itemName: String, quantity: Int): Unit = {
    val index = itemNames.indexOf(itemName)
    if (index != -1) {
      if (itemQuantities(index) >= quantity) {
        itemQuantities(index) -= quantity
        println(s"$quantity units of $itemName have been sold. New quantity: ${itemQuantities(index)}")
      } else {
        println(s"""Not enough quantity of "$itemName" to sell. Available quantity: ${itemQuantities(index)}""")
      }
    } else {
      println(s"""Item "$itemName" does not exist in the inventory.""")
    }
  }

  def main(args: Array[String]): Unit = {
    displayInventory()
    restockItem("Apples", 5)
    sellItem("Oranges", 10)
    sellItem("Bananas", 35)
    displayInventory()
  }
}
