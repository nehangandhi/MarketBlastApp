package marketblastapp

class Employee {
	String empFirstName;
	String empLastName;
	String empEmailAddress;
	
	String toString(){
		return empFirstName + " , " +empLastName
	}
	static mapping = {
		id column: 'empID'
		version false
	}
	static constraints = {
		empFirstName(nullable:true)
		empLastName(nullable:true)
		empEmailAddress(email:true, nullable:true)
	}
}
