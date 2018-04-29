package ca.korichi.java10spark.api;

import ca.korichi.java10spark.api.routes.heartbeat.HeartbeatRoutes;
import ca.korichi.java10spark.context.AppHandlersFactory;
import spark.Filter;
import spark.Service;

import static spark.Spark.halt;


public class AppServer {
  private final AppHandlersFactory appHandlersFactory;

  public AppServer(AppHandlersFactory appHandlersFactory) {
    this.appHandlersFactory = appHandlersFactory;
  }

  public Service start(int port) {

    Filter consumedContentTypeFilter = (request, response) -> {
      String contentType = request.contentType();
      if (contentType == null || !contentType.contains("application/json")) {
        halt(401, "bad content type");
      }
    };
    Filter producedContentType = (request, response) ->
        response.type("application/json");

    Service httpService = Service
        .ignite()
        .port(port);

    httpService.before(consumedContentTypeFilter);
    httpService.after(producedContentType);
    new HeartbeatRoutes(appHandlersFactory.getHeartbeatHandler()).init(httpService);

    return httpService;
  }
}
