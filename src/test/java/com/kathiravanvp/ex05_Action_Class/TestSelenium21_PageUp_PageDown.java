package com.kathiravanvp.ex05_Action_Class;

import com.kathiravanvp.CommonToAll.CommonToAll;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class TestSelenium21_PageUp_PageDown extends CommonToAll {
    @Test
    public void pageUpDown(){
        String url = "https://thetestingacademy.com/";
        driver.get(url);

        Actions actions = new Actions(driver);
        actions.sendKeys(Keys.PAGE_DOWN).sendKeys(Keys.PAGE_DOWN).sendKeys(Keys.PAGE_UP).build().perform();
    }
}
