package testSuites;

import org.junit.platform.suite.api.SelectClasses;
import org.junit.platform.suite.api.Suite;
import tests.*;

@Suite
@SelectClasses({
    LoginTest.class,
    ProductTest.class,
    CartTest.class
})
public class RegressionTestSuite {
}