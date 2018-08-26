package tech.oleks.eve

class Invflag {

	Long flagid
	String flagname
	String flagtext
	Integer orderid

	static mapping = {
		id name: "flagid", generator: "assigned"
		version false
	}

	static constraints = {
		flagname nullable: true, maxSize: 200
		flagtext nullable: true, maxSize: 100
		orderid nullable: true
	}
}
