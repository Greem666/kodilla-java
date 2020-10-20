package com.kodilla.testing2.crudapp;

import com.kodilla.testing2.config.WebDriverConfig;
import javafx.application.ConditionalFeature;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Random;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class CrudAppTestSuite {
    private static String BASE_URL = "https://greem666.github.io/";
    private WebDriver driver;
    private Random generator = new Random();

    @Before
    public void initTests() {
        driver = WebDriverConfig.getDriver(WebDriverConfig.CHROME);
        driver.get(BASE_URL);
    }

    @After
    public void cleanUpAfterTests() {
        driver.close();
    }

    @Test
    public void testShouldCreateTrelloCard() throws InterruptedException {
        String taskName = createCrudAppTestTask();
        sendTestTaskToTrello(taskName);
//        assertTrue(checkTaskExistsInTrello(taskName));  // Disabled, because username and password were removed
        deleteCrudAppTestTask(taskName);
    }

    private String createCrudAppTestTask() throws InterruptedException {
        final String XPATH_TASK_NAME = "//form[contains(@action, \"createTask\")]/fieldset[1]/input";
        final String XPATH_TASK_CONTENT = "//form[contains(@action, \"createTask\")]/fieldset[2]/textarea";
        final String XPATH_ADD_BUTTON = "//form[contains(@action, \"createTask\")]/fieldset[3]/button";
        String taskName = "Task number " + generator.nextInt(100000);
        String taskContent = taskName + " content";

        WebElement name = driver.findElement(By.xpath(XPATH_TASK_NAME));
        name.sendKeys(taskName);

        WebElement content = driver.findElement(By.xpath(XPATH_TASK_CONTENT));
        content.sendKeys(taskContent);

        WebElement addButton = driver.findElement(By.xpath(XPATH_ADD_BUTTON));
        addButton.click();
        Thread.sleep(2000);

        return taskName;
    }

    private void sendTestTaskToTrello(String taskName) throws InterruptedException {
        final String XPATH_TASK_FORMS = "//div[contains(@class, \"tasks-container\")]/form";
        final String XPATH_TASK_NAME = ".//fieldset/p";
        final String XPATH_BOARD_SELECT = ".//select[@name=\"board-name\"]";
        final String XPATH_LIST_SELECT = ".//select[@name=\"list-name\"]";
        final String XPATH_CREATE_BUTTON = ".//button[contains(@class, \"card-creation\")]";

        driver.navigate().refresh();

        Wait<WebDriver> wait = new WebDriverWait(driver, 5);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(XPATH_TASK_FORMS)));

//        while (!driver.findElement(By.xpath(XPATH_TASK_FORMS)).isDisplayed());  // doesn`t work!

        driver.findElements(By.xpath(XPATH_TASK_FORMS)).stream()
                .filter(anyForm -> anyForm.findElement(By.xpath(XPATH_TASK_NAME)).getText().equals(taskName))
                .forEach(theForm -> {
                    Select boardSelect = new Select(theForm.findElement(By.xpath(XPATH_BOARD_SELECT)));
                    boardSelect.selectByVisibleText("Kodilla Application");

                    Select listSelect = new Select(theForm.findElement(By.xpath(XPATH_LIST_SELECT)));
                    listSelect.selectByVisibleText("Things to do");

                    WebElement createButton = theForm.findElement(By.xpath(XPATH_CREATE_BUTTON));
                    createButton.click();
                });

        wait = new WebDriverWait(driver, 5);
        wait.until(ExpectedConditions.alertIsPresent());

        driver.switchTo().alert().accept();
    }

    public boolean checkTaskExistsInTrello(String taskName) throws InterruptedException {
        boolean result = false;
        final String TRELLO_LOGIN_URL = "https://trello.com/login";
        final String USERNAME = "private";
        final String PASSWORD = "VERY PRIVATE :)";
        final String XPATH_USERNAME = "//input[@id=\"user\"]";
        final String XPATH_PASSWORD = "//input[@id=\"password\"]";
        final String XPATH_LOGIN_BUTTON = "//input[@id=\"login\"]";
        final String XPATH_ATLASSIAN_LOGIN_BUTTON = "//button[@id=\"login-submit\"]";
        final String XPATH_BOARD_TILES = "//a[@class=\"board-tile\"]";
        final String XPATH_KODILLA_BOARD = ".//div[@title=\"Kodilla Application\"]";
        final String XPATH_KODILLA_APPLICATION_BOARD_NAME = "//h1[contains(@class, \"board-header\")]";
        final String XPATH_LIST_CARD_TITLES = "//span[contains(@class, \"list-card-title\")]";

        WebDriver driverTrello = WebDriverConfig.getDriver(WebDriverConfig.CHROME);
        driverTrello.get(TRELLO_LOGIN_URL);

        driverTrello.findElement(By.xpath(XPATH_USERNAME)).sendKeys(USERNAME);
        driverTrello.findElement(By.xpath(XPATH_PASSWORD)).sendKeys(PASSWORD);
        driverTrello.findElement(By.xpath(XPATH_LOGIN_BUTTON)).click();

        Thread.sleep(5000);

        driverTrello.findElement(By.xpath(XPATH_PASSWORD)).sendKeys(PASSWORD);
        driverTrello.findElement(By.xpath(XPATH_ATLASSIAN_LOGIN_BUTTON)).click();

        Wait<WebDriver> wait = new WebDriverWait(driverTrello, 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(XPATH_KODILLA_BOARD)));

        driverTrello.findElements(By.xpath(XPATH_BOARD_TILES)).stream()
                .filter(aHref -> aHref.findElements(By.xpath(XPATH_KODILLA_BOARD)).size() > 0)
                .forEach(WebElement::click);

        wait = new WebDriverWait(driverTrello, 10);  // Seems I have to re-initialize it for reuse
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(XPATH_KODILLA_APPLICATION_BOARD_NAME)));

        result = driverTrello.findElements(By.xpath(XPATH_LIST_CARD_TITLES)).stream()
                .anyMatch(span -> span.getText().equals(taskName));

        driverTrello.close();

        return result;
    }

    private void deleteCrudAppTestTask(String taskName) throws InterruptedException {
        final String XPATH_TASK_FORMS = "//div[contains(@class, \"tasks-container\")]/form";
        final String XPATH_TASK_NAME = ".//fieldset/p";
        final String XPATH_DELETE_BUTTON = ".//button[text()=\"Delete\"]";

        driver.navigate().refresh();

        Wait<WebDriver> wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(XPATH_TASK_FORMS)));

        driver.findElements(By.xpath(XPATH_TASK_FORMS)).stream()
                .filter(anyForm -> anyForm.findElement(By.xpath(XPATH_TASK_NAME)).getText().equals(taskName))
                .forEach(theForm -> {
                    WebElement createButton = theForm.findElement(By.xpath(XPATH_DELETE_BUTTON));
                    createButton.click();
                });

        Thread.sleep(2000);
    }
}
