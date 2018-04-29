package ca.korichi.java10spark.api.routes.greeting;

import java.util.Objects;

public class GreetingResponseDto {
  public String message;

  public GreetingResponseDto setMessage(String message) {
    this.message = message;
    return this;
  }

  @Override
  public boolean equals(Object other) {
    if (this == other) {
      return true;
    }
    if (other == null || getClass() != other.getClass()) {
      return false;
    }
    GreetingResponseDto that = (GreetingResponseDto) other;
    return Objects.equals(message, that.message);
  }

  @Override
  public int hashCode() {
    return Objects.hash(message);
  }
}
