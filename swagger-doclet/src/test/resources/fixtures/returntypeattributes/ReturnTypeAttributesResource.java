package fixtures.returntypeattributes;

import java.time.DayOfWeek;

import javax.ws.rs.GET;
import javax.ws.rs.Path;

/**
 * The ReturnTypeAttributesResource represents a test for some extra
 * return type attributes like allowable values
 * @version $Id$
 * @author conor.roche
 */
@Path("/returntypeattributes")
@SuppressWarnings("javadoc")
public class ReturnTypeAttributesResource {

	/**
	 * @defaultValue FRIDAY
	 */
	@GET
	public DayOfWeek getEnum() {
		return null;
	}

	/**
	 * @min 5
	 * @max 15
	 * @default 10
	 */
	@GET
	@Path("/1")
	public int getMinMax() {
		return 0;
	}

}
