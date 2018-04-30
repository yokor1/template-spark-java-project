package ca.korichi.java10spark.api;

import ca.korichi.java10spark.api.routes.heartbeat.HeartbeatRoutes;
import ca.korichi.java10spark.context.AppHandlersFactory;
import spark.Service;

public class Routing {
  private final AppHandlersFactory appHandlersFactory;

  public Routing(AppHandlersFactory appHandlersFactory) {
    this.appHandlersFactory = appHandlersFactory;
  }

  public void init(Service httpService) {
    new HeartbeatRoutes(appHandlersFactory.getHeartbeatApi()).init(httpService);

  }
}
