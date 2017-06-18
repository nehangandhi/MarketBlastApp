package marketblastapp

class EmailCommunication {
	String ecmSenderAddress;
	String ecmReceiverAddress;
	String ecmCC;
	Date ecmDate;
	String ecmUniqueID;
	String ecmDirection;
	String ecmSubject;
	String ecmBody;
	String ecmFileName;
	String ecmSaveLocation;
	//static belongsTo = Company;
	//static hasMany = [companies : Company]
	
	String toString(){
		return ecmSubject + " - " + ecmSenderAddress+" , "+ ecmReceiverAddress 
	}
	static mapping = {
		id column: 'ecmID'
		version false
	}
	static constraints = {
		ecmSenderAddress(email:true)
		ecmReceiverAddress(email:true)
		ecmCC(email:true, nullable:true)
		ecmDate(nullable:true)
		ecmUniqueID(nullable:true, unique: true)
		ecmDirection(nullable:true)
		ecmSubject(nullable:true)
		ecmBody(nullable:true)
		ecmFileName(nullable:true)
		ecmSaveLocation(nullable:true)
	}
}
