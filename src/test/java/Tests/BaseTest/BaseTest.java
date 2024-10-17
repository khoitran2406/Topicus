package Tests.BaseTest;

import com.topicus.DriverFactory.BrowserType;
import com.topicus.DriverFactory.WebDriverFactory;
import com.topicus.Listener.EventListener;
import net.datafaker.Faker;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;

@Listeners(EventListener.class)
public class BaseTest {

    public WebDriver driver;
    public String testUrl;
    public Faker faker;

    @BeforeSuite
    public void BeforeTestSuite() throws Exception {
        testUrl = "https://demoqa.com/automation-practice-form";
        driver = WebDriverFactory.initDriver(BrowserType.EDGE);

        faker = new Faker();
    }

    @BeforeMethod
    public void BeforeTestMethod() {
        driver.get(testUrl);
    }

    @AfterMethod
    public void AfterTestMethod(){
    }

    @AfterSuite
    public void AfterTestSuite(){
        driver.quit();
    }
}
