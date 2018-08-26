package tech.oleks.eve

import org.apache.commons.lang.builder.EqualsBuilder
import org.apache.commons.lang.builder.HashCodeBuilder

class Dgmtypeattribute implements Serializable {

	Long typeid
	Short attributeid
	Integer valueint
	Double valuefloat
	Invtype invtype

	int hashCode() {
		def builder = new HashCodeBuilder()
		builder.append typeid
		builder.append attributeid
		builder.toHashCode()
	}

	boolean equals(other) {
		if (other == null) return false
		def builder = new EqualsBuilder()
		builder.append typeid, other.typeid
		builder.append attributeid, other.attributeid
		builder.isEquals()
	}

	static belongsTo = [Invtype]

	static mapping = {
		id composite: ["typeid", "attributeid"]
		version false
	}

	static constraints = {
		valueint nullable: true
		valuefloat nullable: true, scale: 17
	}
}
