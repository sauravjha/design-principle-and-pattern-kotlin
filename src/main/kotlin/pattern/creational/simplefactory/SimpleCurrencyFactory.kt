package pattern.creational.simplefactory

interface Currency{
    val code: String
}

data class USACurrency(
    override val code: String = "USA"
): Currency

data class Euro(
    override val code: String = "EUR"
): Currency

data class Nepal(
    override val code: String = "NEP"
): Currency

enum class Country {
    USA, Nepal, Spain, UK, Greece
}

fun simpleCurrencyFactory(country: String): Currency? {
    return when(country) {
        Country.USA.name -> USACurrency()
        Country.Spain.name, Country.UK.name, Country.Greece.name -> Euro()
        Country.Nepal.name -> Nepal()
        else -> null
    }
}

fun main() {
    val code = simpleCurrencyFactory("Nepal")?.code
    println(code)
}