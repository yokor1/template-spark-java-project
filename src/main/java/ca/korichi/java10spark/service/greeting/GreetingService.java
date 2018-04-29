package ca.korichi.java10spark.service.greeting;


import ca.korichi.java10spark.api.routes.greeting.GreetingResponseDto;

public interface GreetingService {
  GreetingResponseDto greet();
}
