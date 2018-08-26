package tech.oleks.eve

class Mapsolarsystem {

	Long solarsystemid
	String solarsystemname
	Integer constellationid
	Float x
	Float y
	Float z
	Float xminf
	Float xmaxf
	Float yminf
	Float ymaxf
	Float zminf
	Float zmaxf
	Float luminosity
	Short border
	Short corridor
	Short fringe
	Short hub
	Short international
	Short regional
	Float security
	Integer factionid
	Float radius
	Integer suntypeid
	String securityclass
	Integer solarsystemnameid
	String visualeffect
	Integer descriptionid
	Mapregion mapregion

	static hasMany = [moonmaterials: Moonmaterial]
	static belongsTo = [Mapregion]

	static mapping = {
		id name: "solarsystemid", generator: "assigned"
		mapregion column: "regionid"
		version false
	}

	static constraints = {
		solarsystemname nullable: false, maxSize: 100
		constellationid nullable: true
		x nullable: true, scale: 8
		y nullable: true, scale: 8
		z nullable: true, scale: 8
		xminf nullable: true, scale: 8
		xmaxf nullable: true, scale: 8
		yminf nullable: true, scale: 8
		ymaxf nullable: true, scale: 8
		zminf nullable: true, scale: 8
		zmaxf nullable: true, scale: 8
		luminosity nullable: true, scale: 8
		border nullable: true
		corridor nullable: true
		fringe nullable: true
		hub nullable: true
		international nullable: true
		regional nullable: true
		security nullable: true, scale: 8
		factionid nullable: true
		radius nullable: true, scale: 8
		suntypeid nullable: true
		securityclass nullable: true, maxSize: 2
		solarsystemnameid nullable: true
		visualeffect nullable: true, maxSize: 50
		descriptionid nullable: true
	}

	@Override
	String toString() {
		return solarsystemname
	}
}
