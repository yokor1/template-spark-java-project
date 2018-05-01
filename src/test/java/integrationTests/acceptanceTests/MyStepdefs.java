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

import java.util.Random;


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
  public void setup() throws InterruptedException {
    fixture = new LargeFixture();
    Parameters.ACC_TEST_PORT = 11000 + new Random().nextInt(50);
    testServer = new AppServer(getAppHandlersFactory()).start(Parameters.ACC_TEST_PORT);
    testServer.awaitInitialization();
  }

  @After
  public void tearDown() throws InterruptedException {
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

  @Given("^an invalid token$")
  public void anInvalidToken() throws Throwable {
    // Write code here that turns the phrase above into concrete actions
    fixture.createInvalidToken();
  }


  @Then("^a <(\\d+)> request status is returned$")
  public void aRequestStatusIsReturned(int codeStatus) throws Throwable {
    // Write code here that turns the phrase above into concrete actions
    fixture.codeStatusIsEqualTo(codeStatus);
  }
}