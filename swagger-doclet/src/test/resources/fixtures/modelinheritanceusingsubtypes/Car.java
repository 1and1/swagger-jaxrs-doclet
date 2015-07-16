package fixtures.modelinheritanceusingsubtypes;

/**
 * The Car that is a subtype of Vehicle
 * @version $Id$
 */
@SuppressWarnings("javadoc")
public class Car extends Vehicle {

        public Car(String make, String model) {
                super(make, model);
        }
    
}
