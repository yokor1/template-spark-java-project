package integrationTests.edgeTests;


import ca.korichi.java10spark.context.AppHandlersFactory;
import ca.korichi.java10spark.context.AppHandlersFactoryTemplate;
import ca.korichi.java10spark.service.heartbeat.HeartbeatService;
import integrationTests.AbstractTestServer;

import static org.mockito.Mockito.mock;

public class TestServerWithMockedHandlers extends AbstractTestServer {
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
