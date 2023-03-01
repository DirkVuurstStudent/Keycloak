package avit.keycloak.domain;

import org.keycloak.connections.jpa.entityprovider.JpaEntityProvider;

import java.util.Collections;
import java.util.List;

public class WebhookEntityProvider implements JpaEntityProvider {
    @Override
    public List<Class<?>> getEntities() {
        return Collections.singletonList(Webhook.class);
    }

    @Override
    public String getChangelogLocation() {
        return "META-INF/webhook-changelog.xml";
    }

    @Override
    public String getFactoryId() {
        return WebhookEntityProviderFactory.ID;
    }

    @Override
    public void close() {

    }
}
