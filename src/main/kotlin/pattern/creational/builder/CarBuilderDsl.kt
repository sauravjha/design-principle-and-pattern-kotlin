package pattern.creational.builder

/*
    https://stackoverflow.com/questions/36140791/how-to-implement-builder-pattern-in-kotlin
    https://asvid.github.io/kotlin-builder-pattern
 */

class Car(
    val model: String?,
    val year: Int,
    val required: String
) {
    private constructor(builder: Builder): this(
        builder.model,
        builder.year,
        builder.required
    )
    companion object {
        inline fun build(required: String, block: Car.Builder.() -> Unit) = Builder(required).apply(block).build()
    }
    class Builder(
        val required: String
    ){
        var model: String? = null
        var year: Int = 0

        fun build() = Car(this)
    }
}

fun main() {
    val car = Car.Builder("required").apply {
        model = "Sedan"
        year = 2022
    }

    val car2 = Car.build(required = "requiredValue") {
        model = "SUV"
        year = 2024
    }
    println(car.model)

    println(car2.model)

}