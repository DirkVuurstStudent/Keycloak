package keycloak;

import java.io.File;
import java.io.FileInputStream;
import java.util.List;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.Unmarshaller;
import org.keycloak.component.ComponentModel;
import org.keycloak.models.KeycloakSession;
import org.keycloak.models.UserModel;
import org.keycloak.models.RealmModel;
import org.keycloak.models.UserProvider;
import org.keycloak.models.utils.UserModelDelegate;
import org.keycloak.storage.UserStorageProvider;
import org.keycloak.storage.user.UserLookupProvider;
import org.keycloak.storage.user.UserQueryProvider;
import org.keycloak.storage.UserStorageProviderFactory;

public class XMLProvider implements UserStorageProvider,
    UserLookupProvider {

    private KeycloakSession session;
    private ComponentModel model;
    private RealmModel realm;
    private UserProvider userProvider;
    private File xmlFile;

    public XMLProvider(
        KeycloakSession session,
        ComponentModel model,
        RealmModel realm,
        UserProvider userProvider
    ) {
        this.session = session;
        this.realm = realm;
        this.model = model;
        this.userProvider = userProvider;
    }

    @Override
    public void close() {
        try {
            JAXBContext jaxbContext = JAXBContext.newInstance(XMLUsers.class);
            Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
            FileInputStream fileInputStream = new FileInputStream(model.getConfig().getFirst("Path"));
            XMLUsers users = (XMLUsers) jaxbUnmarshaller.unmarshal(fileInputStream);
            for (XMLUser user : users.getUsers()) {
                UserModel userModel = userProvider.addUser(realm, user.getUsername());
                userModel.setEmail(user.getEmail());
                userModel.setFirstName(user.getFirstName());
                userModel.setLastName(user.getLastName());
            }
        } catch (Exception e) {
            throw new RuntimeException("Failed to import users from XML file", e);
        }
    }

    @Override
    public UserModel getUserByUsername(String username, RealmModel realm) {
        // TODO: Implement
        return null;
    }

    @Override
    public UserModel getUserByEmail(String email, RealmModel realm) {
        // TODO: Implement
        return null;
    }

    @Override
    public UserModel getUserById(String id, RealmModel realm) {
        // TODO: Implement
        return null;
    }
}