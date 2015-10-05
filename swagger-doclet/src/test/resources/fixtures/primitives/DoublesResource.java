package fixtures.primitives;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;

/**
 * @priority 7
 */
@Path("/primitives/doubles")
@SuppressWarnings("javadoc")
public class DoublesResource {

	@GET
	public double get() {
		return 0;
	}

	@POST
	public Response create(double value) {
		return Response.ok().build();
	}
}
