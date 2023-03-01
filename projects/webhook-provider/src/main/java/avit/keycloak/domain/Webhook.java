package avit.keycloak.domain;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "AVIT_WEBHOOKS")
public class Webhook {
    @Id
    private int id;

    private String name;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "AUTHORIZATION_ID", nullable = false)
    private WebhookAuthorization authorization;

    @ElementCollection
    @CollectionTable(name = "webhook_events", joinColumns = @JoinColumn(name = "id"))
    @Column(name = "EVENTS")
    private List<String> events;

    @ElementCollection
    @CollectionTable(name = "webhook_admin_events", joinColumns = @JoinColumn(name = "id"))
    @Column(name = "ADMIN_EVENTS")
    private List<String> adminEvents;


}
