package marketblastapp

class JunkEmail {
	String junkEmailAddress;
	
	String toString(){
		return junkEmailAddress
	}
	static mapping = {
		id column: 'junkEmailID'
		version false
	}
	static constraints = {
		junkEmailAddress(email: true, nullable:true)
	}
}
