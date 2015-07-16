package com.carma.swagger.doclet.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * The PropertyItemsObject represents an object that defines the items for a collections
 * @version $Id$
 * @author conor.roche
 */
public class PropertyItems {

	private String ref;
	private String type;
	private String format;
	private List<String> allowableValues;

	/**
	 * This creates a PropertyItems
	 */
	public PropertyItems() {
		super();
	}

	/**
	 * This creates a PropertyItems
	 * @param ref
	 * @param type
	 * @param format
	 * @param allowableValues
	 */
	public PropertyItems(String ref, String type, String format, List<String> allowableValues) {
		super();
		this.ref = ref;
		this.type = type;
		this.format = format;
		this.allowableValues = allowableValues;
	}

	/**
	 * This gets the ref
	 * @return the ref
	 */
	@JsonProperty("$ref")
	public String getRef() {
		return this.ref;
	}

	/**
	 * This gets the type
	 * @return the type
	 */
	public String getType() {
		return this.type;
	}

	/**
	 * This gets the format
	 * @return the format
	 */
	public String getFormat() {
		return this.format;
	}

	/**
	 * This gets the allowable values
	 * @return the allowable values
	 */
	@JsonProperty("enum")
	public List<String> getAllowableValues() {
		return this.allowableValues;
	}

	/**
	 * {@inheritDoc}
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((this.format == null) ? 0 : this.format.hashCode());
		result = prime * result + ((this.allowableValues == null) ? 0 : this.allowableValues.hashCode());
		result = prime * result + ((this.ref == null) ? 0 : this.ref.hashCode());
		result = prime * result + ((this.type == null) ? 0 : this.type.hashCode());
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
		PropertyItems other = (PropertyItems) obj;
		if (this.format == null) {
			if (other.format != null) {
				return false;
			}
		} else if (!this.format.equals(other.format)) {
			return false;
		}
		if (this.allowableValues == null) {
			if (other.allowableValues != null) {
				return false;
			}
		} else if (!this.allowableValues.equals(other.allowableValues)) {
			return false;
		}
		if (this.ref == null) {
			if (other.ref != null) {
				return false;
			}
		} else if (!this.ref.equals(other.ref)) {
			return false;
		}
		if (this.type == null) {
			if (other.type != null) {
				return false;
			}
		} else if (!this.type.equals(other.type)) {
			return false;
		}
		return true;
	}

	/**
	 * {@inheritDoc}
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "PropertyItems [ref=" + this.ref + ", type=" + this.type + ", format=" + this.format + ", allowableValues=" + this.allowableValues + "]";
	}

}
