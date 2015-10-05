package com.carma.swagger.doclet.model;

import java.util.List;

import com.carma.swagger.doclet.parser.ParserHelper;

public class Method {

	private HttpMethod method;
	private String methodName;
	private List<ApiParameter> apiParameters;
	private List<ApiResponseMessage> responseMessages;
	private String summary;
	private String notes;

	private String returnType;
	private String returnTypeFormat;

	private String returnTypeMinimum;
	private String returnTypeMaximum;
	private String returnTypeDefaultValue;

	private List<String> returnTypeAllowableValues;
	private Boolean returnTypeUniqueItems;

	private String returnTypeItemsRef;
	private String returnTypeItemsType;
	private String returnTypeItemsFormat;
	private List<String> returnTypeItemsAllowableValues;

	private String path;

	private List<String> consumes;
	private List<String> produces;

	private OperationAuthorizations authorizations;

	private boolean deprecated;

	@SuppressWarnings("unused")
	private Method() {
	}

	public Method(HttpMethod method, String methodName, String path, List<ApiParameter> apiParameters, List<ApiResponseMessage> responseMessages,
			String summary, String notes, String returnType, String returnTypeFormat, String returnTypeMinimum, String returnTypeMaximum,
			String returnTypeDefaultValue, List<String> returnTypeAllowableValues, Boolean returnTypeUniqueItems, String returnTypeItemsRef,
			String returnTypeItemsType, String returnTypeItemsFormat, List<String> returnTypeItemsAllowableValues, List<String> consumes,
			List<String> produces, OperationAuthorizations authorizations, boolean deprecated) {
		this.method = method;
		this.methodName = methodName;
		this.path = ParserHelper.sanitizePath(path);
		this.apiParameters = apiParameters;
		this.responseMessages = responseMessages;
		this.summary = summary;
		this.notes = notes;

		this.returnType = returnType;
		this.returnTypeFormat = returnTypeFormat;

		this.returnTypeMinimum = returnTypeMinimum;
		this.returnTypeMaximum = returnTypeMaximum;
		this.returnTypeDefaultValue = returnTypeDefaultValue;

		this.returnTypeAllowableValues = returnTypeAllowableValues;
		this.returnTypeUniqueItems = returnTypeUniqueItems;

		this.returnTypeItemsRef = returnTypeItemsRef;
		this.returnTypeItemsType = returnTypeItemsType;
		this.returnTypeItemsFormat = returnTypeItemsFormat;
		this.returnTypeItemsAllowableValues = returnTypeItemsAllowableValues;

		this.consumes = consumes;
		this.produces = produces;
		this.authorizations = authorizations;
		this.deprecated = deprecated;
	}

	public HttpMethod getMethod() {
		return this.method;
	}

	public String getMethodName() {
		return this.methodName;
	}

	public String getPath() {
		return this.path;
	}

	public List<ApiParameter> getParameters() {
		return this.apiParameters;
	}

	public List<ApiResponseMessage> getResponseMessages() {
		return this.responseMessages;
	}

	/**
	 * This gets the summary
	 * @return the summary
	 */
	public String getSummary() {
		return this.summary;
	}

	/**
	 * This gets the notes
	 * @return the notes
	 */
	public String getNotes() {
		return this.notes;
	}

	/**
	 * This gets the returnType
	 * @return the returnType
	 */
	public String getReturnType() {
		return this.returnType;
	}

	/**
	 * This gets the returnTypeFormat
	 * @return the returnTypeFormat
	 */
	public String getReturnTypeFormat() {
		return this.returnTypeFormat;
	}

	/**
	 * This gets the returnTypeMinimum
	 * @return the returnTypeMinimum
	 */
	public String getReturnTypeMinimum() {
		return this.returnTypeMinimum;
	}

	/**
	 * This gets the returnTypeMaximum
	 * @return the returnTypeMaximum
	 */
	public String getReturnTypeMaximum() {
		return this.returnTypeMaximum;
	}

	/**
	 * This gets the returnTypeDefaultValue
	 * @return the returnTypeDefaultValue
	 */
	public String getReturnTypeDefaultValue() {
		return this.returnTypeDefaultValue;
	}

	/**
	 * This gets the returnTypeAllowableValues
	 * @return the returnTypeAllowableValues
	 */
	public List<String> getReturnTypeAllowableValues() {
		return this.returnTypeAllowableValues;
	}

	/**
	 * This gets the returnTypeUniqueItems
	 * @return the returnTypeUniqueItems
	 */
	public Boolean getReturnTypeUniqueItems() {
		return this.returnTypeUniqueItems;
	}

	/**
	 * This gets the returnTypeItemsRef
	 * @return the returnTypeItemsRef
	 */
	public String getReturnTypeItemsRef() {
		return this.returnTypeItemsRef;
	}

	/**
	 * This gets the returnTypeItemsType
	 * @return the returnTypeItemsType
	 */
	public String getReturnTypeItemsType() {
		return this.returnTypeItemsType;
	}

	/**
	 * This gets the returnTypeItemsFormat
	 * @return the returnTypeItemsFormat
	 */
	public String getReturnTypeItemsFormat() {
		return this.returnTypeItemsFormat;
	}

	/**
	 * This gets the returnTypeItemsAllowableValues
	 * @return the returnTypeItemsAllowableValues
	 */
	public List<String> getReturnTypeItemsAllowableValues() {
		return this.returnTypeItemsAllowableValues;
	}

	public boolean isSubResource() {
		return this.method == null;
	}

	/**
	 * This gets the consumes
	 * @return the consumes
	 */
	public List<String> getConsumes() {
		return this.consumes;
	}

	/**
	 * This gets the produces
	 * @return the produces
	 */
	public List<String> getProduces() {
		return this.produces;
	}

	/**
	 * This gets the authorizations
	 * @return the authorizations
	 */
	public OperationAuthorizations getAuthorizations() {
		return this.authorizations;
	}

	/**
	 * This gets the deprecated
	 * @return the deprecated
	 */
	public boolean isDeprecated() {
		return this.deprecated;
	}

	/**
	 * {@inheritDoc}
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((this.apiParameters == null) ? 0 : this.apiParameters.hashCode());
		result = prime * result + ((this.authorizations == null) ? 0 : this.authorizations.hashCode());
		result = prime * result + ((this.consumes == null) ? 0 : this.consumes.hashCode());
		result = prime * result + (this.deprecated ? 1231 : 1237);
		result = prime * result + ((this.method == null) ? 0 : this.method.hashCode());
		result = prime * result + ((this.methodName == null) ? 0 : this.methodName.hashCode());
		result = prime * result + ((this.notes == null) ? 0 : this.notes.hashCode());
		result = prime * result + ((this.path == null) ? 0 : this.path.hashCode());
		result = prime * result + ((this.produces == null) ? 0 : this.produces.hashCode());
		result = prime * result + ((this.responseMessages == null) ? 0 : this.responseMessages.hashCode());
		result = prime * result + ((this.returnType == null) ? 0 : this.returnType.hashCode());
		result = prime * result + ((this.returnTypeFormat == null) ? 0 : this.returnTypeFormat.hashCode());
		result = prime * result + ((this.returnTypeItemsFormat == null) ? 0 : this.returnTypeItemsFormat.hashCode());
		result = prime * result + ((this.returnTypeItemsRef == null) ? 0 : this.returnTypeItemsRef.hashCode());
		result = prime * result + ((this.returnTypeItemsType == null) ? 0 : this.returnTypeItemsType.hashCode());
		result = prime * result + ((this.summary == null) ? 0 : this.summary.hashCode());
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
		Method other = (Method) obj;
		if (this.apiParameters == null) {
			if (other.apiParameters != null) {
				return false;
			}
		} else if (!this.apiParameters.equals(other.apiParameters)) {
			return false;
		}
		if (this.authorizations == null) {
			if (other.authorizations != null) {
				return false;
			}
		} else if (!this.authorizations.equals(other.authorizations)) {
			return false;
		}
		if (this.consumes == null) {
			if (other.consumes != null) {
				return false;
			}
		} else if (!this.consumes.equals(other.consumes)) {
			return false;
		}
		if (this.deprecated != other.deprecated) {
			return false;
		}
		if (this.method != other.method) {
			return false;
		}
		if (this.methodName == null) {
			if (other.methodName != null) {
				return false;
			}
		} else if (!this.methodName.equals(other.methodName)) {
			return false;
		}
		if (this.notes == null) {
			if (other.notes != null) {
				return false;
			}
		} else if (!this.notes.equals(other.notes)) {
			return false;
		}
		if (this.path == null) {
			if (other.path != null) {
				return false;
			}
		} else if (!this.path.equals(other.path)) {
			return false;
		}
		if (this.produces == null) {
			if (other.produces != null) {
				return false;
			}
		} else if (!this.produces.equals(other.produces)) {
			return false;
		}
		if (this.responseMessages == null) {
			if (other.responseMessages != null) {
				return false;
			}
		} else if (!this.responseMessages.equals(other.responseMessages)) {
			return false;
		}
		if (this.returnType == null) {
			if (other.returnType != null) {
				return false;
			}
		} else if (!this.returnType.equals(other.returnType)) {
			return false;
		}
		if (this.returnTypeFormat == null) {
			if (other.returnTypeFormat != null) {
				return false;
			}
		} else if (!this.returnTypeFormat.equals(other.returnTypeFormat)) {
			return false;
		}
		if (this.returnTypeItemsFormat == null) {
			if (other.returnTypeItemsFormat != null) {
				return false;
			}
		} else if (!this.returnTypeItemsFormat.equals(other.returnTypeItemsFormat)) {
			return false;
		}
		if (this.returnTypeItemsRef == null) {
			if (other.returnTypeItemsRef != null) {
				return false;
			}
		} else if (!this.returnTypeItemsRef.equals(other.returnTypeItemsRef)) {
			return false;
		}
		if (this.returnTypeItemsType == null) {
			if (other.returnTypeItemsType != null) {
				return false;
			}
		} else if (!this.returnTypeItemsType.equals(other.returnTypeItemsType)) {
			return false;
		}
		if (this.summary == null) {
			if (other.summary != null) {
				return false;
			}
		} else if (!this.summary.equals(other.summary)) {
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
		return "Method [method=" + this.method + ", methodName=" + this.methodName + ", apiParameters=" + this.apiParameters + ", responseMessages="
				+ this.responseMessages + ", summary=" + this.summary + ", notes=" + this.notes + ", returnType=" + this.returnType + ", returnTypeFormat="
				+ this.returnTypeFormat + ", returnTypeItemsRef=" + this.returnTypeItemsRef + ", returnTypeItemsType=" + this.returnTypeItemsType
				+ ", returnTypeItemsFormat=" + this.returnTypeItemsFormat + ", path=" + this.path + ", consumes=" + this.consumes + ", produces="
				+ this.produces + ", authorizations=" + this.authorizations + ", deprecated=" + this.deprecated + "]";
	}

}
