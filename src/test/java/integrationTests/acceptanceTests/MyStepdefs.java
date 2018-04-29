package integrationTests.acceptanceTests;

import ca.korichi.java10spark.Parameters;
import ca.korichi.java10spark.api.AppServer;
import ca.korichi.java10spark.context.AppHandlersFactory;
import ca.korichi.java10spark.context.AppHandlersFactoryTemplate;
import ca.korichi.java10spark.service.heartbeat.HeartbeatService;
import ca.korichi.java10spark.service.heartbeat.LessInfosHeartbeatService;
import ca.korichi.java10spark.service.heartbeat.SystemClock;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import spark.Service;

public class MyStepdefs {
  private Fixture fixture;
  private Service testServer;

  private static AppHandlersFactory getAppHandlersFactory() {
    return new AppHandlersFactoryTemplate() {
      @Override
      protected HeartbeatService createHeartbeatService() {
        return new LessInfosHeartbeatService(new SystemClock());
      }
    };
  }

  @Before
  public void setup() {
    fixture = new LargeFixture();
    System.out.println("start test server");
    testServer = new AppServer(getAppHandlersFactory()).start(Parameters.DEV_PORT);
  }

  @After
  public void tearDown() {
    fixture.clean();
    testServer.stop();
  }

  @Given("^a token$")
  public void aToken() {
    fixture.createToken();
  }

  @When("^beat is requested$")
  public void beatIsRequested() {
    fixture.requestBeat();
  }

  @Then("^the token is returned$")
  public void theTokenIsReturned() {
    fixture.tokenIsReturned();
  }

  @Then("^a timestamp is returned$")
  public void aTimestampIsReturned() {
    fixture.timestampIsReturned();
  }
}