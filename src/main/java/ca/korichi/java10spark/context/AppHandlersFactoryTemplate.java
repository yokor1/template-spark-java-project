package ca.korichi.java10spark.context;


import ca.korichi.java10spark.api.routes.heartbeat.HeartbeatHandler;
import ca.korichi.java10spark.service.heartbeat.HeartbeatService;
import spark.Route;

public abstract class AppHandlersFactoryTemplate implements AppHandlersFactory {

  @Override
  public Route getHeartbeatHandler() {
    return new HeartbeatHandler(createHeartbeatService());
  }

  protected abstract HeartbeatService createHeartbeatService();
}
