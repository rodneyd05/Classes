fun main() {

    //Add Existing Books to Library
    bookList.forEach { listOfLibraryBook.add(LibraryBook(it, BookStatus.AVAILABLE)) }

    println("Welcome to Library Management System")

    while (true) {
        println("\nChoose from the following:")
        println("[1] Add a Book")
        println("[2] Remove a Book")
        println("[3] Display All Books")
        println("[4] Create a Loan")
        println("[5] Display All Loans")
        println("[6] Display Borrowers")
        println("[7] Exit")

        try {
            when (readLine()!!.toInt()) {
                MainMenuOption.ADD_BOOK.optionNumber -> addBook()
                MainMenuOption.REMOVE_BOOK.optionNumber -> removeBook()
                MainMenuOption.DISPLAY_ALL_BOOKS.optionNumber -> displayBook()
                MainMenuOption.CREATE_LOAN.optionNumber -> createLoan()
                MainMenuOption.DISPLAY_ALL_LOANS.optionNumber-> displayLoan()
                MainMenuOption.DISPLAY_BORROWERS.optionNumber-> printBorrowers(listOfBorrowers)
                MainMenuOption.EXIT.optionNumber -> break
                else -> println("Invalid keyword")
            }
        } catch (e: NumberFormatException) {
            println("Invalid keyword")
        }
    }
}

enum class BookStatus {
    AVAILABLE,
    ON_LOAN
}

enum class MainMenuOption(val optionNumber: Int) {
    ADD_BOOK(1),
    REMOVE_BOOK(2),
    DISPLAY_ALL_BOOKS(3),
    CREATE_LOAN(4),
    DISPLAY_ALL_LOANS(5),
    DISPLAY_BORROWERS(6),
    EXIT(7)
}

fun addBook() {
    println("Enter book title:")
    val title = readLine().toString()
    println("Enter book author:")
    val author = readLine().toString()
    println("Enter Publication Date:")
    val publicationDate = readLine()!!.toInt()
    Library(listOfLibraryBook).addBook(title, author, publicationDate, BookStatus.AVAILABLE)

}

fun removeBook() {
    println("Enter book title:")
    val title = readLine().toString()

    Library(listOfLibraryBook).removeBook(title)
}

fun displayBook() {
    Library(listOfLibraryBook).displayBooks()
}

fun createLoan() {
    println("Enter book title:")
    val title = readLine().toString()
    println("Borrower's Details:")
    println("Enter Library Card Number:")
    val libraryCardNumber = readLine()!!.toInt()
    println("Enter name:")
    val name = readLine().toString()
    println("Enter Phone Number:")
    val phone = readLine()!!.toInt()
    println("Enter Due Date:")
    val dueDate = readLine()!!.toInt()
    println("Enter Return Date:")
    val returnDate = readLine()!!.toInt()
    LibraryLoan(listOfLibraryBook, listOfLoans).createLoan(title, listOfBorrowers, libraryCardNumber, name, phone, dueDate, returnDate)
}

fun displayLoan() {

    LibraryLoan(listOfLibraryBook, listOfLoans).displayLoans()
}

fun printBorrowers(borrowers: List<Borrower>) {

    borrowers.forEach { println(it.getDetails()) }
}



