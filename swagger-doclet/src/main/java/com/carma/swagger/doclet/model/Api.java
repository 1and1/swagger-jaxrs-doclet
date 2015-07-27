package com.carma.swagger.doclet.model;

import java.util.Collection;

import com.google.common.base.Objects;

public class Api {

	private String path;
	private String description;
	private Collection<Operation> operations;

	@SuppressWarnings("unused")
	private Api() {
	}

	private Api(Api other) {
		this(other.path, other.description, other.operations);
	}

	public Api(String path, String description, Collection<Operation> operations) {
		this.path = path;
		this.description = description;
		this.operations = operations;
	}

	public String getPath() {
		return this.path;
	}

	public String getDescription() {
		return this.description;
	}

	/**
	 * This sets the description
	 * @param description the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	public Collection<Operation> getOperations() {
		return this.operations;
	}

	public Api operations(Collection<Operation> operations) {
		Api clone = new Api(this);
		clone.operations = operations;
		return clone;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		Api that = (Api) o;
		return Objects.equal(this.path, that.path) && Objects.equal(this.description, that.description) && Objects.equal(this.operations, that.operations);
	}

	@Override
	public int hashCode() {
		return Objects.hashCode(this.path, this.description, this.operations);
	}

	@Override
	public String toString() {
		return Objects.toStringHelper(this).add("path", this.path).add("description", this.description).add("operations", this.operations).toString();
	}
}
