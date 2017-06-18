package marketblastapp

class Conversation {
	String conversationType;
	String conversationMemo;
	Date conversationDate;
	String conversationSubject;
	static belongsTo = [people : People, user : User];
	
	String toString(){
		return conversationType+" - "+conversationSubject
	}
	static mapping = {
		id column: 'conversationID'
		version false
	}
	static constraints = {
		conversationType(nullable:true)
		conversationMemo(nullable:true)
		conversationDate(nullable:true)
		conversationSubject(nullable:true)
	}
}
