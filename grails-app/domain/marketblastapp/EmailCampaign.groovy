package marketblastapp

class EmailCampaign {
	String campaignName;
	String campaignDesc;
	Date createDate;
	static belongsTo = Company;
	static hasMany = [companies : Company]
	
	String toString(){
		return campaignName
	}
	static mapping = {
		id column: 'campaignID'
		version false
	}
	static constraints = {
		campaignName(nullable:true)
		campaignDesc(nullable:true)
		createDate(nullable:true)
	}
}
