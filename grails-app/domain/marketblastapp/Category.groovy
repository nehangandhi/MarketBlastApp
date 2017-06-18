package marketblastapp

class Category {
	String categoryName;
	String categoryDescription;
	Integer parentID;
	String parentName;
	static belongsTo = Company;
	static hasMany = [companies : Company]
	
	String toString(){
        return categoryName
	 }
	static mapping = {
		id column: 'categoryID'
		version false
	}
	
    static constraints = {
		categoryDescription(nullable:true, blank:true)
		parentName(blank:true)
	}
}
