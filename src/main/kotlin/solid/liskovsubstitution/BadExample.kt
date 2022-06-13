package solid.liskovsubstitution

import java.math.BigDecimal

abstract class Account(open var amount: BigDecimal) {
    fun deposit(amount: BigDecimal) {
        this.amount+= amount
    }
    open fun withDraw(amount : BigDecimal) {
        this.amount-=amount
    }
}

class SavingAccount(override var amount: BigDecimal): Account(amount)

class FixDepositAccount(override var amount: BigDecimal): Account(amount) {
    override fun withDraw(amount : BigDecimal) {
        throw UnsupportedTransaction("This transaction is not valid for FixDepositAccount")
    }
}

class BankingService(private val account: Account) {
    /*
        This will explode when FixDepositAccount calls this function
     */
    fun withDrawOperation(amount: BigDecimal) {
        account.withDraw(amount)
    }
}

class UnsupportedTransaction(message: String) : Throwable(message)
