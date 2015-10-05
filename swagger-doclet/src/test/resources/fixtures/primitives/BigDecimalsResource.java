package fixtures.primitives;

import java.math.BigDecimal;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;

/**
 * @priority 11
 */
@Path("/primitives/bigdecimals")
@SuppressWarnings("javadoc")
public class BigDecimalsResource {

	@GET
	public BigDecimal get() {
		return BigDecimal.ONE;
	}

	@POST
	public Response create(BigDecimal value) {
		return Response.ok().build();
	}
}
