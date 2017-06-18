package marketblastapp

class People {
	String peopleFirstName;
	String peopleShortName;
	String peopleLastName;
	String peopleTitle;
	String peopleOfficePhone;
	String peopleCellPhone;
	String peopleOtherPhone;
	Boolean peopleEstablishedRelation;
	Boolean peopleDoNotEmail;
	Boolean peopleSubscribeNewsletter;
	String peopleNotes;
	//Integer peopleUserID;
	static belongsTo = [company : Company];
	//PeopleEmail peopleEmail;
	//Conversation conversation;
	
	static hasMany = [peopleEmail : PeopleEmail, conversation : Conversation]
		
    String toString(){
		return peopleFirstName+", "+peopleLastName+", "+peopleTitle
	}
	static mapping = {
		id column: 'peopleID'
		version false
	}
	static constraints = {
		peopleFirstName(blank:false)
		peopleShortName(nullable:true)
    	peopleLastName(blank: false)
		peopleTitle(nullable:true)
		peopleOfficePhone(nullable:true, phoneNumber: true)
		peopleCellPhone(nullable:true, phoneNumber: true)
		peopleOtherPhone(nullable:true, phoneNumber: true)
		peopleEstablishedRelation(nullable:true)
		peopleDoNotEmail(nullable:true)
		peopleSubscribeNewsletter(nullable:true)
		peopleNotes(nullable:true)
	}
}
