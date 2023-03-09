package avit.keycloak.federation;

import avit.keycloak.WebhookConfig;
import org.jboss.logging.Logger;
import org.keycloak.Config;
import org.keycloak.KeycloakSecurityContext;
import org.keycloak.component.ComponentModel;
import org.keycloak.connections.jpa.JpaConnectionProvider;
import org.keycloak.events.EventStoreProvider;
import org.keycloak.events.jpa.AdminEventEntity;
import org.keycloak.models.KeycloakSession;
import org.keycloak.models.KeycloakSessionFactory;
import org.keycloak.models.RealmProvider;
import org.keycloak.provider.ProviderConfigProperty;
import org.keycloak.storage.UserStorageProviderFactory;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

public class WebhookFederationProviderFactory implements UserStorageProviderFactory<WebhookFederationProvider> {
    private static final Logger logger = Logger.getLogger(WebhookFederationProviderFactory.class);
    public static final String PROVIDER_NAME = "webhook";
    private List<AdminEventEntity> adminEvents;

    @Override
    public WebhookFederationProvider create(KeycloakSession session, ComponentModel model) {
        return new WebhookFederationProvider(session, model, this);
    }

    @Override
    public String getId() {
        return "webhook";
    }

    @Override
    public String getHelpText() {
        return "Call webhook when users change their data";
    }

    @Override
    public List<ProviderConfigProperty> getConfigProperties() {
//        KeycloakSession session = getContext().getRealm().getKeycloakSessionFactory().create();
//        JpaConnectionProvider jpaConnectionProvider = session.getProvider(JpaConnectionProvider.class);
//        EntityManager entityManager = jpaConnectionProvider.getEntityManager();
//        Query query = entityManager.createQuery("SELECT e FROM ADMIN_EVENT_ENTITY e");

        return WebhookConfig.getConfigProps();
    }


    @Override
    public void init(Config.Scope config) {

    }

    @Override
    public void postInit(KeycloakSessionFactory factory) {
//        EventStoreProvider eventStoreProvider = (EventStoreProvider) factory.getProviderFactory(EventStoreProvider.class);
//
//        eventStoreProvider.createQuery().realm(factory)
//        Query query = em.createQuery("FROM ADMIN_EVENT_ENTITY");
//
//        this.adminEvents = query.getResultList();
    }

    @Override
    public void close() {

    }
}