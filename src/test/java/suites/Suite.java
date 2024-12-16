package suites;

import org.junit.platform.runner.JUnitPlatform;
import org.junit.platform.suite.api.ExcludeTags;
import org.junit.platform.suite.api.IncludeTags;
import org.junit.platform.suite.api.SelectClasses;
import org.junit.platform.suite.api.SelectPackages;
import org.junit.runner.RunWith;
import testCases.LoginTest;
import testCases.ProductTest;
import testCases.YourCartTest;

@RunWith(JUnitPlatform.class)
@SelectClasses({ProductTest.class})
//@SelectPackages("testCases")
@IncludeTags({"menu",})
@ExcludeTags({"bug","about","logout"})
public class Suite {

}