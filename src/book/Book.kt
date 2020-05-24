package book

import java.time.Year

const val MAXTOBORROW = 10

object BaseUrl{
    const val BASE_URL = "/shelf/"
}

open class Book(val title: String, val author: String, val year: Year) {
    private var currentPage = 0
    companion object BaseUrl2{
        const val BASE_URL = "/shelf2/"
    }

    open fun readPage() { currentPage++ }
    fun getTitleAndAuthor(): Pair<String, String>{
        return title to author
    }
    fun getTitleAndAuthorAndYear(): Triple<String, String, Year>{
        return Triple(title, author, year)
    }

    fun canBorrow(borrowed: Int): Boolean{
        return (borrowed < MAXTOBORROW)
    }

    fun printUrl(){
        println("${BaseUrl.BASE_URL}$title.html")
        println("${BaseUrl2.BASE_URL}$title.html")
    }
}

class EBook(title: String, author: String, year: Year, var format: String = "text"): Book(title, author, year)
{
    var words = 0
    override fun readPage() {  words += 250 }
}

fun main(){
    val book = Book("programer", "haokai", Year.now())
    val (title, author, year) = book.getTitleAndAuthorAndYear()
    println("Here is your book $title written by $author in $year")

    val allBooks = setOf("Book1", "Book2", "Hamlet")
    val library = mapOf("Shakespeare" to allBooks)
    println(library.any{it.value.contains("Hamlet")})

    val moreBooks = mutableMapOf("haokai" to "Programmer")
    moreBooks.getOrPut("jiwenjuan", {"Lady"})
    println(moreBooks)

    book.printUrl()
}