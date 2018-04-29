package ca.korichi.java10spark.context;


import ca.korichi.java10spark.service.heartbeat.HeartbeatService;
import ca.korichi.java10spark.service.heartbeat.LessInfosHeartbeatService;
import ca.korichi.java10spark.service.heartbeat.SystemClock;

public class ProdAppHandlersFactory extends AppHandlersFactoryTemplate {

  @Override
  protected HeartbeatService createHeartbeatService() {
    return new LessInfosHeartbeatService(new SystemClock());
  }
}
