package se.yolean.gitea.client.auth;

import io.quarkus.arc.DefaultBean;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.ws.rs.client.ClientRequestContext;
import jakarta.ws.rs.core.HttpHeaders;

/**
 * Fallback impl of {@link GiteaAuth} using configured api-key.
 */
@ApplicationScoped
@DefaultBean
public class GiteaAuthStaticApiKey implements GiteaAuth {

  @Inject
  GiteaClientConfig config;

  @Override
  public void filter(ClientRequestContext requestContext) {
    requestContext.getHeaders().add(HttpHeaders.AUTHORIZATION, "token " + config.apiKey());
  }

}
