package tech.oleks.eve

import org.apache.commons.lang.builder.EqualsBuilder
import org.apache.commons.lang.builder.HashCodeBuilder

class Invtypereaction implements Serializable {

	Short input
	Integer quantity
	Invtype invtype
	Invtype reactiontype

	static mapping = {
		id composite: ["invtype", "reactiontype"]
		invtype column: "typeid"
		reactiontype column: "reactiontypeid"
		version false
	}

	int hashCode() {
		def builder = new HashCodeBuilder()
		builder.append invtype?.typeid
		builder.append reactiontype?.typeid
		builder.toHashCode()
	}

	boolean equals(other) {
		if (other == null) return false
		def builder = new EqualsBuilder()
		builder.append invtype?.typeid, other.invtype?.typeid
		builder.append reactiontype?.typeid, other.reactiontype?.typeid
		builder.isEquals()
	}

	static constraints = {
		quantity nullable: false
		invtype nullable: false
		reactiontype nullable: false
	}

	@Override
	String toString() {
		return invtype?.typename + " (${reactiontype?.typename})"
	}
}
