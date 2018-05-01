package ca.korichi.java10spark.api.routes;

public class InvalidUserInputException extends RuntimeException {
  public InvalidUserInputException(String message) {
    super(message);
  }
}
