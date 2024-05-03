package runner;

import org.junit.jupiter.api.TestInstance;
import org.junit.platform.suite.api.*;

import static io.cucumber.core.options.Constants.PLUGIN_PROPERTY_NAME;

@Suite
@IncludeEngines("cucumber")
@SelectPackages("steps")
@SelectClasspathResource("features")
@ConfigurationParameter(key = PLUGIN_PROPERTY_NAME, value = "json:reports/jenkins_output.json")
@ExcludeTags("TotalPrice") //it is flaky test
//@TestInstance(TestInstance.Lifecycle.PER_CLASS)

public class TestRunner {
}
