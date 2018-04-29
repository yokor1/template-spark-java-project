package ca.korichi.java10spark.service.heartbeat;


import ca.korichi.java10spark.api.routes.heartbeat.HeartbeatResponseDto;

public class LessInfosHeartbeatService implements HeartbeatService {
  private final MyClock clock;

  public LessInfosHeartbeatService(MyClock clock) {
    this.clock = clock;
  }

  @Override
  public HeartbeatResponseDto beat(String token) {
    return new HeartbeatResponseDto()
        .setToken(token)
        .setTimestamp(clock.currentTimeMillis());
  }
}
