package testRunner;

import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features = {"FeatureFiles/Customer.feature"}, 
				glue = {"stepDefinition"}, 
				plugin = {"pretty", "html:target/Cucumber.html"})
public class Runner 
{

}
