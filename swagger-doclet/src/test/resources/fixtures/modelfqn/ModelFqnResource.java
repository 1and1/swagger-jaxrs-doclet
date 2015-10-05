package fixtures.modelfqn;

import java.util.Collection;

import javax.ws.rs.GET;
import javax.ws.rs.Path;

@Path("/modelfqn")
@SuppressWarnings("javadoc")
public class ModelFqnResource {

	@GET
	@Path("/data")
	public Data getData() {
		return null;
	}

	@GET
	@Path("/id1col")
	public Collection<fixtures.modelfqn.sub1.Id> getId1Col() {
		return null;
	}

	@GET
	@Path("/id2col")
	public Collection<fixtures.modelfqn.sub2.Id> getId2Col() {
		return null;
	}

}
