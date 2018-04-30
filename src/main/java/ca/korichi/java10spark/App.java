package ca.korichi.java10spark;


import ca.korichi.java10spark.api.AppServer;
import ca.korichi.java10spark.context.AppHandlersFactory;
import ca.korichi.java10spark.context.ProdAppHandlersFactory;

public class App {

  public static void main(String[] args) {
    //select env (prod-dev)
    AppHandlersFactory appHandlersFactory = new ProdAppHandlersFactory();

    new AppServer(appHandlersFactory).start(Parameters.PROD_PORT);
  }
}
