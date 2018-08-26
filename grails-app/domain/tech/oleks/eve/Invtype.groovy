package tech.oleks.eve

class Invtype {

	Long typeid
	Integer groupid
	String typename
	String description
	Double mass
	Double volume
	Double packagedvolume
	Double capacity
	Integer portionsize
	Integer factionid
	Short raceid
	Double baseprice
	Short published
	Integer marketgroupid
	Integer graphicid
	Double radius
	Integer iconid
	Integer soundid
	String soffactionname
	Integer sofmaterialsetid

	static mapping = {
		id name: "typeid", generator: "assigned"
		version false
	}

	static constraints = {
		groupid nullable: false
		typename nullable: false, maxSize: 500
		description nullable: true
		mass nullable: true, scale: 17
		volume nullable: true, scale: 17
		packagedvolume nullable: true, scale: 17
		capacity nullable: true, scale: 17
		portionsize nullable: true
		factionid nullable: true
		raceid nullable: true
		baseprice nullable: true, scale: 17
		published nullable: true
		marketgroupid nullable: true
		graphicid nullable: true
		radius nullable: true, scale: 17
		iconid nullable: true
		soundid nullable: true
		soffactionname nullable: true, maxSize: 100
		sofmaterialsetid nullable: true
	}

	@Override
	String toString() {
		return typename
	}
}
