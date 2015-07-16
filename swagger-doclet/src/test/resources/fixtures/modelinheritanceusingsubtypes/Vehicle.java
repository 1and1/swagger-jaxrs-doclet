package fixtures.modelinheritanceusingsubtypes;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.annotation.JsonTypeInfo.As;

/**
 * The Vehicle
 * @version $Id$
 */
@SuppressWarnings("javadoc")
@JsonTypeInfo(use = com.fasterxml.jackson.annotation.JsonTypeInfo.Id.NAME, include = As.PROPERTY, property = "type")
@JsonSubTypes({
        @JsonSubTypes.Type(Car.class),
        @JsonSubTypes.Type(Truck.class),
        @JsonSubTypes.Type(Motorcycle.class),
})
public abstract class Vehicle {

	private String make;
	private String model;
        
        public Vehicle(String make, String model) {
                this.make = make;
                this.model = model;
        }
        
	public String getMake() {
		return this.make;
	}

	public void setMake(String make) {
		this.make = make;
	}

	public String getModel() {
		return this.model;
	}

	public void setModel(String model) {
		this.model = model;
	}
        
}
