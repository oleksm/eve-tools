package tech.oleks.eve

import org.apache.commons.lang.builder.EqualsBuilder
import org.apache.commons.lang.builder.HashCodeBuilder

class Marketlog implements Serializable {

	Float price
	Long volremaining
	Long range
	Long orderid
	Long volentered
	Integer minvolume
	Boolean bid
	Date issuedate
	Date lastupdated
	Integer duration
	Long stationid
	Long regionid
	Long solarsystemid
	Integer jumps
	Invtype invtype

	int hashCode() {
		def builder = new HashCodeBuilder()
		builder.append invtype?.typeid
		builder.append orderid
		builder.toHashCode()
	}

	boolean equals(other) {
		if (other == null) return false
		def builder = new EqualsBuilder()
		builder.append invtype?.typeid, other.invtype?.typeid
		builder.append orderid, other.orderid
		builder.isEquals()
	}

	static mapping = {
		id composite: ["invtype", "orderid"]
		invtype column: "typeid"
		version false
	}

	static constraints = {
		price scale: 8
	}

	@Override
	String toString() {
		return invtype?.typename
	}
}
