package pages;


import com.codeborne.selenide.SelenideElement;
import static com.codeborne.selenide.Selenide.$x;

public class HomePage {

    public SelenideElement searchButton = $x("//input[@name='q']");

    public final String SEARCH_FINANCE = "https://finance.ua";

}
//$x("//input[@name='q']");