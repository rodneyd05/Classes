class LibraryLoan(private val list: MutableList<LibraryBook>, private val list2: MutableList<Loan>) {

    fun createLoan(title: String,
                   listOfBorrower: MutableList<Borrower>,
                   libraryCardNumber: Int,
                   name: String,
                   phone: Int,
                   dueDate: Int,
                   returnDate: Int){

        var counter = 0

        for (i in list) {
            counter++

            if (i.book.title == title) {
                if (i.status == BookStatus.ON_LOAN) {
                    println("Sorry the book is on loan")
                } else {
                    val borrower = Borrower(libraryCardNumber, name, phone)
                    listOfBorrower.add(borrower)
                    list2.add(Loan(i.book, borrower, dueDate, returnDate))
                    i.status = BookStatus.ON_LOAN
                    println("Loan Successful")
                    break
                }
            }
            if (counter == list.size) {
                println("Book title not found")
            }
        }
    }

    fun displayLoans(){
        list2.forEach { println(it.getLoanDetails()) }
    }
}

val listOfLoans = mutableListOf<Loan>()