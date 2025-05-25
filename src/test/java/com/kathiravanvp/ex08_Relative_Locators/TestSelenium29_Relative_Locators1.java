package com.kathiravanvp.ex08_Relative_Locators;

import com.kathiravanvp.CommonToAll.CommonToAll;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import static org.openqa.selenium.support.locators.RelativeLocator.*;

public class TestSelenium29_Relative_Locators1 extends CommonToAll {
    @Test
    public void test_RL1() {
        driver.get("https://codepen.io/AbdullahSajjad/full/LYGVRgK");

        driver.switchTo().frame("result");

        driver.findElement(By.xpath("//input[@id=\"username\"]")).sendKeys("Kathiravan");

        WebElement email = driver.findElement(By.xpath("//input[@id=\"email\"]"));
        email.sendKeys("abc123");

        driver.findElement(By.xpath("//input[@id=\"password\"]")).sendKeys("doe@46@#$6345fgv5%");

        driver.findElement(By.xpath("//input[@id=\"password2\"]")).sendKeys("doe@46@#$6345fgv5%");

        driver.findElement(By.xpath("//form[@id=\"form\"]/button")).click();

        WebElement error = driver.findElement(with(By.tagName("small")).below(email));
        System.out.println(error.getText());
    }
}
