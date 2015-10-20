package fixtures.issueDEVMMAIC1198;

public class Mailbox {

    private String id;

    /**
     * The constructor
     * @param id the mailbox id
     */
    public Mailbox(String id) {
        this.id = id;
    }

    /**
     * Returns the mailbox id
     * @return the mailbox id parameter
     */
    public String getId() {
        return id;
    }

    /**
     * Sets the mailbox id
     * @param id the mailbox id parameter
     */
    public void setId(String id) {
        this.id = id;
    }
}