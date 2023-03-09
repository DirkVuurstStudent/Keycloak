package avit.keycloak.domain;

import javax.persistence.*;

@Entity
@Table(name = "AVIT_WEBHOOK_AUTHORIZATIONS")
public class WebhookAuthorization {
    @Id
    private int id;

    private String name;

    @Enumerated(EnumType.ORDINAL)
    private WebhookAuthorizationType authorization;

    @Enumerated(EnumType.ORDINAL)
    private WebhookProtocol protocol;

    public WebhookProtocol getProtocol() {
        return this.protocol;
    }

    public WebhookAuthorizationType getAuthorization() {
        return this.authorization;
    }
}
