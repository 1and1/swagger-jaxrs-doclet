package fixtures.primitives;

import java.util.UUID;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;

@Path("/primitives/uuids")
@SuppressWarnings("javadoc")
public class UuidsResource {

	@GET
	public UUID get() {
		return UUID.randomUUID();
	}

	@POST
	public Response create(UUID value) {
		return Response.ok().build();
	}
}
