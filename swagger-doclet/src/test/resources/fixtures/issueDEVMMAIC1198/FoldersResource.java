package fixtures.issueDEVMMAIC1198;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import java.math.BigDecimal;

@Path("/folders")
public class FoldersResource {

    /**
     * Returns the mailbox folder for the given mailbox id
     *
     * @pathType id string
     * @param id The mailbox id parameter
     * @param mailboxe the mailbox name parameter
     * @return the mailbox id
     */
    @Path("multi/{id}")
    @GET
    public FoldersRepresentation getMulti(@PathParam("id") MailboxName id,
                                          Mailbox mailbox) {
        return new FoldersRepresentation(mailbox);
    }

    /**
     * @pathType id string mailbox integer
     * @param id
     * @param mailbox
     * @return
     */
    @Path("/{id}/{number}")
    @GET
    public String getId(@PathParam("id") MailboxName id, @PathParam("number") Mailbox mailbox) {
        return "test";
    }
}