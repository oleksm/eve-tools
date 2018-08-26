package tech.oleks.eve

class Invposition {

	Long itemid
	Double x
	Double y
	Double z
	Float yaw
	Float pitch
	Float roll

	static belongsTo = [invitem: Invitem]

	static mapping = {
		id name: "itemid"
		invitem column: "itemid", insertable: false, updatable: false
		version false
	}

	static constraints = {
		x scale: 17
		y scale: 17
		z scale: 17
		yaw nullable: true, scale: 8
		pitch nullable: true, scale: 8
		roll nullable: true, scale: 8
	}
}
