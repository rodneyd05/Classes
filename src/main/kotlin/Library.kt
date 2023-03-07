class Library(private val list: MutableList<LibraryBook>) {

    fun addBook(title: String,
                author: String,
                publicationDate: Int,
                status: BookStatus){

        val book = Book(title, author, publicationDate)
        val libraryBook = LibraryBook(book, status)
        list.add(libraryBook)
        println("Book added successfully")
    }

    fun removeBook(title: String){
        var indexToDelete: Int? = null
        var counter = 0
        for (i in list) {
            counter++
            if (i.book.title == title) {
                indexToDelete = list.indexOf(i)
                break
            }
        }

        if (counter == list.size+1) {
            println("Book title not found")
        } else {
            list.removeAt(indexToDelete!!)
            println("Book successfully removed")
        }
    }

    fun displayBooks(){
        list.forEach { println("Title: ${it.book.title}, Author: ${it.book.author}, Publication Date: ${it.book.publicationDate}, Status: ${it.status}") }
    }
}