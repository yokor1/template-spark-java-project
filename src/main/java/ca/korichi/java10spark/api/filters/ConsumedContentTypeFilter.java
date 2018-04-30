package ca.korichi.java10spark.api.filters;

import spark.Filter;
import spark.Request;
import spark.Response;

import static spark.Spark.halt;


public class ConsumedContentTypeFilter implements Filter {
  @Override
  public void handle(Request request, Response response) throws Exception {
    String contentType = request.contentType();
    if (contentType == null || !contentType.contains("application/json")) {
      halt(401, "bad content type");
    }
  }
}
