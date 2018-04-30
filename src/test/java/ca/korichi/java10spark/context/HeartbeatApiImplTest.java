package ca.korichi.java10spark.context;

import ca.korichi.java10spark.Parameters;
import ca.korichi.java10spark.api.routes.InvalidUserInputException;
import ca.korichi.java10spark.api.routes.heartbeat.HeartbeatApi;
import ca.korichi.java10spark.api.routes.heartbeat.HeartbeatApiImpl;
import ca.korichi.java10spark.service.heartbeat.HeartbeatService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import spark.Request;
import spark.Response;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.BDDMockito.willReturn;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.MockitoAnnotations.initMocks;

class HeartbeatApiImplTest {

  @Mock
  Request request;
  @Mock
  Response response;
  @Mock
  private HeartbeatService heartbeatService;

  private HeartbeatApi heartbeatApi;

  @BeforeEach
  public void setup() {
    initMocks(this);
    heartbeatApi = new HeartbeatApiImpl(heartbeatService);
  }

  @Test
  public void givenAValidRequest_whenHandleIsCalled_thenResponseStatusIsOk() throws Exception {
    int expectedStatus = Parameters.Status.OK;
    String aToken = "aToken";
    String queryParameterName = "token";
    willReturn(aToken).given(request).queryParams(queryParameterName);

    heartbeatApi.beatHandler().handle(request, response);

    verify(response, times(1)).status(expectedStatus);
  }

  @Test
  public void givenAValidRequest_whenHandleIsCalled_thenHeartbeatServiceIsCalled() throws Exception {

    String aToken = "aToken";
    String queryParameterName = "token";
    willReturn(aToken).given(request).queryParams(queryParameterName);

    heartbeatApi.beatHandler().handle(request, response);

    verify(heartbeatService, times(1)).beat(aToken);
  }

  @Test
  public void givenAnIValidRequest_whenHandleIsCalled_thenThrowInvalidUserInputException() throws Exception {

    String queryParameterName = "token";
    willReturn(null).given(request).queryParams(queryParameterName);
    assertThrows(InvalidUserInputException.class,
        () -> heartbeatApi.beatHandler().handle(request, response));
  }
}