package ca.korichi.java10spark.api.routes.heartbeat;

import ca.korichi.java10spark.Parameters;
import ca.korichi.java10spark.api.routes.InvalidUserInputException;
import ca.korichi.java10spark.service.heartbeat.HeartbeatService;
import spark.Route;

import java.util.Optional;

public class HeartbeatApiImpl implements HeartbeatApi {
  private final HeartbeatService heartbeatService;

  public HeartbeatApiImpl(HeartbeatService heartbeatService) {
    this.heartbeatService = heartbeatService;
  }

  @Override
  public Route beatHandler() {
    return (request, response) -> {
      String token = Optional.ofNullable(request.queryParams("token"))
          .orElseThrow(() -> new InvalidUserInputException("bad token."));
      response.status(Parameters.Status.OK);
      return heartbeatService.beat(token);
    };
  }
}
