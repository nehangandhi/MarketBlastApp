package marketblastapp

class Master {
    private long Address_ID;
	private String Address;
	private String City;
	private String State;
	private String Zip;
	private String Country;
	private long People_ID;
	private long Company_ID;

	public Address(){
	}
	
	public Address(long address_ID, String address, String city, String state, String zip,String country,long people_ID, long company_ID) {
		this.Address_ID = address_ID;
		this.Address = address;
		this.City = city;
		this.State = state;
		this.Zip = zip;
		this.Country = country;
		this.People_ID = people_ID;
		this.Company_ID = company_ID;
	}
	public long getAddress_ID() {
		return Address_ID;
	}
	public void setAddress_ID(long address_ID) {
		Address_ID = address_ID;
	}
	public String getAddress() {
		return Address;
	}
	public void setAddress(String address) {
		Address = address;
	}
	public String getCity() {
		return City;
	}
	public void setCity(String city) {
		City = city;
	}
	public String getState() {
		return State;
	}
	public void setState(String state) {
		State = state;
	}
	public String getZip() {
		return Zip;
	}
	public void setZip(String zip) {
		Zip = zip;
	}
	public String getCountry() {
		return Country;
	}
	public void setCountry(String country) {
		Country = country;
	}
	public long getPeople_ID() {
		return People_ID;
	}
	public void setPeople_ID(long people_ID) {
		People_ID = people_ID;
	}
	public long getCompany_ID() {
		return Company_ID;
	}
	public void setCompany_ID(long company_ID) {
		Company_ID = company_ID;
	}
    
	static mapping = {
	
	}
    static constraints = {
    }
}
