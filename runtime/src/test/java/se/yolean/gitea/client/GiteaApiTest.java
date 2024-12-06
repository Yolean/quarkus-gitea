package se.yolean.gitea.client;

import java.time.Instant;

import org.eclipse.microprofile.rest.client.inject.RestClient;
import org.junit.jupiter.api.Test;

import io.quarkus.test.junit.QuarkusTest;
import se.yolean.gitea.client.api.IssueApi;
import se.yolean.gitea.client.model.CreateIssueOption;

@QuarkusTest
public class GiteaApiTest {

  @RestClient
  IssueApi issues;

  @Test
  public void testIssue() {
    issues.issueCreateIssue("apitest", "test1", new CreateIssueOption()
        .title("" + Instant.now()));
  }

}
