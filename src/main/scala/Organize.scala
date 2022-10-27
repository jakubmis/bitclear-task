object Organize {
  def organize(books: Seq[Book]): Map[Author, Seq[Book]] = {
    books.distinct.groupBy(_.author)
  }
}
