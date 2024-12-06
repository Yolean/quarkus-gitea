package se.yolean.gitea.client.auth;

import io.smallrye.config.ConfigMapping;

/**
 * Custom config properties for REST client, reusing the default parent.
 */
@ConfigMapping(prefix = "quarkus.rest-client.gitea")
public interface GiteaClientConfig {

  String apiKey();

}
