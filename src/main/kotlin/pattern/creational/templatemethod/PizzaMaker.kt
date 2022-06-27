package pattern.creational.templatemethod

abstract class PizzaMaker {
    enum class Size {
        SMALL,
        MEDIUM,
        LARGE;
    }

    fun make(size: Size) {
        makeDough(size)
        appleSauce()
        addCheese()
        addTopping()
        bake()
    }

    private fun makeDough(size: Size) {
        when (size) {
            Size.SMALL -> println("Making 30cm dough")
            Size.MEDIUM -> println("Making 60cm dough")
            Size.LARGE ->  println("Making 120cm dough")
        }
    }

    abstract fun addTopping()

    private fun addCheese() {
        println("Add cheese topping")
    }

    abstract fun appleSauce()

    private fun bake() {
        println("Baking for 20 min")
    }

}

class Pepperoni: PizzaMaker() {
    override fun addTopping() {
        println("adding salami")
        println("adding onion")
    }

    override fun appleSauce() {
        println("applying tomato sauce")
    }
}

class Chicken: PizzaMaker() {
    override fun addTopping() {
        println("adding chicken")
        println("adding onion")
    }

    override fun appleSauce() {
        println("applying chilli tomato sauce")
    }
}

class PizzaMakerFactory {
    companion object {
        fun createPizza(type: String): PizzaMaker {
            return when(type) {
                "chicken" -> Chicken()
                "Pepperoni" -> Pepperoni()
                else -> throw IllegalArgumentException()
            }
        }
    }
}


fun main() {

    PizzaMakerFactory.createPizza("chicken")
        .make(PizzaMaker.Size.SMALL)

}

