package avit.keycloak.authorizations.http;

import avit.keycloak.WebhookProtocols;
import avit.keycloak.authorizations.AbstractAuthorization;
import okhttp3.Credentials;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

import java.io.IOException;

public class BasicAuthAuthorization extends AbstractAuthorization {
    private String url;
    private String username;
    private String password;

    public BasicAuthAuthorization(String url, String username, String password) {
        super("Http Basic Auth", WebhookProtocols.HTTP);

        this.url = url;
        this.username = username;
        this.password = password;
    }

    @Override
    public void sendData() {
        Request.Builder request_builder = new Request.Builder().url(this.url).addHeader("User-Agent", "Keycloak Webhook");

        if (this.username != null && this.password != null) {
            String credential = Credentials.basic(this.username, this.password);
            request_builder.addHeader("Authorization", credential);
        }

        Request request = request_builder.post(RequestBody.create(jsonString, JSON)).build();

        try (Response response = httpClient.newCall(request).execute()) {
            if (!response.isSuccessful()) {
                log.error(String.format("Failed to POST webhook: %s %s",  response.code(), response.message()));
            }
        } catch (IOException e) {
            log.error("Failed to POST webhook:", e);
        }
    }
}
