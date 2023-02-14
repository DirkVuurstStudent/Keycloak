package avit.keycloak;

import org.keycloak.component.ComponentModel;
import org.keycloak.models.KeycloakSession;
import org.keycloak.provider.ProviderConfigProperty;
import org.keycloak.provider.ProviderConfigurationBuilder;
import org.keycloak.storage.UserStorageProviderFactory;

import java.util.List;

public class WebhookStorageProviderFactory implements UserStorageProviderFactory<WebhookStorageProvider> {
    @Override
    public WebhookStorageProvider create(KeycloakSession keycloakSession, ComponentModel componentModel) {
        Map<ComponentModel, LDAPConfigDecorator> configDecorators = getLDAPConfigDecorators(session, model);

        LDAPIdentityStore ldapIdentityStore = this.ldapStoreRegistry.getLdapStore(session, model, configDecorators);
        return new LDAPStorageProvider(this, session, model, ldapIdentityStore);
    }

    @Override
    public String getId() {
        return "webhook-storage-provider";
    }

    @Override
    public List<ProviderConfigProperty> getConfigProperties() {
        return ProviderConfigurationBuilder.create()
                .property().name("");
    }
}
