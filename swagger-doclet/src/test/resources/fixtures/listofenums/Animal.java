package fixtures.listofenums;

import java.util.List;

/**
 * The Animal
 * @version $Id$
 */
@SuppressWarnings("javadoc")
public class Animal {

        private String name;
        private List<Color> colors;
        
        public Animal(String name, List<Color> colors) {
                this.colors = colors;
        }
        
        public String getName() {
                return this.name;
        }
        
        public void setName(String name) {
                this.name = name;
        }

        public List<Color> getColors() {
                return this.colors;
        }
        
        public void setColors(List<Color> colors) {
                this.colors = colors;
        }
}
