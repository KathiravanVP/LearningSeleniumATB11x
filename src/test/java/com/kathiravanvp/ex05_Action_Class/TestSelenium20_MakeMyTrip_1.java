package com.kathiravanvp.ex05_Action_Class;

import com.kathiravanvp.CommonToAll.CommonToAll;
import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class TestSelenium20_MakeMyTrip_1 extends CommonToAll {
    @Test
    public void test_selenium(){
        String url = "https://www.makemytrip.com/";
        driver.get(url);

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@data-cy='closeModal']")));

        WebElement close_modal = driver.findElement(By.xpath("//span[@data-cy='closeModal']"));
        close_modal.click();


        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@data-cy='fromCity']")));
        WebElement fromCity = driver.findElement(By.xpath("//input[@data-cy='fromCity']"));

        Actions actions = new Actions(driver);
        actions.moveToElement(fromCity).click().sendKeys("IXC").build().perform();

        waitForJVM(5000);

        try {
            List<WebElement> list = driver.findElements(By.xpath("//ul[@class='react-autosuggest__suggestions-list']/li"));

            for (WebElement e : list){
                e.getText().contains("Chandigarh");
                e.click();
            }
        } catch (StaleElementReferenceException e) {
            System.out.println("Ignore this");
        }

    }
}
