package routes;

import ca.korichi.java10spark.Parameters;
import ca.korichi.java10spark.api.AppServer;
import ca.korichi.java10spark.context.AppHandlersFactory;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.TestInstance;
import spark.Service;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public abstract class TestServer {
  private Service server;

  @BeforeAll
  public void setupClass() {
    server = new AppServer(getAppHandlersFactory()).start(Parameters.DEV_PORT);
  }

  protected abstract AppHandlersFactory getAppHandlersFactory();

  @AfterAll
  public void tearDown() {
    server.stop();
  }
}
