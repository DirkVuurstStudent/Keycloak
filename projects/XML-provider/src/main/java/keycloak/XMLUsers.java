package keycloak;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import java.util.List;

@XmlRootElement(name = "users")
public class XMLUsers {

    private List<XMLUser> users;

    @XmlElement(name = "user")
    public List<XMLUser> getUsers() {
        return users;
    }

    public void setUsers(List<XMLUser> users) {
        this.users = users;
    }
}