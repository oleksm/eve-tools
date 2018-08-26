package tech.oleks.eve

import org.apache.commons.lang.builder.EqualsBuilder
import org.apache.commons.lang.builder.HashCodeBuilder

class Dgmtypeeffect implements Serializable {

	Long typeid
	Long effectid
	Boolean isdefault
	Invtype invtype

	int hashCode() {
		def builder = new HashCodeBuilder()
		builder.append typeid
		builder.append effectid
		builder.append invtype.typeid
		builder.toHashCode()
	}

	boolean equals(other) {
		if (other == null) return false
		def builder = new EqualsBuilder()
		builder.append typeid, other.typeid
		builder.append effectid, other.effectid
		builder.append invtype, other.invtype
		builder.isEquals()
	}

	static belongsTo = [Invtype]

	static mapping = {
		id composite: ["typeid", "effectid"]
		version false
	}

	static constraints = {
		isdefault nullable: true
	}
}
