package pattern.creational.builder

enum class Section {
    A, B, C, D
}

data class Student(
    val id: Int,
    val name: String,
    val roll: Int,
    val section: Section
)

/*
    Not sure if this qualifies of the builder patter but has been very useful
    when you want to build the object that is populated for testing.
 */

class StudentBuilder(
    var id: Int = 1,
    var name: String = "Saurav",
    var roll: Int = 438,
    var section: Section = Section.B
) {
    fun withId(id: Int) = apply {
        this.id = id
    }

    fun withName(name: String) = apply {
        this.name = name
    }

    fun withRoll(roll: Int) = apply {
        this.roll = roll
    }

    fun withSection(section: Section) = apply {
        this.section = section
    }

    fun build() = Student(
        id = id,
        name = name,
        roll = roll,
        section = section,
    )
}

fun main() {
    /*
    I have bot seen much use case of this pattern in kotlin,
    I have used this pattern mostly in the test to build the test object
     */
    val student = StudentBuilder().build()
    // This build the student with the default parameter
    val student2 = StudentBuilder().withName("Jha").build()

    /*
    Instead of using the builder you could use the copy
     */
    val student3 = student.copy(
        name = "jha"
    )
    /*
    Here student2 and student3 have same value,
    Benefit I see here is it is more readable, when the
    field value which has multiple layer for which field had be changed
    It could be made less verbose with builder patter.
     */
}