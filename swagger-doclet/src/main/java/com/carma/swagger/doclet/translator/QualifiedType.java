package com.carma.swagger.doclet.translator;

import com.sun.javadoc.Type;

/**
 * The QualifiedType represents a type with a qualifier.
 * @version $Id$
 * @author conor.roche
 */
public class QualifiedType {

	private final String qualifier;
	private final Type type;
	private final String typeName;

	/**
	 * This creates a QualifiedType
	 * @param qualifier
	 * @param type
	 */
	public QualifiedType(String qualifier, Type type) {
		super();
		this.qualifier = qualifier;
		this.type = type;
		this.typeName = type == null ? null : this.type.qualifiedTypeName();
	}

	/**
	 * This creates a QualifiedType
	 * @param type
	 */
	public QualifiedType(Type type) {
		this(null, type);
	}

	/**
	 * This gets the qualifier
	 * @return the qualifier
	 */
	public String getQualifier() {
		return this.qualifier;
	}

	/**
	 * This gets the type
	 * @return the type
	 */
	public Type getType() {
		return this.type;
	}

	/**
	 * {@inheritDoc}
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((this.qualifier == null) ? 0 : this.qualifier.hashCode());
		result = prime * result + ((this.type == null) ? 0 : this.type.hashCode());
		result = prime * result + ((this.typeName == null) ? 0 : this.typeName.hashCode());
		return result;
	}

	/**
	 * {@inheritDoc}
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		QualifiedType other = (QualifiedType) obj;
		if (this.qualifier == null) {
			if (other.qualifier != null) {
				return false;
			}
		} else if (!this.qualifier.equals(other.qualifier)) {
			return false;
		}
		if (this.type == null) {
			if (other.type != null) {
				return false;
			}
		} else if (!this.type.equals(other.type)) {
			return false;
		}
		if (this.typeName == null) {
			if (other.typeName != null) {
				return false;
			}
		} else if (!this.typeName.equals(other.typeName)) {
			return false;
		}
		return true;
	}

}
