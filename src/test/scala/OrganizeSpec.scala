import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.should.Matchers.convertToAnyShouldWrapper

case class OrganizeSpec() extends AnyFlatSpec {

  "An organize" should "filter duplicates" in {
    val author = Author("Jan", "Kowalski")
    val author2 = Author("Jaroslaw", "Zbawiciel")
    val firstBook = Book(author, "Zoologia")
    val secondBook = Book(author2, "Programowanie")

    val input = Seq(firstBook, firstBook, secondBook)

    val result = Organize.organize(input)
    result.size shouldBe 2
  }

  "An organize" should "produce map with correct hash key" in {
    val author = Author("Jan", "Kowalski")
    val author2 = Author("Jan", "Kowalski")
    val firstBook = Book(author, "Zoologia")
    val secondBook = Book(author2, "Programowanie")

    val input = Seq(firstBook, firstBook, secondBook)

    val result = Organize.organize(input)
    result.size shouldBe 1
    result.head._2.size shouldBe 2
  }
}
