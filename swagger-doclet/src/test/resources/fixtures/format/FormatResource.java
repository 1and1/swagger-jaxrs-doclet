package fixtures.format;

import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;

@SuppressWarnings("javadoc")
@Path("/format")
public class FormatResource {

	/**
	 * @paramsFormat p1 date p2 date-time
	 */
	@POST
	public Data postData(Data data, @QueryParam(value = "p1") String p1, @QueryParam(value = "p2") String p2) {
		return data;
	}

}
