package con.sbilyi.kotlinlights.classes


import org.junit.Assert
import org.junit.Test

class ClassTest {

    val bookTitle = "Clean Code"
    val author = "Uncle Bob"

    val kotlinClassWithPrimaryConstructorByDefinition = KotlinClassWithPrimaryConstructorByDefinition(bookTitle)
    val kotlinClassWithSecondaryConstructor = KotlinClassWithSecondaryConstructor(bookTitle, author)

    @Test
    fun `primary constructor could initialize field with by definition`() {
        Assert.assertEquals("Message should be initialized by primary constructor", bookTitle, kotlinClassWithPrimaryConstructorByDefinition.bookTitle)
    }

    @Test
    fun `secondary constructor should call primary constructor`() {
        Assert.assertEquals("Message should be initialized by call of primary constructor from secondary", bookTitle, kotlinClassWithSecondaryConstructor.bookTitle)
    }

    @Test
    fun `secondary constructor should initialize additional fields`() {
        Assert.assertEquals(author, kotlinClassWithSecondaryConstructor.author)
    }

    @Test(expected = UninitializedPropertyAccessException::class)
    fun `exception should be thrown if no lateinit fields has been initialized by constructor call`() {
        Assert.assertEquals(author, KotlinClassWithSecondaryConstructor(bookTitle).author)
    }
}