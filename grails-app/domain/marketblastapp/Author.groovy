package marketblastapp

class Author {
	String authorName
	Long author_ID
	Book book
	
	static mapping = {
		id column: 'author_ID'
		version false
	}
	
    static constraints = {
    }
}
