package tech.oleks.eve

class Invmarketgroup {

	Integer parentgroupid
	String marketgroupname
	String description
	Integer iconid
	Short hastypes

	static mapping = {
		id column: "marketgroupid", generator: "assigned"
		version false
	}

	static constraints = {
		parentgroupid nullable: true
		marketgroupname nullable: true, maxSize: 100
		description nullable: true, maxSize: 3000
		iconid nullable: true
		hastypes nullable: true
	}
}
