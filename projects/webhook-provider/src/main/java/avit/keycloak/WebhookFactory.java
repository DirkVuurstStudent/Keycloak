package avit.keycloak;

import avit.keycloak.authorizations.AbstractAuthorization;
import avit.keycloak.authorizations.http.BasicAuthAuthorization;
import avit.keycloak.domain.Webhook;
import avit.keycloak.domain.WebhookAuthorization;
import org.json.simple.JSONObject;

public class WebhookFactory {
    private AbstractAuthorization authorization;
    public WebhookFactory(Webhook webhook) {
        WebhookAuthorization authorization = webhook.getAuthorization();

        switch (authorization.getProtocol()) {
            case HTTP:
                switch (authorization.getAuthorization()) {
                    case BASIC_AUTH:
                        String url = webhook.getConfig().getString("url");
                        String username = webhook.getConfig().getString("url");
                        String password = webhook.getConfig().getString("url");

                        this.authorization = new BasicAuthAuthorization(url, username, password);
                }
        }
    }

    public void sendData(JSONObject data) {
        this.authorization.sendData(data);
    }
}
