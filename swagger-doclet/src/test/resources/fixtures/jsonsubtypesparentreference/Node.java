package fixtures.jsonsubtypesparentreference;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonSubTypes.Type;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

import javax.xml.bind.annotation.XmlRootElement;

@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.PROPERTY, property = "type")
@JsonSubTypes(
        {
        @Type(name = "file", value = File.class),
        @Type(name = "folder", value = Folder.class)
        }
)
@XmlRootElement
public interface Node {
    Node getParent();
}
