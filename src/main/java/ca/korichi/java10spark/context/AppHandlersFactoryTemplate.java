package ca.korichi.java10spark.context;


import ca.korichi.java10spark.api.routes.greeting.GreetingHandler;
import ca.korichi.java10spark.api.routes.heartbeat.HeartbeatHandler;
import ca.korichi.java10spark.service.greeting.GreetingService;
import ca.korichi.java10spark.service.heartbeat.HeartbeatService;
import spark.Route;

public abstract class AppHandlersFactoryTemplate implements AppHandlersFactory {

  @Override
  public Route getGreetingHandler() {
    return new GreetingHandler(createGreetingService());
  }

  @Override
  public Route getHeartbeatHandler() {
    return new HeartbeatHandler(createHeartbeatService());
  }

  protected abstract HeartbeatService createHeartbeatService();

  protected abstract GreetingService createGreetingService();
}
