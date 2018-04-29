package ca.korichi.java10spark.api.routes.heartbeat;

import ca.korichi.java10spark.Parameters;
import ca.korichi.java10spark.service.heartbeat.HeartbeatService;
import spark.Request;
import spark.Response;
import spark.Route;


public class HeartbeatHandler implements Route {
  private final HeartbeatService heartbeatService;

  public HeartbeatHandler(HeartbeatService heartbeatService) {
    this.heartbeatService = heartbeatService;
  }

  @Override
  public HeartbeatResponseDto handle(Request request, Response response) {
    String token = request.queryParams("token");
    response.status(Parameters.Status.OK);
    return heartbeatService.beat(token);
  }
}
