package se.yolean.gitea.client.auth;

import java.io.IOException;

import org.eclipse.microprofile.config.inject.ConfigProperty;

import io.quarkus.logging.Log;
import jakarta.enterprise.context.RequestScoped;
import jakarta.ws.rs.Priorities;
import jakarta.ws.rs.client.ClientRequestContext;
import jakarta.ws.rs.client.ClientRequestFilter;
import jakarta.ws.rs.core.HttpHeaders;

import jakarta.annotation.Priority;

@Priority(Priorities.AUTHENTICATION)
@RequestScoped
public class GiteaAuthFilter implements ClientRequestFilter {

  @ConfigProperty(name = "quarkus.rest-client.gitea.api-key")
  String apiKey;

  @Override
  public void filter(ClientRequestContext requestContext) throws IOException {
    if (Log.isDebugEnabled()) Log.debug("gitea " + requestContext.getMethod() + " " + requestContext.getUri());
    requestContext.getHeaders().add(HttpHeaders.AUTHORIZATION, "token " + apiKey);
  }

}
