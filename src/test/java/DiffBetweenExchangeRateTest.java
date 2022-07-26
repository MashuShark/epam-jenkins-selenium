import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DiffBetweenExchangeRateTest extends BaseTest {

    @Test
    public void verifyThatDiffBetweenInterbankAndCashUSDLessOrEqual5() {
        homePage.searchButton.sendKeys(homePage.SEARCH_FINANCE, Keys.ENTER);
        searchResultPage.financeLink.click();
        financePage.interbankButton.click();

        double interbankSellUSD = Double.parseDouble(financePage.interbankUSD.get(0).getOwnText().replaceAll("\n", ""));
        double interbankBuyUSD = Double.parseDouble(financePage.interbankUSD.get(1).getOwnText().replaceAll("\n", ""));

        financePage.cashButton.click();

        double cashSellUSD = Double.parseDouble(financePage.cashUSD.get(0).getOwnText().replaceAll("\n", ""));
        double cashBuyUSD = Double.parseDouble(financePage.cashUSD.get(1).getOwnText().replaceAll("\n", ""));

        Assert.assertTrue(cashSellUSD - interbankSellUSD <= 5 && cashBuyUSD - interbankBuyUSD <= 5);

    }

}