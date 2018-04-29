package ca.korichi.java10spark.service.heartbeat;

public class SystemClock implements MyClock {
  @Override
  public long currentTimeMillis() {
    return System.currentTimeMillis();
  }
}
