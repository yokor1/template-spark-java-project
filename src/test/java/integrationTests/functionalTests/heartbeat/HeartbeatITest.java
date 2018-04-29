package integrationTests.functionalTests.heartbeat;

import ca.korichi.java10spark.Parameters;
import ca.korichi.java10spark.api.routes.heartbeat.HeartbeatResponseDto;
import integrationTests.functionalTests.TestServer;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.assertj.core.api.Assertions.assertThat;

//@Disabled
class HeartbeatITest extends TestServer {

  @Test
  @DisplayName("when beat is requested the server returns the provided token")
  public void whenBeatIsRequested_thenTheServerReturnsTheProvidedToken() {

    String aToken = "token";
    long aTimestamp = 100;
    HeartbeatResponseDto expectedHeartbeatDTO = new HeartbeatResponseDto()
        .setToken(aToken).setTimestamp(aTimestamp);

    HeartbeatResponseDto heartbeatResponseDto = given()
        .port(Parameters.DEV_PORT)
        .param("token", expectedHeartbeatDTO.token)
        .contentType("application/json")
        .when()
        .get(Parameters.Paths.HEARTBEAT)
        .then()
        .extract().as(HeartbeatResponseDto.class);


    assertThat(heartbeatResponseDto.token).isEqualToIgnoringCase(expectedHeartbeatDTO.token);
  }

  @Test
  @DisplayName("when beat is requested the server returns a timestamp")
  public void whenBeatIsRequested_thenTheServerReturnsATimestamp() {

    String aToken = "token";
    long aTimestamp = 100;
    HeartbeatResponseDto expectedHeartbeatDTO = new HeartbeatResponseDto()
        .setToken(aToken).setTimestamp(aTimestamp);

    HeartbeatResponseDto heartbeatResponseDto = given()
        .port(Parameters.DEV_PORT)
        .param("token", expectedHeartbeatDTO.token)
        .contentType("application/json")
        .when()
        .get(Parameters.Paths.HEARTBEAT)
        .then()
        .extract().as(HeartbeatResponseDto.class);

    assertThat(heartbeatResponseDto.timestamp).isNotNull();
  }

  @Test
  @DisplayName("when beat is requested the server returns 200 as status")
  public void whenBeatIsRequested_thenTheServerReturnsOKStatus() {

    String aToken = "token";
    long aTimestamp = 100;
    HeartbeatResponseDto expectedHeartbeatDTO = new HeartbeatResponseDto()
        .setToken(aToken).setTimestamp(aTimestamp);
    int expectedStatusCode = Parameters.Status.OK;

    given().port(Parameters.DEV_PORT)
        .param("token", expectedHeartbeatDTO.token)
        .contentType("application/json")
        .when()
        .get(Parameters.Paths.HEARTBEAT)
        .then()
        .statusCode(expectedStatusCode);
  }


}