package google;

import config.WebDriverConfig;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class GoogleTestingApp {
    public final static String SEARCH_FIELD = "q";

    public static void main(String[] args) {
        WebDriver driver = WebDriverConfig.getDriver(WebDriverConfig.CHROME);
        driver.get("https://www.google.com");

        WebElement searchField = driver.findElement(By.name(SEARCH_FIELD));
        searchField.sendKeys("Kodilla");
        searchField.submit();
    }
}
