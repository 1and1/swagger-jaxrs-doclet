package fixtures.issueDEVMMAIC1198;


import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;


@Path("/folders")
public class FoldersResource {

    /**
     * @pathType id string
     * @param id the MailboxName id parameter
     * @return the MailboxName id
     */
    @Path("echo/{id}")
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public Response echoId(@PathParam("id") MailboxName id) {
        return Response.ok(id.getId()).build();
    }

    /**
     * Returns the folder for the given MailboxName id
     * @param id the MailboxName id parameter
     * @return the folder representation
     */
    @Path("{id}")
    @GET
    public FoldersRepresentation folder(@PathParam("id") MailboxName id) {
        return new FoldersRepresentation(new Mailbox(String.valueOf(id.getId())));
    }
}