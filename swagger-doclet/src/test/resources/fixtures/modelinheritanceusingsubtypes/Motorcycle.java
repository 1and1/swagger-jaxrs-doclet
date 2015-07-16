package fixtures.modelinheritanceusingsubtypes;

/**
 * The Motorcycle that is a subtype of Vehicle
 * @version $Id$
 */
@SuppressWarnings("javadoc")
public class Motorcycle extends Vehicle {

        public Motorcycle(String make, String model) {
                super(make, model);
        }
    
}
