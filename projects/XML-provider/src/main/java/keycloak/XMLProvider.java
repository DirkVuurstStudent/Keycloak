package keycloak;

import org.keycloak.component.ComponentModel;
import org.keycloak.models.KeycloakSession;
import org.keycloak.storage.UserStorageProvider;

public class XMLProvider implements UserStorageProvider {
    private final KeycloakSession session;
    private final ComponentModel model;

	public XMLProvider(KeycloakSession session, ComponentModel model) {
		this.session = session;
		this.model = model;
	}

	@Override
	public void close() {}
}