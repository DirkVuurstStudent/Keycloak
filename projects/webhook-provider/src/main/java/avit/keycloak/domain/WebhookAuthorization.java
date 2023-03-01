package avit.keycloak.domain;

import javax.persistence.*;

@Entity
@Table(name = "AVIT_WEBHOOK_AUTHORIZATIONS")
public class WebhookAuthorization {
    @Id
    private int id;

    @Enumerated(EnumType.ORDINAL)
    private WebhookProtocol protocol;
}
