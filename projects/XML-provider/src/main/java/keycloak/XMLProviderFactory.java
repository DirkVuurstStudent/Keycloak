package keycloak;

import org.keycloak.component.ComponentModel;
import org.keycloak.component.ComponentValidationException;
import org.keycloak.models.KeycloakSession;
import org.keycloak.models.UserProvider;
import org.keycloak.models.RealmModel;
import org.keycloak.provider.ProviderConfigProperty;
import org.keycloak.provider.ProviderConfigurationBuilder;
import org.keycloak.storage.UserStorageProviderFactory;

import java.util.List;

public class XMLProviderFactory implements UserStorageProviderFactory<XMLProvider> {

    public static final String PROVIDER_ID = "XML-provider";

    @Override
    public XMLProvider create(KeycloakSession session, ComponentModel model) {
        RealmModel realm = session.getContext().getRealm();
        UserProvider userProvider = session.getProvider(UserProvider.class);;
        return new XMLProvider(session, model, realm, userProvider);
    }

    @Override
    public String getId() {
        return PROVIDER_ID;
    }

    @Override
    public String getHelpText() {
        return "XML user provider";
    }

    @Override
    public List<ProviderConfigProperty> getConfigProperties() {
        return ProviderConfigurationBuilder.create()
            .property(ConfigConstants.XML_PATH, "Path", "Path to XML file", ProviderConfigProperty.STRING_TYPE, "", null)
            .build();
    }
}