package Tests.BaseTest;

import com.topicus.DriverFactory.BrowserType;
import com.topicus.DriverFactory.WebDriverFactory;
import com.topicus.Listener.EventListener;
import net.datafaker.Faker;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;

@Listeners(EventListener.class)
public class BaseTest {

    public WebDriver driver;
    public String url;
    public Faker faker;

    @BeforeSuite
    public void BeforeTestSuite() throws Exception {
        url = "https://demoqa.com/automation-practice-form";
        driver = WebDriverFactory.initDriver(BrowserType.EDGE);

        faker = new Faker();
    }

    @BeforeTest
    public void BeforeTestMethod(){
        driver.get(url);
    }

    @AfterSuite
    public void AfterTestSuite(){
        driver.close();
        driver.quit();
    }
}
