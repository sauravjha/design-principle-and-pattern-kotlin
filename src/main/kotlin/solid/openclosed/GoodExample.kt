package solid.openclosed

/*

    Open-Closed Principle
    This principle has two meanings.

    Open: This means that we can add new features to our classes.
    When there is a new requirement, we should be able to add new features to our class easily.
    Close: This means that the base features of the class should not be changed.

 */
interface Shape{
    fun getArea() : Double
}

class SquareShape(
    private val length: Int
): Shape {
    override fun getArea(): Double {
        return (length * length).toDouble()
    }
}

class RectangleShape(
    private val height: Int,
    private val width: Int
): Shape {
    override fun getArea(): Double {
        return (height * width).toDouble()
    }
}

class CircleShape(
    val radius: Int
): Shape {
    override fun getArea(): Double {
        return (Math.PI * radius * radius)
    }

    fun diameter(): Double {
        return (2 * radius).toDouble()
    }
}

class ShapesAreaFactory(private val shape: Shape) {
    fun getArea(): Double {
        return shape.getArea()
    }
}