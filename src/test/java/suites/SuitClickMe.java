package suites;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
//@SelectPackages("src/test/resources/features")
@CucumberOptions(
        features = "src/test/resources/features",
        glue =  {"steps"},
//        tags = "@clickme or @test"
        tags = "(@smoke or @release) and (not @ignore)"
)
public class SuitClickMe {
}
