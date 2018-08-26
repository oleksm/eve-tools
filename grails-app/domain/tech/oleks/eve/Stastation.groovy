package tech.oleks.eve

class Stastation {

	Long stationid
	Double security
	Double dockingcostpervolume
	Double maxshipvolumedockable
	Integer officerentalcost
	Short operationid
	Integer stationtypeid
	Integer corporationid
	Long solarsystemid
	Integer constellationid
	Integer regionid
	String stationname
	Double x
	Double y
	Double z
	Double reprocessingefficiency
	Double reprocessingstationstake
	Short reprocessinghangarflag

	static mapping = {
		id name: "stationid", generator: "assigned"
		version false
	}

	static constraints = {
		security nullable: true, scale: 17
		dockingcostpervolume nullable: true, scale: 17
		maxshipvolumedockable nullable: true, scale: 17
		officerentalcost nullable: true
		operationid nullable: true
		stationtypeid nullable: true
		corporationid nullable: true
		solarsystemid nullable: true
		constellationid nullable: true
		regionid nullable: true
		stationname nullable: false, maxSize: 100
		x nullable: true, scale: 17
		y nullable: true, scale: 17
		z nullable: true, scale: 17
		reprocessingefficiency nullable: true, scale: 17
		reprocessingstationstake nullable: true, scale: 17
		reprocessinghangarflag nullable: true
	}

	@Override
	String toString() {
		return stationname
	}
}
