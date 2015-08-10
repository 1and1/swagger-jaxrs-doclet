package com.carma.swagger.doclet.model;

import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@SuppressWarnings("javadoc")
@JsonPropertyOrder({ "apiVersion", "swaggerVersion", "basePath", "resourcePath", "apis", "models" })
public class ApiDeclaration {

	private String apiVersion;
	private String swaggerVersion;
	private String basePath;
	private String resourcePath;
	private List<Api> apis;
	private Map<String, Model> models;

	private int priority = Integer.MAX_VALUE;
	private String description;

	@SuppressWarnings("unused")
	private ApiDeclaration() {
	}

	private ApiDeclaration(ApiDeclaration other) {
		this.apiVersion = other.apiVersion;
		this.swaggerVersion = other.swaggerVersion;
		this.basePath = other.basePath;
		this.resourcePath = other.resourcePath;
		this.apis = other.apis;
		this.models = other.models;

		this.priority = other.priority;
		this.description = other.description;
	}

	public ApiDeclaration(String swaggerVersion, String apiVersion, String basePath, String resourcePath, List<Api> apis, Map<String, Model> models,
			int priority, String description) {
		this.swaggerVersion = swaggerVersion;
		this.apiVersion = apiVersion;
		this.basePath = basePath;
		this.resourcePath = resourcePath;
		this.apis = apis == null || apis.isEmpty() ? null : apis;
		this.models = models == null || models.isEmpty() ? null : models;
		this.priority = priority;
		this.description = description;
	}

	public String getApiVersion() {
		return this.apiVersion;
	}

	public String getSwaggerVersion() {
		return this.swaggerVersion;
	}

	public String getBasePath() {
		return this.basePath;
	}

	public ApiDeclaration basePath(String basePath) {
		ApiDeclaration clone = new ApiDeclaration(this);
		clone.basePath = basePath;
		return clone;
	}

	public String getResourcePath() {
		return this.resourcePath;
	}

	/**
	 * This sets the resourcePath
	 * @param resourcePath the resourcePath to set
	 */
	public void setResourcePath(String resourcePath) {
		this.resourcePath = resourcePath;
	}

	/**
	 * This gets the apis
	 * @return the apis
	 */
	public List<Api> getApis() {
		return this.apis;
	}

	/**
	 * This sets the apis
	 * @param apis the apis to set
	 */
	public void setApis(List<Api> apis) {
		this.apis = apis;
	}

	public ApiDeclaration apis(List<Api> apis) {
		ApiDeclaration clone = new ApiDeclaration(this);
		clone.apis = apis;
		return clone;
	}

	/**
	 * This gets the models
	 * @return the models
	 */
	public Map<String, Model> getModels() {
		return this.models;
	}

	/**
	 * This sets the models
	 * @param models the models to set
	 */
	public void setModels(Map<String, Model> models) {
		this.models = models;
	}

	/**
	 * This gets the priority of this api declaration in a resource listing
	 * @return the priority
	 */
	@JsonIgnore
	public int getPriority() {
		return this.priority;
	}

	/**
	 * This gets the description of this api declaration in a resource listing
	 * @return the description
	 */
	@JsonIgnore
	public String getDescription() {
		return this.description;
	}

	/**
	 * This sets the priority
	 * @param priority the priority to set
	 */
	@JsonProperty
	public void setPriority(int priority) {
		this.priority = priority;
	}

	/**
	 * This sets the description
	 * @param description the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * {@inheritDoc}
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((this.apiVersion == null) ? 0 : this.apiVersion.hashCode());
		result = prime * result + ((this.apis == null) ? 0 : this.apis.hashCode());
		result = prime * result + ((this.basePath == null) ? 0 : this.basePath.hashCode());
		result = prime * result + ((this.description == null) ? 0 : this.description.hashCode());
		result = prime * result + ((this.models == null) ? 0 : this.models.hashCode());
		result = prime * result + this.priority;
		result = prime * result + ((this.resourcePath == null) ? 0 : this.resourcePath.hashCode());
		result = prime * result + ((this.swaggerVersion == null) ? 0 : this.swaggerVersion.hashCode());
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
		ApiDeclaration other = (ApiDeclaration) obj;
		if (this.apiVersion == null) {
			if (other.apiVersion != null) {
				return false;
			}
		} else if (!this.apiVersion.equals(other.apiVersion)) {
			return false;
		}
		if (this.apis == null) {
			if (other.apis != null) {
				return false;
			}
		} else if (!this.apis.equals(other.apis)) {
			return false;
		}
		if (this.basePath == null) {
			if (other.basePath != null) {
				return false;
			}
		} else if (!this.basePath.equals(other.basePath)) {
			return false;
		}
		if (this.description == null) {
			if (other.description != null) {
				return false;
			}
		} else if (!this.description.equals(other.description)) {
			return false;
		}
		if (this.models == null) {
			if (other.models != null) {
				return false;
			}
		} else if (!this.models.equals(other.models)) {
			return false;
		}
		if (this.priority != other.priority) {
			return false;
		}
		if (this.resourcePath == null) {
			if (other.resourcePath != null) {
				return false;
			}
		} else if (!this.resourcePath.equals(other.resourcePath)) {
			return false;
		}
		if (this.swaggerVersion == null) {
			if (other.swaggerVersion != null) {
				return false;
			}
		} else if (!this.swaggerVersion.equals(other.swaggerVersion)) {
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
		return "ApiDeclaration [apiVersion=" + this.apiVersion + ", swaggerVersion=" + this.swaggerVersion + ", basePath=" + this.basePath + ", resourcePath="
				+ this.resourcePath + ", apis=" + this.apis + ", models=" + this.models + ", priority=" + this.priority + ", description=" + this.description
				+ "]";
	}

}
