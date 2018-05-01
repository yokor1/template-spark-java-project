package ca.korichi.java10spark.api.routes.heartbeat;

import ca.korichi.java10spark.Parameters;
import ca.korichi.java10spark.api.JsonTransformer;
import spark.Service;

public class HeartbeatRoutes {
  private final HeartbeatApi heartbeatApi;

  public HeartbeatRoutes(HeartbeatApi heartbeatApi) {
    this.heartbeatApi = heartbeatApi;
  }

  public void init(Service httpService) {
    httpService.get(Parameters.Paths.HEARTBEAT, heartbeatApi.beatHandler(), new JsonTransformer());
  }
}
