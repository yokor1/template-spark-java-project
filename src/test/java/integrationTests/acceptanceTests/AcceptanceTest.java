package integrationTests.acceptanceTests;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
    plugin = {"pretty"},
    features = "classpath:features/",
    glue = {"classpath:integrationTests.acceptanceTests/"}
)
public class AcceptanceTest {

}
