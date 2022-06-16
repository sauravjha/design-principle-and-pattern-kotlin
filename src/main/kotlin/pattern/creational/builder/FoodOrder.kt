package pattern.creational.builder

/*
    Ref: https://www.baeldung.com/kotlin/builder-pattern

    The Builder pattern is the one that people often use but rarely create on their own.

    It’s great to handle the building of objects that may contain a lot of parameters and
     when we want to make the object immutable once we’re done constructing it.
*/
class FoodOrder private constructor(
    val bread: String?,
    val condiments: String?,
    val meat: String?,
    val fish: String?,
) {
    data class Builder(
        var bread: String? = null,
        var condiments: String? = null,
        var meat: String? = null,
        var fish: String? = null,
    ) {
        fun bread(bread: String?) = apply {
            this.bread = bread
        }

        fun condiments(condiments: String?) = apply {
            this.condiments = condiments
        }

        fun meat(meat: String?) = apply {
            this.meat = meat
        }

        fun fish(fish: String?) = apply {
            this.fish = fish
        }

        fun build() = FoodOrder(
            bread = bread,
            condiments = condiments,
            meat = meat,
            fish = fish,
        )
    }
}

fun main() {

    val foodOrder = FoodOrder.Builder()
        .bread("brown")
        .meat("chicken")
        .fish("salmon")
        .condiments("oil")
        .build()

    println(foodOrder.bread)

}