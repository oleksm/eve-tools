package tech.oleks.eve

class Invitem {

	Long itemid
	Long ownerid
	Long locationid
	Integer quantity
	Invflag invflag
	Invtype invtype
	Invposition invposition
	Invname invname

	static hasOne = [invposition: Invposition, invname: Invname]

	static mapping = {
		id name: "itemid", generator: "assigned"
		invtype column: "typeid"
		invflag column: "flagid"
		version false
	}

	static constraints = {
		ownerid nullable: false
		locationid nullable: false
		quantity nullable: false
		invname nullable: false, unique: true
		invposition nullable: false, unique: true
	}

	@Override
	String toString() {
		return invname?.itemname
	}
}
