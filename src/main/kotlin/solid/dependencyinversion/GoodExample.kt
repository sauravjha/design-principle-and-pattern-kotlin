package solid.dependencyinversion

/*
    Dependency Inversion Principle
    This principle states that high-level modules should not depend on low-level modules.
    Both should depend on abstractions and Abstractions should not depend upon details.
    Details should depend upon abstractions.
 */

interface Database {
    fun save()
    fun update()
    fun delete()
}

class MySqlDatabase: Database{
    override fun save() {
        println("MySqlDatabase....save")
    }

    override fun update() {
        println("MySqlDatabase....update")
    }

    override fun delete() {
        println("MySqlDatabase....delete")
    }
}

class MongoDatabase: Database {
    override fun save() {
        println("MongoDatabase....save")
    }

    override fun update() {
        println("MongoDatabase....update")
    }

    override fun delete() {
        println("MongoDatabase....delete")
    }
}

class DatabaseRecorder(
    val database: Database
) {
    fun save() {
        database.save()
    }
    //
}

fun main() {
   listOf(
       DatabaseRecorder(MySqlDatabase()),
       DatabaseRecorder(MongoDatabase())
   ).forEach {
       it.save()
   }
}