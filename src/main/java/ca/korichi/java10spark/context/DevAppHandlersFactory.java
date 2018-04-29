package ca.korichi.java10spark.context;


import ca.korichi.java10spark.service.greeting.FormalGreetingService;
import ca.korichi.java10spark.service.greeting.GreetingService;
import ca.korichi.java10spark.service.heartbeat.HeartbeatService;
import ca.korichi.java10spark.service.heartbeat.LessInfosHeartbeatService;
import ca.korichi.java10spark.service.heartbeat.SystemClock;

public class DevAppHandlersFactory extends AppHandlersFactoryTemplate {

  @Override
  protected HeartbeatService createHeartbeatService() {
    return new LessInfosHeartbeatService(new SystemClock());
  }

  protected GreetingService createGreetingService() {
    return new FormalGreetingService();
  }
}
