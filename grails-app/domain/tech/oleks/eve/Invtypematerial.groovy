package tech.oleks.eve

import org.apache.commons.lang.builder.EqualsBuilder
import org.apache.commons.lang.builder.HashCodeBuilder

class Invtypematerial implements Serializable {

	Integer quantity
	Invtype invtype
	Invtype materialtype

	static mapping = {
		id composite: ["invtype", "materialtype"]
		invtype column: "typeid"
		materialtype column: "materialtypeid"
		version false
	}

	int hashCode() {
		def builder = new HashCodeBuilder()
		builder.append invtype?.typeid
		builder.append materialtype?.typeid
		builder.toHashCode()
	}

	boolean equals(other) {
		if (other == null) return false
		def builder = new EqualsBuilder()
		builder.append invtype?.typeid, other.invtype?.typeid
		builder.append materialtype?.typeid, other.materialtype?.typeid
		builder.isEquals()
	}

	static constraints = {
		quantity nullable: false
		invtype nullable: false
		materialtype nullable: false
	}

	@Override
	String toString() {
		return invtype?.typename + " (${materialtype?.typename})"
	}
}
