package com.kodilla.testing2.facebook;

import com.kodilla.testing2.config.WebDriverConfig;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class FacebookTestingApp {
    public static final String XPATH_NEW_ACCOUNT = "//form[contains(@class, featuredLogin)]/div/a[@role=\"button\"]";
    public static final String XPATH_WAIT_FOR = "//form[@id=\"reg\"]/div/div/div/div/div/div/input";
    public static final String XPATH_DOB_DAY = "//form[@id=\"reg\"]/div/div/div/span/span/select[1]";
    public static final String XPATH_DOB_MONTH = "//form[@id=\"reg\"]/div/div/div/span/span/select[2]";
    public static final String XPATH_DOB_YEAR = "//form[@id=\"reg\"]/div/div/div/span/span/select[3]";

    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = WebDriverConfig.getDriver(WebDriverConfig.FIREFOX);
        driver.get("https://www.facebook.com");

        WebElement createNewAccountButton = driver.findElement(By.xpath(XPATH_NEW_ACCOUNT));
        createNewAccountButton.click();

//        while (!driver.findElement(By.xpath(XPATH_WAIT_FOR)).isDisplayed());  // Did not work on Firefox for some reason
        Wait<WebDriver> wait = new WebDriverWait(driver, 5);
        WebElement waitElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(XPATH_WAIT_FOR)));

        WebElement dobDay = driver.findElement(By.xpath(XPATH_DOB_DAY));
        Select selectDay = new Select(dobDay);
        selectDay.selectByVisibleText("6");

        WebElement dobMonth = driver.findElement(By.xpath(XPATH_DOB_MONTH));
        Select selectMonth = new Select(dobMonth);
        selectMonth.selectByVisibleText("Jun");

        WebElement dobYear = driver.findElement(By.xpath(XPATH_DOB_YEAR));
        Select selectYear = new Select(dobYear);
        selectYear.selectByVisibleText("2006");
    }
}
