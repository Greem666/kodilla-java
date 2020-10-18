package ebay;

import config.WebDriverConfig;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class EBayTestingApp {
    public static final String SEARCH_FIELD = "gh-ac";

    public static void main(String[] args) {
        WebDriver driver = WebDriverConfig.getDriver(WebDriverConfig.FIREFOX);
        driver.get("https://www.ebay.com.au/");

        WebElement searchField = driver.findElement(By.id(SEARCH_FIELD));
        searchField.sendKeys("Laptop");
        searchField.submit();
    }
}
