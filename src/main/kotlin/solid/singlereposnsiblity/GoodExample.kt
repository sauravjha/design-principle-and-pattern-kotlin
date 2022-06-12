package solid.singlereposnsiblity

import java.sql.Connection

/*
    The Single responsibility Principle states that every class should have one and
    only one responsibility. In other words, If there is a need to change the class for
    more than one reason then that defies the single responsibility principle.
 */

/*
    Data class that is used to handle the user
 */
data class User(
    val userName: String,
    val password: String
)

/*
    Class responsible to save user to the database
 */
class DatabaseUtil(val databaseConnection: Connection) {
    fun saveUser(user: User) {
        // save the user
    }
}

/*
    Class to handle the creation of the user and calling the databaseUtil to save the user
 */
data class UserHandler(
  val databaseUtil: DatabaseUtil
) {
    fun handleUser(userName: String, password: String) {
        val user = User(userName, password)
        databaseUtil.saveUser(user)
    }
}
