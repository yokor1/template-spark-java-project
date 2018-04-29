package integrationTests.functionalTests;


import ca.korichi.java10spark.context.AppHandlersFactory;
import ca.korichi.java10spark.context.AppHandlersFactoryTemplate;
import ca.korichi.java10spark.service.heartbeat.HeartbeatService;
import ca.korichi.java10spark.service.heartbeat.LessInfosHeartbeatService;
import ca.korichi.java10spark.service.heartbeat.SystemClock;
import integrationTests.AbstractTestServer;

public class TestServer extends AbstractTestServer {
  protected static HeartbeatService heartbeatService;

  @Override
  protected AppHandlersFactory getAppHandlersFactory() {
    heartbeatService = new LessInfosHeartbeatService(new SystemClock());

    return new AppHandlersFactoryTemplate() {
      @Override
      protected HeartbeatService createHeartbeatService() {
        return heartbeatService;
      }
    };
  }
}
