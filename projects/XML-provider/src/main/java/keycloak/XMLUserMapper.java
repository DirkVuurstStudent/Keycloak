package keycloak;

public class XMLUserMapper  {
    public XMLUser mapXMLToXMLUser(String XML) {
        XMLUser XMLUser = new XMLUser();
        XMLUser.setExternalId();
        XMLUser.setUsername();
        XMLUser.setFirstName();
        XMLUser.setLastName();
        XMLUser.setEmail();

        return XMLUser;
    }

    public UserModel XMLUserToUserModel(XMLUser XMLUser) {
        UserModel user = new UserModel();
        user.setAttribute("externalId", XMLUser.getExternalId());
        user.setUsername(XMLUser.getUsername());
        user.setFirstName(XMLUser.getFirstName());
        user.setLastName(XMLUser.getLastName());
        user.setEmail(XMLUser.getEmail());

        return user;
    }
}