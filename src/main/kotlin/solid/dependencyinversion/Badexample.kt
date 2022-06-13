package solid.dependencyinversion

class OracleDatabase {
    fun save() {
        println("OracleDatabase.... save")
    }
}

class Recorder(
    val database: OracleDatabase
) {
    fun save() {
        database.save()
    }
}

fun main() {
    Recorder(OracleDatabase()).save()
    /*
    Everything works fine, but this code violates the dependency inversion principle because our high-level module
    Recorder concretely depends on the low-level module OracleDatabase.
     */
}

