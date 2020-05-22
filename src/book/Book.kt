package book

open class Book(val title: String, val author: String) {
    private var currentPage = 0
    open fun readPage() { currentPage++ }
}

class EBook(title: String, author: String, var format: String = "text"): Book(title, author)
{
    var words = 0
    override fun readPage() {  words += 250 }
}