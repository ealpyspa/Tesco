package runner;

import org.junit.jupiter.api.TestInstance;
import org.junit.platform.suite.api.*;

@Suite
@IncludeEngines("cucumber")
@SelectPackages("steps")
@SelectClasspathResource("features")
//@TestInstance(TestInstance.Lifecycle.PER_CLASS)

public class TestRunner {
}
