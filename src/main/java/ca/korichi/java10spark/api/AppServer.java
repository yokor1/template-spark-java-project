package ca.korichi.java10spark.api;


import ca.korichi.java10spark.context.AppHandlersFactory;
import spark.Service;

public class AppServer {
  private final AppHandlersFactory appHandlersFactory;

  public AppServer(AppHandlersFactory appHandlersFactory) {
    this.appHandlersFactory = appHandlersFactory;
  }

  public Service start(int port) throws InterruptedException {

    Service httpService = null;

    try {
      httpService = Service.ignite().port(port);
      new Filtering().init(httpService);
      new ExceptionsMapping().init(httpService);
      new Routing(appHandlersFactory).init(httpService);
      return httpService;

    } catch (Exception exception) {
      //catch block
    }

    System.exit(-1);
    return httpService;
  }
}
