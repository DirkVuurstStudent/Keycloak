package avit.keycloak.authorizations;

import avit.keycloak.WebhookProtocols;

abstract public class AbstractAuthorization {
    private String name;
    private WebhookProtocols protocol;

    public AbstractAuthorization(String name, WebhookProtocols protocol) {
        this.name = name;
        this.protocol = protocol;
    }

    public String getName() {
        return this.name;
    }

    public WebhookProtocols getProtocol() {
        return this.protocol;
    }

    abstract public void sendData();
}
