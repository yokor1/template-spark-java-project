package ca.korichi.java10spark.api;

import ca.korichi.java10spark.api.filters.ConsumedContentTypeFilter;
import ca.korichi.java10spark.api.filters.ProducedContentTypeFilter;
import spark.Service;

public class Filtering {
  public void init(Service httpService) {
    httpService.before(new ConsumedContentTypeFilter());
    httpService.after(new ProducedContentTypeFilter());
  }
}
