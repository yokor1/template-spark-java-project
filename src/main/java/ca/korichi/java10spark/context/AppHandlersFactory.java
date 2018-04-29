package ca.korichi.java10spark.context;

import spark.Route;

public interface AppHandlersFactory {

  Route getHeartbeatHandler();
}
