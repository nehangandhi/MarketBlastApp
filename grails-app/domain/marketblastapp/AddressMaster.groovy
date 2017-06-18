package marketblastapp

class AddressMaster {
	//private Long Address_ID;
	String address;
	String city;
	String state;
	String zip;
	String country;
	Long people_ID;
	Long company_ID;

	static mapping = {
		table 'AddressMaster'
		id column: 'address_ID'
		version false
	}
    static constraints = {
    }
}
