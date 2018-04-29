package ca.korichi.java10spark.api.routes.greeting;

import ca.korichi.java10spark.Parameters;
import ca.korichi.java10spark.api.JsonTransformer;
import spark.Route;
import spark.Service;

public class GreetingRoutes {

  private final Route greetingHandler;

  public GreetingRoutes(Route greetingHandler) {
    this.greetingHandler = greetingHandler;
  }

  public void init(Service httpService) {
    httpService.get(Parameters.Paths.GREETING, greetingHandler, new JsonTransformer());
  }
}
