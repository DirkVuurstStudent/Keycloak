package keycloak;

import org.keycloak.Config;
import org.keycloak.events.EventListenerProvider;
import org.keycloak.events.EventListenerProviderFactory;
import org.keycloak.models.KeycloakSession;
import org.keycloak.models.KeycloakSessionFactory;

public class HttpWebhookProviderFactory implements EventListenerProviderFactory {
    private String serverUrl;
    private String username;
    private String password;

    @Override
    public EventListenerProvider create(KeycloakSession keycloakSession) {

        return new HttpWebhookProvider(serverUrl, username, password);
    }

    @Override
    public void init(Config.Scope config_scope) {
        serverUrl = config_scope.get("serverUrl");
        username = config_scope.get("username");
        password = config_scope.get("password");
    }

    @Override
    public void postInit(KeycloakSessionFactory keycloakSessionFactory) {

    }

    @Override
    public void close() {

    }

    @Override
    public String getId() {
        return "webhook";
    }
}