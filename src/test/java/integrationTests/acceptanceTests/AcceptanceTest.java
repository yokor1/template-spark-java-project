package integrationTests.acceptanceTests;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;

@Category(Acceptance.class)
@RunWith(Cucumber.class)
@CucumberOptions(
    plugin = {"pretty"},
    features = "classpath:features/",
    glue = {"classpath:integrationTests.acceptanceTests/"}
)
public class AcceptanceTest {

}
