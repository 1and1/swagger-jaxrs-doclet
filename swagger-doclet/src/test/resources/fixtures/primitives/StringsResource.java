package fixtures.primitives;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;

/**
 * @priority 8
 */
@Path("/primitives/strings")
@SuppressWarnings("javadoc")
public class StringsResource {

	@GET
	public String get() {
		return "hello world";
	}

	@POST
	public Response create(String value) {
		return Response.ok().build();
	}
}
