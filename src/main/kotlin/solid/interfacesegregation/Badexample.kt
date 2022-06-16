package solid.interfacesegregation

enum class Feeds {
    Herbivores,
    Carnivores,
    Omnivores
}

abstract class Animal {
    abstract fun eats(): Feeds
    abstract fun sleepingTime(): Double
    abstract fun flyingHeight(): Double
    abstract fun swimDepth(): Double
}

class Tiger: Animal() {
    override fun eats(): Feeds {
        return Feeds.Carnivores
    }

    override fun sleepingTime(): Double {
        return 15.8
    }

    override fun flyingHeight(): Double {
        throw InvalidFeature("Tiger cannot fly")
    }

    override fun swimDepth(): Double {
        throw InvalidFeature("Tiger cannot swim")
    }

}

class Shark: Animal() {
    override fun eats(): Feeds {
        return Feeds.Carnivores
    }

    override fun sleepingTime(): Double {
        throw InvalidFeature("Shark do not sleep")
    }

    override fun flyingHeight(): Double {
        throw InvalidFeature("Shark cannot fly")
    }

    override fun swimDepth(): Double {
        return 1200.0
    }
}

class Parrot: Animal() {
    override fun eats(): Feeds {
        return Feeds.Omnivores
    }

    override fun sleepingTime(): Double {
       return 12.0
    }

    override fun flyingHeight(): Double {
        return 914.4
    }

    override fun swimDepth(): Double {
        throw InvalidFeature("Parrot cannot swim")
    }
}
class InvalidFeature(override val message: String?) : Throwable(message)
