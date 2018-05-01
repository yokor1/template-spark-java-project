package integrationTests.acceptanceTests;

public interface Fixture {
  void clean();

  void createToken();

  void requestBeat();

  void tokenIsReturned();

  void timestampIsReturned();

  void createInvalidToken();

  void codeStatusIsEqualTo(int codeStatus);
}
