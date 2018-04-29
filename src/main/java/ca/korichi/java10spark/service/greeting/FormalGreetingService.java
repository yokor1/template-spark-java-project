package ca.korichi.java10spark.service.greeting;


import ca.korichi.java10spark.api.routes.greeting.GreetingResponseDto;

public class FormalGreetingService implements GreetingService {
  @Override
  public GreetingResponseDto greet() {

    return new GreetingResponseDto()
        .setMessage("Good morning Sir.");
  }
}
