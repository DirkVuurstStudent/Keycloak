package keycloak;

import org.keycloak.component.ComponentModel;
import org.keycloak.models.KeycloakSession;
import org.keycloak.storage.UserStorageProvider;
import org.keycloak.storage.user.UserLookupProvider;
import org.keycloak.storage.user.UserQueryProvider;
import org.keycloak.storage.user.UserRegistrationProvider;

import java.util.HashMap;
import java.util.Map;

public class XMLProvider implements UserStorageProvider,
    UserLookupProvider, UserQueryProvider,
    UserRegistrationProvider {

    private final KeycloakSession session;
    private final ComponentModel model;

    protected Map<String, UserModel> loadedUsers = new HashMap<>();

	public XMLProvider(KeycloakSession session, ComponentModel model) {
		this.session = session;
		this.model = model;
	}

	@Override
	public void close() {}

    @Override
    public UserModel addUser(RealmModel realm, String username) {
        return null;
    }

    @Override
    public boolean removeUser(RealmModel realm, UserModel user) {
        return false;
    }

    private UserModel mapUser() {
        XMLUserMapper userMapper = new XMLUserMapper();
        XMLUser XMLUser = userMapper.mapXMLToXMLUser();
        UserModel userModel = userMapper.XMLUserToUserModel(UserModel userModel);
    }
}