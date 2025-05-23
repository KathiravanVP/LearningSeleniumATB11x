package com.kathiravanvp.ex05_Action_Class;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class TestSelenium19_Action_Class1 {
    @Test
    public void test_Action(){
        WebDriver driver = new EdgeDriver();
        String URL = "https://www.spicejet.com/";
        driver.get(URL);
        driver.manage().window().maximize();

        WebElement source = driver.findElement(By.xpath("//div[@data-testid=\"to-testID-origin\"]/div/div/input"));

        Actions actions = new Actions(driver);
        // move to Element
        // click
        // sendKeys

        actions.moveToElement(source).click().sendKeys("BLR").build().perform();
    }
}
