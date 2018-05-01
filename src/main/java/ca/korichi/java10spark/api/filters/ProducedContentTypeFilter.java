package ca.korichi.java10spark.api.filters;

import spark.Filter;
import spark.Request;
import spark.Response;

public class ProducedContentTypeFilter implements Filter {
  @Override
  public void handle(Request request, Response response) throws Exception {
    response.type("application/json");
  }
}
