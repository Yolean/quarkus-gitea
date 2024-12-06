package se.yolean.gitea.client.auth;

import jakarta.ws.rs.client.ClientRequestContext;

public interface GiteaAuth {

  /**
   * @param requestContext from {@link jakarta.ws.rs.client.ClientRequestFilter#filter(ClientRequestContext)}
   */
  void filter(ClientRequestContext requestContext);

}
