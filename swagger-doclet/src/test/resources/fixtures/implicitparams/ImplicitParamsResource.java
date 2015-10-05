package fixtures.implicitparams;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;

/**
 * @implicitParam p1|string|header
 */
@SuppressWarnings("javadoc")
@Path("/implicitparams")
public class ImplicitParamsResource {

	@GET
	@Path("m1")
	public void m1() {
		// this should inherit p1
	}

	/**
	 * @implicitParam p1|string|query
	 * @implicitParam p2|int|query|true|5|1|10||true|test dec
	 * @implicitParam p3|string|path|true|A|||A,B||test
	 */
	@GET
	@Path("m2/{p3}")
	public void m2() {
		// Here we override p1 and add an extra p2 param
		// format is: name|dataType|paramType|required|defaultValue|minValue|maxValue|allowableValues|allowMultiple|description
	}

	/**
	 * @implicitParam p2|fixtures.implicitparams.Data|body
	 */
	@GET
	@Path("m3")
	public void m3(@QueryParam("p3") int p3) {
		// Here we add an extra p2 param and have the method param p3 too
	}
}
