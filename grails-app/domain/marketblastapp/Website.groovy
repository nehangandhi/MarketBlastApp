package marketblastapp

class Website {
	String companyWebsite;
	static belongsTo = [company : Company];
	String toString(){
		return companyWebsite
	 }
	static mapping = {
		id column: 'websiteID'
		version false
	}
	
	static constraints = {
		companyWebsite(unique: true, url: true)
	}
}
