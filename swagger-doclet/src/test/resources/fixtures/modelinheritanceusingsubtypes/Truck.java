package fixtures.modelinheritanceusingsubtypes;

/**
 * The Truck that is a Vehicle
 * @version $Id$
 */
@SuppressWarnings("javadoc")
public class Truck extends Vehicle {

        private String maxLoad;
        
        public Truck(String make, String model, String maxLoad) {
                super(make, model);
                this.maxLoad = maxLoad;
        }
        
        public String getMaxLoad() {
                return this.maxLoad;
        }
        
        public void setMaxLoad(String maxLoad) {
                this.maxLoad = maxLoad;
        }
}
