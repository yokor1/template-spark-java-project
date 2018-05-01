package ca.korichi.java10spark.context;

import ca.korichi.java10spark.api.routes.heartbeat.HeartbeatApi;

public interface AppHandlersFactory {

  HeartbeatApi getHeartbeatApi();
}
