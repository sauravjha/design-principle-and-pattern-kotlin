package solid.interfacesegregation
/*
This principle states that once an interface becomes too fat,
it needs to be split into smaller interfaces so that client of the interface
 will only know about the methods that pertain to them.
 */

interface BasicAnimalCharacteristic{
    fun eats(): Feeds
}

interface AquaticAnimal {
    fun swimDepth(): Double
}

interface Terrestrial {
    fun sleepingTime(): Double
}

class Lion: BasicAnimalCharacteristic, Terrestrial {
    override fun eats(): Feeds {
        return Feeds.Carnivores
    }

    override fun sleepingTime(): Double {
        return 20.0
    }
}

class Whale: BasicAnimalCharacteristic, AquaticAnimal {
    override fun eats(): Feeds {
        return Feeds.Carnivores
    }

    override fun swimDepth(): Double {
       return 2000.0
    }
}