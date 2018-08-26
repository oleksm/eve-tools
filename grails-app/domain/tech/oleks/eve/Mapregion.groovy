package tech.oleks.eve

class Mapregion {

	Long regionid
	String regionname
	Float x
	Float y
	Float z
	Float xminf
	Float xmaxf
	Float yminf
	Float ymaxf
	Float zminf
	Float zmaxf
	Integer factionid
	Integer nameid
	Integer descriptionid

	static hasMany = [mapsolarsystems: Mapsolarsystem]

	static mapping = {
		id name: "regionid", generator: "assigned"
		version false
	}

	static constraints = {
		regionname nullable: false, maxSize: 100
		x nullable: true, scale: 8
		y nullable: true, scale: 8
		z nullable: true, scale: 8
		xminf nullable: true, scale: 8
		xmaxf nullable: true, scale: 8
		yminf nullable: true, scale: 8
		ymaxf nullable: true, scale: 8
		zminf nullable: true, scale: 8
		zmaxf nullable: true, scale: 8
		factionid nullable: true
		nameid nullable: true
		descriptionid nullable: true
	}

	@Override
	String toString() {
		return regionname
	}
}
