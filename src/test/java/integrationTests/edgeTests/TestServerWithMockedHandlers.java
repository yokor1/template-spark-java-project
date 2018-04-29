package integrationTests.edgeTests;


import ca.korichi.java10spark.context.AppHandlersFactory;
import ca.korichi.java10spark.context.AppHandlersFactoryTemplate;
import ca.korichi.java10spark.service.heartbeat.HeartbeatService;
import integrationTests.TestServer;

import static org.mockito.Mockito.mock;

public class TestServerWithMockedHandlers extends TestServer {
  protected static HeartbeatService heartbeatService;

  @Override
  protected AppHandlersFactory getAppHandlersFactory() {
    heartbeatService = mock(HeartbeatService.class);

    return new AppHandlersFactoryTemplate() {
      @Override
      protected HeartbeatService createHeartbeatService() {
        return heartbeatService;
      }
    };
  }
}
