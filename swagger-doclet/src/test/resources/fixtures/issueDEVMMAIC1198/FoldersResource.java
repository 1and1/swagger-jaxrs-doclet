package fixtures.issueDEVMMAIC1198;


import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

@Path("/folders")
public class FoldersResource {

    /**
     * @pathType id string
     * @param id the mailbox id param
     * @return the mailbox id
     */
    @XmlJavaTypeAdapter(type = MailboxName.class, value = MailboxNameAdapter.class)
    @Path("echo/{id}")
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public Response echoId(@PathParam("id") MailboxName id) {
        return Response.ok(id.getId()).build();
    }
}