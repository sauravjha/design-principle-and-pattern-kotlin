package solid.singlereposnsiblity

import mu.KotlinLogging
import java.sql.Connection

private val logger = KotlinLogging.logger {}
/*
    Bad example that violates the single responsibility principle
*/

class UserWithMultipleResponsibility(
    private val username: String,
    private val password: String,
    private val database: Database
) {
    fun save() {
        database.save(username, password)
        logger.info("Successfully update the user")
    }
}

class Database(private val databaseConnection: Connection) {
    fun save(username: String, password: String) {
        databaseConnection.prepareStatement("UPDATE ........")
        databaseConnection.close()
    }
}
