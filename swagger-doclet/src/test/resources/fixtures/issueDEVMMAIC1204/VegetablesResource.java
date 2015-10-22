package fixtures.issueDEVMMAIC1204;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 * @responseMessage 404 not found
 * @defaultErrorType fixtures.issueDEVMMAIC1204.VegetableErrorType
 */
@Path("vegetables")
public class VegetablesResource {

    /**
     * @responseMessage 302 redirect
     */
    @GET
    public void redirect() {
        return;
    }

    /**
     * @responseMessage 200 ok
     * @param name
     * @return
     */
    @Path("{name}")
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public Response echo(@PathParam("name") String name) {
        return Response.ok(name).build();
    }

    /**
     * @responseMessage 200 ok
     * @param name
     * @return
     */
    @Path("{name}")
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public Response vegetableJson(@PathParam("name") String name) {
        return Response.ok(new Vegetable(name)).build();
    }
}