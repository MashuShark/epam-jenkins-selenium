package pages;

import com.codeborne.selenide.SelenideElement;

import java.util.List;

import static com.codeborne.selenide.Selenide.$$x;
import static com.codeborne.selenide.Selenide.$x;

public class FinancePage extends BasePage {

    public SelenideElement interbankButton = $x("//span[contains(text(),'Міжбанк')]");
    public SelenideElement cashButton = $x("//span[contains(text(),'Гот')]");
    public SelenideElement moneychangerButton = $x("//span[contains(text(),'Міняйло')]");

    public List<SelenideElement> interbankUSD =
            $$x("//a[@data-gtm-ea='interbank-$-button']//span[@class='fua-xrates__value']");

    public List<SelenideElement> cashUSD =
            $$x("//a[@data-gtm-ea='cash-$-button']//span[@class='fua-xrates__value']");


}