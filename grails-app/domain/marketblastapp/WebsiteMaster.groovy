package marketblastapp

class WebsiteMaster {
	String website;
	Long company_ID;
	
		static mapping = {
		table 'WebsiteMaster'
		id column: 'website_ID'
		version false
	}
    
	static constraints = {
	}
}
