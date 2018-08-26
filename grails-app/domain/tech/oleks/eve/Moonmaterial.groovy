package tech.oleks.eve

import org.apache.commons.lang.builder.EqualsBuilder
import org.apache.commons.lang.builder.HashCodeBuilder

class Moonmaterial implements Serializable {

	Float quantity
	Long planetid
	Invitem moon
	Invtype oretype
	Mapsolarsystem solarsystem

	static mapping = {
		id composite: ["oretype", "moon"]
		moon column: "moonid"
		oretype column: "oretypeid"
		solarsystem column: "solarsystemid"
		version false
	}

	int hashCode() {
		def builder = new HashCodeBuilder()
		builder.append oretype?.typeid
		builder.append moon?.itemid
		builder.toHashCode()
	}

	boolean equals(other) {
		if (other == null) return false
		def builder = new EqualsBuilder()
		builder.append oretype?.typeid, other.oretype?.typeid
		builder.append moon?.itemid, other.moon?.itemid
		builder.isEquals()
	}

	static constraints = {
		quantity scale: 8
	}

	@Override
	String toString() {
		return oretype?.typename
	}
}
