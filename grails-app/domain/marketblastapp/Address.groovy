package marketblastapp

class Address {
	String address;
	String city;
	String state;
	String zip;
	String country;
	static belongsTo = [company : Company];
	
	String toString(){
		return address+", "+city+", "+state+", "+zip+", "+country
	 }
	static mapping = {
		id column: 'address_ID'
		version false
	}
	
	static constraints = {
		address(nullable: true, blank: false)
		city(nullable: true, blank: true)
		state(nullable: true, blank: true)
		zip(blank: false)
		country(nullable:true, blank: true)
	}
}
