package integrationTests;

import ca.korichi.java10spark.Parameters;
import ca.korichi.java10spark.api.AppServer;
import ca.korichi.java10spark.context.AppHandlersFactory;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.TestInstance;
import spark.Service;

import java.util.Random;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public abstract class AbstractTestServer {
  private Service server;

  @BeforeAll
  public void setupClass() throws InterruptedException {
    Parameters.DEV_PORT = 10000 + new Random().nextInt(50);
    server = new AppServer(getAppHandlersFactory()).start(Parameters.DEV_PORT);
    server.awaitInitialization();
  }

  protected abstract AppHandlersFactory getAppHandlersFactory();

  @AfterAll
  public void tearDown() {
    server.stop();
  }
}
