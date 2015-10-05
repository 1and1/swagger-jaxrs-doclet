package fixtures.exclusion;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;
import javax.ws.rs.container.AsyncResponse;
import javax.ws.rs.container.Suspended;
import javax.ws.rs.core.Response;

/**
 * The ExclusionResource represents a test case for api method and model field and methods exclusion
 * @version $Id$
 * @author conor.roche
 */
@SuppressWarnings("javadoc")
@Path("/exclusion")
public class ExclusionResource {

	/**
	 * @hidden
	 */
	@GET
	public void excludeMethod() {
		// noop
	}

	@GET
	public Data getData() {
		return new Data();
	}

	@PUT
	public Response putData(Data data) {
		return Response.ok().build();
	}

	/**
	 * @excludeParams p1,data
	 */
	@POST
	public Response postData(@QueryParam("p1") int p1, @QueryParam("p2") int p2, Data data, @Suspended final AsyncResponse asyncResponse) {
		return Response.ok().build();
	}

}
