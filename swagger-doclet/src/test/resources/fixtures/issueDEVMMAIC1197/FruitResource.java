package fixtures.issueDEVMMAIC1197;

import javax.ws.rs.GET;
import javax.ws.rs.Path;

@Path("fruits")
public class FruitResource {

    @GET
    public FruitHolder getFruitHolder() {
        return new FruitHolder();
    }
}
