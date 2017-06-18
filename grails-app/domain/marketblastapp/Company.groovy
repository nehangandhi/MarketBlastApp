package marketblastapp

class Company {
	String companyCIQID;
	String companyTicker;
	String companyName;
	String companyShortName;
	String companyIndustry;
	String companyNotes;
	Date companyFollowUpDate;
	Double companyRevenues;
	Double companyEnterpriseValue;
	Integer companyEmployeeCount;
	String companyAlternateName;
	String companyDescription;
	Boolean companyDoNotEmail;
	Boolean companyEstablishedRelation;
	Integer companyUserID;
	Integer companyTier;
	Date companyUpdateDate;
	//Address address;
	//Website website;
	//People people;
	static hasMany = [addresses : Address, websites : Website, people : People, categories : Category, emailCampaign : EmailCampaign]
	// addresses : Address, 
	// [address : Address, website : Website]
	
	String toString(){
		return companyName
	 }
	static mapping = {
		id column: 'companyID'
		version false
	}
	static constraints = {
		companyCIQID(unique: true)
		companyTicker(unique: true)
		companyName(unique: true)
		companyShortName(unique: true)
		companyNotes(nullable: true)
		companyFollowUpDate(nullable: true)
		companyRevenues(nullable: true)
		companyEnterpriseValue(nullable: true)
		companyEmployeeCount(nullable: true)
		companyAlternateName(nullable: true)
		companyDescription(nullable: true)
		companyDoNotEmail(nullable: true)
		companyEstablishedRelation(nullable: true)
		companyUserID(nullable: true)
		companyTier(nullable: true)
		companyUpdateDate(nullable: true)
	}
}
