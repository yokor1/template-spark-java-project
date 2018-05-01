package integrationTests.acceptanceTests;

import ca.korichi.java10spark.Parameters;
import ca.korichi.java10spark.api.routes.heartbeat.HeartbeatResponseDto;
import io.restassured.response.ValidatableResponse;

import static io.restassured.RestAssured.given;
import static org.assertj.core.api.Assertions.assertThat;

public class LargeFixture implements Fixture {
  private String token;

  private ValidatableResponse validatableResponse;

  @Override
  public void clean() {

  }

  @Override
  public void createToken() {
    token = "aToken";
  }

  @Override
  public void requestBeat() {
    validatableResponse = given()
        .port(Parameters.ACC_TEST_PORT)
        .param("token", token)
        .contentType("application/json")
        .when()
        .get(Parameters.Paths.HEARTBEAT)
        .then();
  }

  @Override
  public void tokenIsReturned() {
    HeartbeatResponseDto heartbeatResponseDto =
        validatableResponse.extract().as(HeartbeatResponseDto.class);
    assertThat(heartbeatResponseDto.token).isEqualTo(token);

  }

  @Override
  public void timestampIsReturned() {
    HeartbeatResponseDto heartbeatResponseDto =
        validatableResponse.extract().as(HeartbeatResponseDto.class);
    assertThat(heartbeatResponseDto.timestamp).isNotNull();
  }

  @Override
  public void createInvalidToken() {
    token = null;
  }

  @Override
  public void codeStatusIsEqualTo(int codeStatus) {
    validatableResponse.statusCode(codeStatus);
  }
}
