package avit.keycloak;

import avit.keycloak.authorizations.AbstractAuthorization;
import org.keycloak.events.Event;
import org.keycloak.events.admin.AdminEvent;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Webhook {
    private String name;
    private AbstractAuthorization authorization;
    private Set<Event> events = new HashSet<>();
    private Set<AdminEvent> adminEvents = new HashSet<>();

    public Webhook(String name, AbstractAuthorization authorization) {
        this.name = name;
        this.authorization = authorization;
    }

    public void addEvent(AdminEvent event) {
        this.adminEvents.add(event);
    }

    public void addEvent(Event event) {
        this.events.add(event);
    }
}
