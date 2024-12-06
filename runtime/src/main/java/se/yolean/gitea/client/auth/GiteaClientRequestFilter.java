package se.yolean.gitea.client.auth;

import java.io.IOException;

import org.eclipse.microprofile.config.inject.ConfigProperty;

import io.quarkus.logging.Log;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import jakarta.ws.rs.Priorities;
import jakarta.ws.rs.client.ClientRequestContext;
import jakarta.ws.rs.client.ClientRequestFilter;

import jakarta.annotation.Priority;

@Priority(Priorities.AUTHENTICATION)
@RequestScoped
public class GiteaClientRequestFilter implements ClientRequestFilter {

  @ConfigProperty(name = "quarkus.rest-client.gitea.api-key")
  String apiKey;

  @Inject
  GiteaAuth auth;

  @Override
  public void filter(ClientRequestContext requestContext) throws IOException {
    if (Log.isDebugEnabled()) Log.debug("gitea " + requestContext.getMethod() + " " + requestContext.getUri());
    auth.filter(requestContext);
  }

}
