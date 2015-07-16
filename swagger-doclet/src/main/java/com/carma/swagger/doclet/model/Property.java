package com.carma.swagger.doclet.model;

import static com.google.common.base.Strings.emptyToNull;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * The Property represents a model property
 * @version $Id$
 */
public class Property {

	// these are not serialized, only used internally
	private String rawFieldName;
	private String paramCategory;

	private String type;
	private String format;
	private String description;
	private PropertyItems items;
	private Boolean uniqueItems;
	private List<String> allowableValues;
	private String minimum;
	private String maximum;
	private String defaultValue;

	Property() {
		super();
	}

	/**
	 * This creates a Property
	 * @param rawFieldName
	 * @param paramCategory
	 * @param type
	 * @param format
	 * @param description
	 * @param itemsRef
	 * @param itemsType
	 * @param itemsFormat
	 * @param itemsAllowableValues
	 * @param uniqueItems
	 * @param allowableValues
	 * @param minimum
	 * @param maximum
	 * @param defaultValue
	 */
	public Property(String rawFieldName, String paramCategory, String type, String format, String description, String itemsRef, String itemsType,
			String itemsFormat, List<String> itemsAllowableValues, Boolean uniqueItems, List<String> allowableValues, String minimum, String maximum, String defaultValue) {
		this.rawFieldName = rawFieldName;
		this.paramCategory = paramCategory;
		this.type = type;
		this.format = format;
		this.description = emptyToNull(description);
		if (itemsRef != null || itemsType != null) {
			this.items = new PropertyItems(itemsRef, itemsType, itemsFormat, itemsAllowableValues);
		}
		this.uniqueItems = uniqueItems;
		this.allowableValues = allowableValues;
		this.minimum = minimum;
		this.maximum = maximum;
		this.defaultValue = defaultValue;
	}

	/**
	 * This gets the raw field name the property came from
	 * @return the raw field name the property came from
	 */
	@JsonIgnore
	public String getRawFieldName() {
		return this.rawFieldName;
	}

	/**
	 * This gets category of parameter of the field, only applicable to composite parameter fields
	 * @return the category of parameter of the field, only applicable to composite parameter fields
	 */
	@JsonIgnore
	public String getParamCategory() {
		return this.paramCategory;
	}

	/**
	 * This gets the type of property
	 * @return the type of property
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
	 * This gets the description of the property
	 * @return the description of the property
	 */
	public String getDescription() {
		return this.description;
	}

	/**
	 * This gets the allowableValues
	 * @return the allowableValues
	 */
	@JsonProperty("enum")
	public List<String> getAllowableValues() {
		return this.allowableValues;
	}

	/**
	 * This gets the uniqueItems
	 * @return the uniqueItems
	 */
	public Boolean getUniqueItems() {
		return this.uniqueItems;
	}

	/**
	 * This gets the items in the collection
	 * @return The items in the collection
	 */
	public PropertyItems getItems() {
		return this.items;
	}

	/**
	 * This gets the minimum value of the property
	 * @return the minimum value of the property
	 */
	public String getMinimum() {
		return this.minimum;
	}

	/**
	 * This gets the maximum value of the property
	 * @return the maximum value of the property
	 */
	public String getMaximum() {
		return this.maximum;
	}

	/**
	 * This gets the defaultValue
	 * @return the defaultValue
	 */
	public String getDefaultValue() {
		return this.defaultValue;
	}

	/**
	 * {@inheritDoc}
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((this.allowableValues == null) ? 0 : this.allowableValues.hashCode());
		result = prime * result + ((this.defaultValue == null) ? 0 : this.defaultValue.hashCode());
		result = prime * result + ((this.description == null) ? 0 : this.description.hashCode());
		result = prime * result + ((this.format == null) ? 0 : this.format.hashCode());
		result = prime * result + ((this.items == null) ? 0 : this.items.hashCode());
		result = prime * result + ((this.maximum == null) ? 0 : this.maximum.hashCode());
		result = prime * result + ((this.minimum == null) ? 0 : this.minimum.hashCode());
		result = prime * result + ((this.type == null) ? 0 : this.type.hashCode());
		result = prime * result + ((this.uniqueItems == null) ? 0 : this.uniqueItems.hashCode());
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
		Property other = (Property) obj;
		if (this.allowableValues == null) {
			if (other.allowableValues != null) {
				return false;
			}
		} else if (!this.allowableValues.equals(other.allowableValues)) {
			return false;
		}
		if (this.defaultValue == null) {
			if (other.defaultValue != null) {
				return false;
			}
		} else if (!this.defaultValue.equals(other.defaultValue)) {
			return false;
		}
		if (this.description == null) {
			if (other.description != null) {
				return false;
			}
		} else if (!this.description.equals(other.description)) {
			return false;
		}
		if (this.format == null) {
			if (other.format != null) {
				return false;
			}
		} else if (!this.format.equals(other.format)) {
			return false;
		}
		if (this.items == null) {
			if (other.items != null) {
				return false;
			}
		} else if (!this.items.equals(other.items)) {
			return false;
		}
		if (this.maximum == null) {
			if (other.maximum != null) {
				return false;
			}
		} else if (!this.maximum.equals(other.maximum)) {
			return false;
		}
		if (this.minimum == null) {
			if (other.minimum != null) {
				return false;
			}
		} else if (!this.minimum.equals(other.minimum)) {
			return false;
		}
		if (this.type == null) {
			if (other.type != null) {
				return false;
			}
		} else if (!this.type.equals(other.type)) {
			return false;
		}
		if (this.uniqueItems == null) {
			if (other.uniqueItems != null) {
				return false;
			}
		} else if (!this.uniqueItems.equals(other.uniqueItems)) {
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
		return "Property [type=" + this.type + ", format=" + this.format + ", description=" + this.description + ", items=" + this.items + ", uniqueItems="
				+ this.uniqueItems + ", allowableValues=" + this.allowableValues + ", minimum=" + this.minimum + ", maximum=" + this.maximum
				+ ", defaultValue=" + this.defaultValue + "]";
	}

}
