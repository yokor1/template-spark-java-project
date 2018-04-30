package ca.korichi.java10spark.api;

import ca.korichi.java10spark.Parameters;
import ca.korichi.java10spark.api.routes.InvalidUserInputException;
import spark.Service;

public class ExceptionsMapping {

  public void init(Service httpService) {
    httpService.exception(InvalidUserInputException.class,
        (exception, request, response) -> {
          response.status(Parameters.Status.BAD_REQUEST);
          response.body(String.format("{\"message\":\"%s\"}", exception.getMessage()));
        });
  }
}
