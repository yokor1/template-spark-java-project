package ca.korichi.java10spark.context;


import ca.korichi.java10spark.api.routes.heartbeat.HeartbeatApi;
import ca.korichi.java10spark.api.routes.heartbeat.HeartbeatApiImpl;
import ca.korichi.java10spark.service.heartbeat.HeartbeatService;

public abstract class AppHandlersFactoryTemplate implements AppHandlersFactory {

  @Override
  public HeartbeatApi getHeartbeatApi() {
    return new HeartbeatApiImpl(createHeartbeatService());
  }

  protected abstract HeartbeatService createHeartbeatService();
}
