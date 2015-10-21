package fixtures.issueDEVMMAIC1198;

import javax.xml.bind.annotation.adapters.XmlAdapter;

public class MailboxNameAdapter extends XmlAdapter<String, MailboxName> {
    @Override
    public MailboxName unmarshal(String v) throws Exception {
        return MailboxName.valueOf(v);
    }

    @Override
    public String marshal(MailboxName v) throws Exception {
        return String.valueOf(v.getId());
    }
}
