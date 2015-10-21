package fixtures.issueDEVMMAIC1198;

public class MailboxName {

    private long id;

    public static MailboxName valueOf(String id) {
        return new MailboxName(id);
    }

    public MailboxName(String id) {
        this.id = Long.parseLong(id);
    }

    public long getId() {
        return id;
    }
}