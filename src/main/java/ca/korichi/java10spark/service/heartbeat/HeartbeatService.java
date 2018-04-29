package ca.korichi.java10spark.service.heartbeat;


import ca.korichi.java10spark.api.routes.heartbeat.HeartbeatResponseDto;

public interface HeartbeatService {
  HeartbeatResponseDto beat(String token);
}
