package ca.korichi.java10spark;

public class Parameters {

  public static final int PROD_PORT = 9090;
  public static final int MAX_ATTEMPT_NUMBER = 5;
  public static int DEV_PORT = 9990;
  public static int ACC_TEST_PORT = 9999;

  public static final class Paths {
    public static final String HEARTBEAT = "heartbeat";
  }

  public class Status {
    public static final int OK = 200;
    public static final int BAD_REQUEST = 400;
  }
}
