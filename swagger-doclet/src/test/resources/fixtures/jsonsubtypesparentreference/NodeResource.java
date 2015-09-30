package fixtures.jsonsubtypesparentreference;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;

@Path("node")
public class NodeResource {

    @Path("{id}")
    @GET
    public Node getNode(@PathParam("id") String id) {
        return null;
    }

}
