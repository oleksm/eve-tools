package tech.oleks.eve

class Invname {

	Long itemid
	String itemname

	static belongsTo = [invitem: Invitem]

	static mapping = {
		id name: "itemid"
		invitem column: "itemid", insertable: false, updatable: false
		version false
	}

	static constraints = {
		itemname nullable: false, maxSize: 200
	}

	@Override
	String toString() {
		return itemname
	}
}
