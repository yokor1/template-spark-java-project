package routes.greeting;

import ca.korichi.java10spark.Parameters;
import ca.korichi.java10spark.api.routes.greeting.GreetingResponseDto;
import io.restassured.response.Response;
import org.junit.jupiter.api.Test;
import routes.TestServerWithMockedHandlers;

import static io.restassured.RestAssured.given;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.willReturn;


class GreetingHandlerEdgeITest extends TestServerWithMockedHandlers {


  @Test
  public void givenGreetingHandler_whenGreetCalled_thenReturnGreeting() {

    GreetingResponseDto expected_greet =
        new GreetingResponseDto().setMessage("Good Morning Sir.");
    willReturn(expected_greet).given(greetingService).greet();

    Response response = given().port(Parameters.DEV_PORT)
        .contentType("application/json")
        .get(Parameters.Paths.GREETING);

    assertThat(response.statusCode()).isEqualTo(200);
    GreetingResponseDto greeting = response.then().extract().body().as(GreetingResponseDto.class);
    assertThat(expected_greet).isEqualTo(greeting);
  }
}