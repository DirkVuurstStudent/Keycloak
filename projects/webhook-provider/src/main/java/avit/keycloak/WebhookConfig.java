package avit.keycloak;

import avit.keycloak.domain.WebhookAuthorizationType;
import avit.keycloak.domain.WebhookProtocol;
import avit.keycloak.federation.WebhookFederationProvider;
import lombok.Getter;
import org.jboss.logging.Logger;
import org.keycloak.common.util.MultivaluedHashMap;
import org.keycloak.events.jpa.AdminEventEntity;
import org.keycloak.provider.ProviderConfigProperty;
import org.keycloak.provider.ProviderConfigurationBuilder;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Getter
public class WebhookConfig {
    private static final Logger logger = Logger.getLogger(WebhookFederationProvider.class);
    protected MultivaluedHashMap<String, String> config;

    public List<String> webhookList = new ArrayList<>();

    public WebhookConfig(MultivaluedHashMap<String, String> config){
        this.config = config;
        this.initialize();
    }

    public static List<ProviderConfigProperty> getConfigProps() {
//        List<String> mappedAdminEvents = new ArrayList<>();
//
//        if (adminEvents != null) {
//            mappedAdminEvents = adminEvents.stream().map(AdminEventEntity::getRepresentation).collect(Collectors.toList());
//        }

        return ProviderConfigurationBuilder.create()
                .property().name("name")
                .label("Name")
                .defaultValue("")
                .type(ProviderConfigProperty.TEXT_TYPE)
                .add()
                .property().name("events")
                .label("Events")
                .helpText("Events that this webhook listens to")
                .defaultValue("")
                .options()
                .type(ProviderConfigProperty.LIST_TYPE)
                .add()
                .property().name("admin-events")
                .label("Admin events")
                .helpText("Admin events that this webhook listens to")
                .defaultValue("")
                .options()
                .type(ProviderConfigProperty.LIST_TYPE)
                .add()
                .property().name("authorization-type")
                .label("Authorization type")
                .helpText("Authorization method used to authorize to the given protocol")
                .defaultValue("")
                .options(Stream.of(WebhookAuthorizationType.values()).map(WebhookAuthorizationType::name).collect(Collectors.toList()))
                .type(ProviderConfigProperty.LIST_TYPE)
                .add()
                .property().name("protocol")
                .label("Protocol")
                .helpText("Webhook protocol used to send data")
                .defaultValue("")
                .options(Stream.of(WebhookProtocol.values()).map(WebhookProtocol::name).collect(Collectors.toList()))
                .type(ProviderConfigProperty.LIST_TYPE)
                .add()
                .property().name("url")
                .label("URL")
                .helpText("URL where event data is sent to")
                .defaultValue("")
                .type(ProviderConfigProperty.TEXT_TYPE)
                .add()
                .property().name("username")
                .label("Username")
                .helpText("Username used for authenticating to the given authorization method")
                .defaultValue("")
                .type(ProviderConfigProperty.TEXT_TYPE)
                .add()
                .property().name("password")
                .label("Password")
                .helpText("Password used for authenticating to the given authorization method")
                .defaultValue("")
                .type(ProviderConfigProperty.TEXT_TYPE)
                .add()
                .build();
    }

    protected MultivaluedHashMap<String, String> getConfig() {
        return config;
    }

    protected void initialize(){
        if (this.config == null) return;

        this.webhookList = this.config.getList("webhook-list");
    }
}