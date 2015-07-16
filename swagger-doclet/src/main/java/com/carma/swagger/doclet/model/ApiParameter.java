package com.carma.swagger.doclet.model;

import java.util.List;

/**
 * The ApiParameter represents an API method parameter
 * @version $Id$
 */
public class ApiParameter extends Property {

	// param specific fields
	private String paramType;
	private String name;
	private Boolean required;
	private Boolean allowMultiple;

	ApiParameter() {
		// noop
	}

	/**
	 * This creates a ApiParameter
	 * @param name
	 * @param paramCategory
	 * @param required
	 * @param allowMultiple
	 * @param type
	 * @param format
	 * @param description
	 * @param itemsRef
	 * @param itemsType
	 * @param itemsFormat
	 * @param uniqueItems
	 * @param allowableValues
	 * @param minimum
	 * @param maximum
	 * @param defaultValue
	 */
	public ApiParameter(String paramCategory, String name, Boolean required, Boolean allowMultiple, String type, String format, String description,
			String itemsRef, String itemsType, String itemsFormat, List<String> itemsAllowableValues, Boolean uniqueItems, List<String> allowableValues, String minimum, String maximum,
			String defaultValue) {
		super(name, paramCategory, type, format, description, itemsRef, itemsType, itemsFormat, itemsAllowableValues, uniqueItems, allowableValues, minimum, maximum, defaultValue);
		this.paramType = paramCategory;
		this.name = name;
		this.required = required;
		this.allowMultiple = allowMultiple;
	}

	/**
	 * This gets the paramType
	 * @return the paramType
	 */
	public String getParamType() {
		return this.paramType;
	}

	/**
	 * This sets the paramType
	 * @param paramType the paramType to set
	 */
	public void setParamType(String paramType) {
		this.paramType = paramType;
	}

	/**
	 * This gets the name
	 * @return the name
	 */
	public String getName() {
		return this.name;
	}

	/**
	 * This sets the name
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * This gets the required
	 * @return the required
	 */
	public Boolean getRequired() {
		return this.required;
	}

	/**
	 * This sets the required
	 * @param required the required to set
	 */
	public void setRequired(Boolean required) {
		this.required = required;
	}

	/**
	 * This gets the allowMultiple
	 * @return the allowMultiple
	 */
	public Boolean getAllowMultiple() {
		return this.allowMultiple;
	}

	/**
	 * This sets the allowMultiple
	 * @param allowMultiple the allowMultiple to set
	 */
	public void setAllowMultiple(Boolean allowMultiple) {
		this.allowMultiple = allowMultiple;
	}

	/**
	 * {@inheritDoc}
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((this.allowMultiple == null) ? 0 : this.allowMultiple.hashCode());
		result = prime * result + ((this.name == null) ? 0 : this.name.hashCode());
		result = prime * result + ((this.paramType == null) ? 0 : this.paramType.hashCode());
		result = prime * result + ((this.required == null) ? 0 : this.required.hashCode());
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
		if (!super.equals(obj)) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		ApiParameter other = (ApiParameter) obj;
		if (this.allowMultiple == null) {
			if (other.allowMultiple != null) {
				return false;
			}
		} else if (!this.allowMultiple.equals(other.allowMultiple)) {
			return false;
		}
		if (this.name == null) {
			if (other.name != null) {
				return false;
			}
		} else if (!this.name.equals(other.name)) {
			return false;
		}
		if (this.paramType == null) {
			if (other.paramType != null) {
				return false;
			}
		} else if (!this.paramType.equals(other.paramType)) {
			return false;
		}
		if (this.required == null) {
			if (other.required != null) {
				return false;
			}
		} else if (!this.required.equals(other.required)) {
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
		return "ApiParameter [paramType=" + this.paramType + ", name=" + this.name + ", required=" + this.required + ", allowMultiple=" + this.allowMultiple
				+ ", getType()=" + this.getType() + ", getFormat()=" + this.getFormat() + ", getDescription()=" + this.getDescription()
				+ ", getAllowableValues()=" + this.getAllowableValues() + ", getUniqueItems()=" + this.getUniqueItems() + ", getItems()=" + this.getItems()
				+ ", getMinimum()=" + this.getMinimum() + ", getMaximum()=" + this.getMaximum() + ", getDefaultValue()=" + this.getDefaultValue() + "]";
	}

}
