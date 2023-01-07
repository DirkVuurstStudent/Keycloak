package keycloak;

import org.keycloak.component.ComponentModel;
import org.keycloak.component.ComponentValidationException;
import org.keycloak.models.KeycloakSession;
import org.keycloak.models.RealmModel;
import org.keycloak.provider.ProviderConfigProperty;
import org.keycloak.provider.ProviderConfigurationBuilder;
import org.keycloak.storage.UserStorageProviderFactory;
// import org.keycloak.utils.StringUtil;

import java.util.List;

public class XMLProviderFactory implements UserStorageProviderFactory<XMLProvider> {

    public static final String PROVIDER_ID = "XML-provider";

    @Override
    public XMLProvider create(KeycloakSession session, ComponentModel model) {
        return new XMLProvider(session, model);
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

    @Override
    public void validateConfiguration(KeycloakSession session, RealmModel realm, ComponentModel config) throws ComponentValidationException {
//         if (StringUtil.isBlank(config.get(ConfigConstants.XML_PATH))) {
//             throw new ComponentValidationException("Configuration not properly set, please verify.");
//         }
    }
}