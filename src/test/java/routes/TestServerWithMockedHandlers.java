package routes;


import ca.korichi.java10spark.context.AppHandlersFactory;
import ca.korichi.java10spark.context.AppHandlersFactoryTemplate;
import ca.korichi.java10spark.service.greeting.GreetingService;
import ca.korichi.java10spark.service.heartbeat.HeartbeatService;

import static org.mockito.Mockito.mock;

public class TestServerWithMockedHandlers extends TestServer {
  protected static GreetingService greetingService;
  protected static HeartbeatService heartbeatService;

  @Override
  protected AppHandlersFactory getAppHandlersFactory() {
    greetingService = mock(GreetingService.class);
    heartbeatService = mock(HeartbeatService.class);

    return new AppHandlersFactoryTemplate() {
      @Override
      protected HeartbeatService createHeartbeatService() {
        return heartbeatService;
      }

      @Override
      protected GreetingService createGreetingService() {
        return greetingService;
      }
    };
  }
}
