package fixtures.primitives;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;

/**
 * @priority 5
 */
@Path("/primitives/longs")
@SuppressWarnings("javadoc")
public class LongsResource {

	@GET
	public long get() {
		return 0;
	}

	@POST
	public Response create(long value) {
		return Response.ok().build();
	}
}
