package marketblastapp

class Book {
	String bookName
	Long book_ID
	static belongsTo = Author
	
	static mapping = {
		id column: 'book_ID'
		version false
	}
    static constraints = {
    }
}
