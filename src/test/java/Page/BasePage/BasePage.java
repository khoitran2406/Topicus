package Page.BasePage;

import com.topicus.Keyword.Keyword;
import org.openqa.selenium.WebDriver;

public class BasePage {

    protected Keyword keyword;

    public BasePage(WebDriver driver){
        keyword = new Keyword(driver);
    }
}
