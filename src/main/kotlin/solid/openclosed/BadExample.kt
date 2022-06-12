package solid.openclosed

import java.util.*

data class Rectangle(
    val height: Int,
    val width: Int
)

data class Square(
    val length: Int
)

data class Circle(
    val radius: Int
)

class AreaFactory(
    private val shape: Any
) {
    fun getArea(): Double {
            return if (shape is Square) {
                (shape.length * shape.length).toDouble()
            } else if (shape is Rectangle) {
                (shape.height * shape.width).toDouble()
            } else if (shape is Circle) {
                (shape.radius * shape.radius) * Math.PI
            } else {
                throw SomethingHasGoneWrong("")
            }
        }
    }

class SomethingHasGoneWrong(message: String) : Throwable(message)