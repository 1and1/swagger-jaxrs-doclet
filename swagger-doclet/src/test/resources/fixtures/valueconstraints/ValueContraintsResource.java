package fixtures.valueconstraints;

import javax.ws.rs.DefaultValue;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;

/**
 * The ValueContraintsResource represents a resource for testing value contrainst; enum and min/max/default values of params and properties.
 * @version $Id$
 * @author conor.roche
 */
@Path("/valueconstraints")
@SuppressWarnings("javadoc")
public class ValueContraintsResource {

	/**
	 * @paramsDefaultValue enumValue VALUE1
	 */
	@POST
	public Data postData(Data data, @QueryParam(value = "enumValue") EnumValue enumValue) {
		return data;
	}

	/**
	 * @paramsMinValue p1 5
	 * @paramsMaxValue p1 15
	 * @defaultValues p1 10
	 */
	@PUT
	@Path("/1")
	public void putMinMax(@QueryParam("p1") int p1) {
		// noop
	}

	/**
	 * @paramsMinValue p1 6.5 p2 10
	 * @paramsMaxValue p1 9 p2 17
	 * @paramsDefaultValue p1 6.95
	 */
	@PUT
	@Path("/2")
	public void putMinMaxes(@QueryParam("p1") double p1, @DefaultValue("12") @QueryParam("p2a") long p2) {
		// noop
	}

	/**
	 * @paramsDefaultValue p1 tRue p2 FALSE
	 */
	@PUT
	@Path("/3")
	public void putBoolean(@QueryParam("p1") boolean p1, @QueryParam("p2") boolean p2, @DefaultValue("True") @QueryParam("p3") boolean p3,
			@DefaultValue("False") @QueryParam("p4") boolean p4) {
		// noop
	}

	/**
	 * @paramsAllowableValues p1 A p2 B p1 C
	 * @paramsDefaultValue p1 C
	 */
	@PUT
	@Path("/4")
	public void putEnum(@QueryParam("p1") String p1, @QueryParam("p2") String p2) {
		// noop
	}
}
