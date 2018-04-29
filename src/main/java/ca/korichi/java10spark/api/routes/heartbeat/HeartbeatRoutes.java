package ca.korichi.java10spark.api.routes.heartbeat;


import ca.korichi.java10spark.Parameters;
import ca.korichi.java10spark.api.JsonTransformer;
import spark.Route;
import spark.Service;

public class HeartbeatRoutes {
  private final Route heartbeatHandler;

  public HeartbeatRoutes(Route heartbeatHandler) {
    this.heartbeatHandler = heartbeatHandler;
  }

  public void init(Service httpService) {
    httpService.get(Parameters.Paths.HEARTBEAT, heartbeatHandler, new JsonTransformer());
  }
}
