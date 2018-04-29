package ca.korichi.java10spark.api.routes.greeting;

import ca.korichi.java10spark.Parameters;
import ca.korichi.java10spark.service.greeting.GreetingService;
import spark.Request;
import spark.Response;
import spark.Route;

public class GreetingHandler implements Route {
  private GreetingService greetingService;

  public GreetingHandler(GreetingService greetingService) {
    this.greetingService = greetingService;
  }

  @Override
  public GreetingResponseDto handle(Request request, Response response) {
    response.status(Parameters.Status.OK);
    return greetingService.greet();
  }
}
