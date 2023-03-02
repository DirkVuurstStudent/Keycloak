package avit.keycloak.domain;

import javax.json.JsonObject;
import javax.persistence.*;
import java.util.List;
import org.json.simple.JSONObject;
import org.json.simple.JSONValue;

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

    public void setConfig(JSONObject config) {
        this.config = config.toString();
    }

    public JsonObject getConfig() {
        return (JsonObject) JSONValue.parse(this.config);
    }
}
