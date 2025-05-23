package com.kathiravanvp.ex05_Action_Class;

import com.kathiravanvp.CommonToAll.CommonToAll;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class TestSelenium22_Drag_Drop extends CommonToAll {
    @Test
    public void dragAndDrop(){
        String url = "https://the-internet.herokuapp.com/drag_and_drop";
        driver.get(url);

        WebElement from = driver.findElement(By.xpath("//div[@id=\"column-a\"]"));
        WebElement to = driver.findElement(By.xpath("//div[@id=\"column-b\"]"));

        Actions actions = new Actions(driver);
        actions.dragAndDrop(from,to).build().perform();
    }
}
