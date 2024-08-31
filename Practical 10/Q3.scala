// Account.scala
class Account(private var balance: Double) {

  // Method to deposit money into the account
  def deposit(amount: Double): Unit = {
    require(amount > 0, "Deposit amount must be positive")
    balance += amount
  }

  // Method to withdraw money from the account
  def withdraw(amount: Double): Unit = {
    require(amount > 0, "Withdrawal amount must be positive")
    if (amount <= balance) {
      balance -= amount
    } else {
      println(s"Insufficient funds. Cannot withdraw $$${amount}. Current balance is $$${balance}.")
    }
  }

  // Method to transfer money from this account to another account
  def transfer(amount: Double, toAccount: Account): Unit = {
    require(amount > 0, "Transfer amount must be positive")
    if (amount <= balance) {
      this.withdraw(amount)
      toAccount.deposit(amount)
    } else {
      println(s"Insufficient funds. Cannot transfer $$${amount}. Current balance is $$${balance}.")
    }
  }

  // Method to check the current balance
  def getBalance: Double = balance

  // Apply interest based on the balance
  def applyInterest(): Unit = {
    if (balance > 0) {
      balance += balance * 0.05
    } else {
      balance += balance * 0.1
    }
  }

  // Override toString to show account balance
  override def toString: String = s"Account balance: $$${balance}"
}

// Bank.scala
class Bank(accounts: List[Account]) {

  // 4.1 List of Accounts with negative balances
  def negativeBalances: List[Account] = accounts.filter(_.getBalance < 0)

  // 4.2 Calculate the sum of all account balances
  def totalBalance: Double = accounts.map(_.getBalance).sum

  // 4.3 Calculate the final balances of all accounts after applying the interest function
  def applyInterestToAll(): Unit = accounts.foreach(_.applyInterest())
  
  // 4.4 Print all accounts
  def printAllAccounts(): Unit = accounts.foreach(println)
}

// Main.scala
object bMain {
  def main(args: Array[String]): Unit = {
    val account1 = new Account(1000.0)  // Account 1 with an initial balance of $1000
    val account2 = new Account(-200.0)  // Account 2 with an initial balance of -$200
    val account3 = new Account(300.0)   // Account 3 with an initial balance of $300
    val account4 = new Account(-50.0)   // Account 4 with an initial balance of -$50

    val bank = new Bank(List(account1, account2, account3, account4))

    // 4.1 List of Accounts with negative balances
    val negativeAccounts = bank.negativeBalances
    println("Accounts with negative balances:")
    negativeAccounts.foreach(println)

    // 4.2 Calculate the sum of all account balances
    val totalBalance = bank.totalBalance
    println(s"Total balance of all accounts: $$${totalBalance}")

    // 4.3 Apply interest to all accounts
    bank.applyInterestToAll()

    // Print final balances after applying interest
    println("Final balances after applying interest:")
    bank.printAllAccounts()
  }
}
