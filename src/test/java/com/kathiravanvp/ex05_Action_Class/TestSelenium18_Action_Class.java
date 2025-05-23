package com.kathiravanvp.ex05_Action_Class;


import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;

public class TestSelenium18_Action_Class {
    public static void main(String[] args) {
        WebDriver driver = new EdgeDriver();
        driver.manage().window().maximize();

        driver.get("https://awesomeqa.com/practice.html");

        WebElement firstname = driver.findElement(By.xpath("//input[@name='firstname']"));

        Actions actions = new Actions(driver);
        actions.keyDown(Keys.SHIFT)
                .sendKeys(firstname,"kathiravan")
                .keyUp(Keys.SHIFT).build().perform();
    }
}
