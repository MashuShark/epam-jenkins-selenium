package pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;

public class SearchResultPage {

    public SelenideElement financeLink = $x("//a[@href='https://finance.ua/']");

}
