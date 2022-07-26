import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import pages.FinancePage;
import pages.HomePage;
import pages.SearchResultPage;

import static com.codeborne.selenide.Selenide.open;

public class BaseTest {

    HomePage homePage = new HomePage();
    SearchResultPage searchResultPage = new SearchResultPage();

    FinancePage financePage = new FinancePage();

    @BeforeClass
    public void setUpAll() {
        Configuration.startMaximized = true;
        Configuration.browser = "chrome";
        Configuration.screenshots = true;
        SelenideLogger.addListener("allure", new AllureSelenide());
    }

    @BeforeMethod
    public void setUp() {
        open("https://www.google.com");
    }
}