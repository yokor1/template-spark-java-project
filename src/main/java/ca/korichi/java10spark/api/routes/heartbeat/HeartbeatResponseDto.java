package ca.korichi.java10spark.api.routes.heartbeat;

import java.util.Objects;

public class HeartbeatResponseDto {

  public String token;
  public long timestamp;

  public HeartbeatResponseDto setToken(String token) {
    this.token = token;
    return this;
  }

  public HeartbeatResponseDto setTimestamp(long timestamp) {
    this.timestamp = timestamp;
    return this;
  }

  @Override
  public boolean equals(Object other) {
    if (this == other) {
      return true;
    }
    if (other == null || getClass() != other.getClass()) {
      return false;
    }
    HeartbeatResponseDto that = (HeartbeatResponseDto) other;
    return timestamp == that.timestamp
        && Objects.equals(token, that.token);
  }

  @Override
  public int hashCode() {

    return Objects.hash(token, timestamp);
  }
}
