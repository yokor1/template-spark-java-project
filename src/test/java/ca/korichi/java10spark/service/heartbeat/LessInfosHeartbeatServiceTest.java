package ca.korichi.java10spark.service.heartbeat;

import ca.korichi.java10spark.api.routes.heartbeat.HeartbeatResponseDto;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.willReturn;
import static org.mockito.MockitoAnnotations.initMocks;

class LessInfosHeartbeatServiceTest {

  private HeartbeatService heartbeatService;
  @Mock
  private MyClock clock;

  @BeforeEach
  public void setup() {
    initMocks(this);
    heartbeatService = new LessInfosHeartbeatService(clock);
  }

  @Test
  public void whenBeatIsCalledWithAToken_thenTheTokenIsReturned() {
    String aToken = "aToken";
    long aTimestamp = 100;

    willReturn(aTimestamp).given(clock).currentTimeMillis();
    HeartbeatResponseDto heartbeatResponseDto = heartbeatService.beat(aToken);

    assertThat(heartbeatResponseDto.token).isEqualTo(aToken);
  }

  @Test
  public void whenBeatIsCalled_thenATimestampIsReturned() {
    String aToken = "aToken";
    long aTimestamp = 100;

    willReturn(aTimestamp).given(clock).currentTimeMillis();
    HeartbeatResponseDto heartbeatResponseDto = heartbeatService.beat(aToken);

    assertThat(heartbeatResponseDto.timestamp).isEqualTo(aTimestamp);
  }

}