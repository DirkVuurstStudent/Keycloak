package avit.keycloak.authorizations.http;

import avit.keycloak.domain.WebhookProtocol;
import avit.keycloak.authorizations.AbstractAuthorization;

import javax.json.JsonObject;

public class BasicAuthAuthorization extends AbstractAuthorization {
    private String url;
    private String username;
    private String password;

    public BasicAuthAuthorization(String url, String username, String password) {
        super("Http Basic Auth", WebhookProtocol.HTTP);

        this.url = url;
        this.username = username;
        this.password = password;
    }

    @Override
    public void sendData(JsonObject data) {

    }
}
