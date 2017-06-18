package marketblastapp

class PeopleEmail {
	String emailAddress;
	String emailType;
	Boolean emailBounced;
	Boolean emailConfirmed;
	static belongsTo = [people : People];
	
	String toString(){
		return emailAddress
	}
	static mapping = {
		id column: 'peopleEmailID'
		version false
	}
	static constraints = {
		emailAddress(email:true, blank: false)
		emailType(nullable:true)
		emailBounced(nullable:true)
		emailConfirmed(nullable:true)
	}
   }
