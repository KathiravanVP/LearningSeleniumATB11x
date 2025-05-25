package com.kathiravanvp.ex08_Relative_Locators;

import com.kathiravanvp.CommonToAll.CommonToAll;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import static org.openqa.selenium.support.locators.RelativeLocator.*;

public class TestSelenium28_Relative_Locators extends CommonToAll {
    @Test
    public void test_RL(){
        driver.get("https://awesomeqa.com/practice.html");

        WebElement span = driver.findElement(By.xpath("//span[text()='Years of Experience']"));

        WebElement option = driver.findElement(with(By.id("exp-4")).toRightOf(span));
        option.click();

        System.out.println(option.getDomAttribute("value"));
    }
}
