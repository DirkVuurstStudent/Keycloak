package avit.keycloak.authorizations;

import avit.keycloak.domain.WebhookProtocol;
import org.json.simple.JSONObject;

abstract public class AbstractAuthorization {
    private String name;
    private WebhookProtocol protocol;

    public AbstractAuthorization(String name, WebhookProtocol protocol) {
        this.name = name;
        this.protocol = protocol;
    }

    public String getName() {
        return this.name;
    }

    public WebhookProtocol getProtocol() {
        return this.protocol;
    }

    abstract public void sendData(JSONObject data);
}
