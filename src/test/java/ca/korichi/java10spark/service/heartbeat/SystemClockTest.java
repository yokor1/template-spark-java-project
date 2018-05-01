package ca.korichi.java10spark.service.heartbeat;

import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class SystemClockTest {

  private MyClock clock;

  @RepeatedTest(10)
  @Test
  public void whenTimestampIsRequested_thenTimestampIsReturned() throws InterruptedException {
    clock = new SystemClock();
    long delta_timestamp = 10;
    long timestamp1 = System.currentTimeMillis();
    Thread.sleep(delta_timestamp);
    long timestamp2 = clock.currentTimeMillis();

    assertThat(timestamp2 - timestamp1)
        .isGreaterThanOrEqualTo(delta_timestamp);
  }
}