// File: InventoryManagement.scala

object InventoryManagement {

  def main(args: Array[String]): Unit = {
    val inventory1 = Map(
      101 -> ("Product A", 10, 15.5),
      102 -> ("Product B", 5, 25.0),
      103 -> ("Product C", 8, 12.75)
    )

    val inventory2 = Map(
      102 -> ("Product B", 3, 30.0),
      104 -> ("Product D", 7, 20.0)
    )

    // I. Retrieve all product names from inventory1
    val productNames = inventory1.values.map(_._1).toList
    println(s"Product names: $productNames")

    // II. Calculate the total value of all products in inventory1
    val totalValue = inventory1.values.map { case (_, quantity, price) => quantity * price }.sum
    println(s"Total value of all products: $totalValue")

    // III. Check if inventory1 is empty
    val isEmpty = inventory1.isEmpty
    println(s"Is inventory1 empty? $isEmpty")

    // IV. Merge inventory1 and inventory2, updating quantities and retaining the highest price
    val mergedInventory = (inventory1.keySet ++ inventory2.keySet).map { id =>
      val (name1, qty1, price1) = inventory1.getOrElse(id, ("", 0, 0.0))
      val (name2, qty2, price2) = inventory2.getOrElse(id, ("", 0, 0.0))
      val name = if (name1.nonEmpty) name1 else name2
      val quantity = qty1 + qty2
      val price = math.max(price1, price2)
      id -> (name, quantity, price)
    }.toMap

    println(s"Merged Inventory: $mergedInventory")

    // V. Check if a product with a specific ID (e.g., 102) exists and print its details if it does
    val productIdToCheck = 102
    inventory1.get(productIdToCheck) match {
      case Some((name, quantity, price)) =>
        println(s"Product ID: $productIdToCheck, Name: $name, Quantity: $quantity, Price: $price")
      case None =>
        println(s"Product with ID $productIdToCheck does not exist.")
    }
  }
}
