package integrationTests.acceptanceTests;

import ca.korichi.java10spark.Parameters;
import ca.korichi.java10spark.api.routes.heartbeat.HeartbeatResponseDto;

import static io.restassured.RestAssured.given;
import static org.assertj.core.api.Assertions.assertThat;

public class LargeFixture implements Fixture {
  private String token;
  private String returnedToken;
  private long returnedTimestamp;

  @Override
  public void clean() {

  }

  @Override
  public void createToken() {
    token = "aToken";
  }

  @Override
  public void requestBeat() {
    HeartbeatResponseDto expectedHeartbeatDTO =
        new HeartbeatResponseDto()
            .setToken(token);
    HeartbeatResponseDto heartbeatResponseDto = given()
        .port(Parameters.DEV_PORT)
        .param("token", expectedHeartbeatDTO.token)
        .contentType("application/json")
        .when()
        .get(Parameters.Paths.HEARTBEAT)
        .then()
        .statusCode(200)
        .extract().as(HeartbeatResponseDto.class);
    returnedToken = heartbeatResponseDto.token;
    returnedTimestamp = heartbeatResponseDto.timestamp;

  }

  @Override
  public void tokenIsReturned() {

    assertThat(returnedToken).isEqualTo(token);

  }

  @Override
  public void timestampIsReturned() {
    assertThat(returnedTimestamp).isNotNull();
  }
}
