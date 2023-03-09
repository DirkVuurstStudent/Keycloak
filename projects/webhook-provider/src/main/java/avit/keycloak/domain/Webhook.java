package avit.keycloak.domain;

import javax.json.Json;
import javax.json.JsonObject;
import javax.persistence.*;
import java.io.StringReader;
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

    private String config;

    @ElementCollection
    @CollectionTable(name = "webhook_events", joinColumns = @JoinColumn(name = "id"))
    @Column(name = "EVENTS")
    private List<String> events;

    @ElementCollection
    @CollectionTable(name = "webhook_admin_events", joinColumns = @JoinColumn(name = "id"))
    @Column(name = "ADMIN_EVENTS")
    private List<String> adminEvents;

    public WebhookAuthorization getAuthorization() {
        return this.authorization;
    }

    public void setConfig(JsonObject config) {
        this.config = config.toString();
    }

    public JsonObject getConfig() {
        return Json.createParser(new StringReader(this.config)).getObject();
    }
}
