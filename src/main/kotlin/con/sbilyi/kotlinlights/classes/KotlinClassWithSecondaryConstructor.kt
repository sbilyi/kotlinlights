package con.sbilyi.kotlinlights.classes

class KotlinClassWithSecondaryConstructor(val bookTitle: String) {
    lateinit var author: String
    constructor(message: String, author: String) : this(message) {
        this.author = author
    }

}
