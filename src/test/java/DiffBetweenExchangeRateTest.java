
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.FinancePage;
import pages.HomePage;
import pages.SearchResultPage;

import static com.codeborne.selenide.Selenide.open;

public class DiffBetweenExchangeRateTest {

    HomePage homePage = new HomePage();
    SearchResultPage searchResultPage = new SearchResultPage();
    FinancePage financePage = new FinancePage();

    @BeforeClass
    public void setUpAll() {
//        Configuration.startMaximized = true;
        Configuration.browser = "chrome";
        Configuration.screenshots = true;
        SelenideLogger.addListener("allure", new AllureSelenide());
    }

    @BeforeMethod
    public void setUp() {
        open("https://www.google.com");
    }

    @Test
    public void verifyThatDiffBetweenInterbankAndCashSellUSDLessOrEqual5() {
        homePage.searchButton.setValue(homePage.SEARCH_FINANCE).pressEnter();
        searchResultPage.financeLink.click();
        financePage.interbankButton.click();

        double interbankSellUSD = Double.parseDouble(financePage.interbankUSD.get(0).getOwnText().replaceAll("\n", ""));
        double interbankBuyUSD = Double.parseDouble(financePage.interbankUSD.get(1).getOwnText().replaceAll("\n", ""));

        financePage.cashButton.click();

        double cashSellUSD = Double.parseDouble(financePage.cashUSD.get(0).getOwnText().replaceAll("\n", ""));
        double cashBuyUSD = Double.parseDouble(financePage.cashUSD.get(1).getOwnText().replaceAll("\n", ""));

        Assert.assertTrue(cashSellUSD - interbankSellUSD <= 5,
                "Difference is more then 5");

    }
}