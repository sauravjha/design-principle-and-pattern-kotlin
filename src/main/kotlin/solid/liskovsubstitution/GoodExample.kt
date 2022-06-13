package solid.liskovsubstitution

import java.math.BigDecimal

/*
    https://stackoverflow.com/questions/56860/what-is-an-example-of-the-liskov-substitution-principle
    https://www.baeldung.com/java-liskov-substitution-principle

    Liskov Substitution Principle
    We should be able to use subclasses instead of the parent classes which
    class they have extended, without the need to make any changes in our code.
    In simple words, the child class must be substitutable for the parent class.
    Since child classes extended from the parent classes, they inherit their behavior.
*/

abstract class BankingAccount(open var amount: BigDecimal) {
    fun deposit(amount: BigDecimal) {
        this.amount += amount
    }
}

abstract class WithDrawableAccount(override var amount: BigDecimal) : BankingAccount(amount) {
    fun withDraw(amount: BigDecimal) {
        this.amount -= amount
    }
}

class CurrentBankingAccount(override var amount: BigDecimal) : WithDrawableAccount(amount)
class SavingBankingAccount(override var amount: BigDecimal) : WithDrawableAccount(amount)
class FixDepositBankingAccount(override var amount: BigDecimal) : BankingAccount(amount)

class BankingServiceWithDrawableAccount(private val withDrawableAccount: WithDrawableAccount) {
    fun withDrawAmount(amount: BigDecimal) {
        withDrawableAccount.withDraw(amount)
    }
}

class BankingServiceDeposit(
    private val bankingAccount: BankingAccount
) {
    fun depositAmount(amount: BigDecimal) {
        bankingAccount.deposit(amount)
    }
}

fun main() {
    val fixDepositBankingAccount = FixDepositBankingAccount(BigDecimal(2.0))
    BankingServiceDeposit(fixDepositBankingAccount).depositAmount(BigDecimal(4.0))

    println(fixDepositBankingAccount.amount)

    val currentBankingAccount = CurrentBankingAccount(BigDecimal(2000.0))
    BankingServiceDeposit(currentBankingAccount).depositAmount(BigDecimal(3000.0))
    println(currentBankingAccount.amount)

    BankingServiceWithDrawableAccount(currentBankingAccount).withDrawAmount(BigDecimal(100.0))
    println(currentBankingAccount.amount)
}
