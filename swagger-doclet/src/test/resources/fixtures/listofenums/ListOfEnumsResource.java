package fixtures.listofenums;

import java.util.Arrays;
import java.util.List;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;

/**
 * The ListOfEnumsResource represents a resource for testing model classes and QueryParams with
 * a list of enum values
 * @version $Id$
 */
@Path("/listofenums")
public class ListOfEnumsResource {

	@SuppressWarnings("javadoc")
	@GET
    @Path("/animals")
	public Animal getAnimals(@QueryParam("name") String name, @QueryParam("color") List<Color> colors) {
		return new Animal("Frog", Arrays.asList(Color.BLACK, Color.GREEN));
	}

    @SuppressWarnings("javadoc")
    @GET
    @Path("/colors")
    public List<Color> getAnimalColors() {
        return Arrays.asList(Color.BLACK, Color.GREEN);
    }

}
