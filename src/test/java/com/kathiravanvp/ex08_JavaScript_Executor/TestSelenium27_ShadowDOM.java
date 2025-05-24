package com.kathiravanvp.ex08_JavaScript_Executor;

import com.kathiravanvp.CommonToAll.CommonToAll;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class TestSelenium27_ShadowDOM extends CommonToAll {
    @Test
    public void shadow_DOM(){
        driver.get("https://selectorshub.com/xpath-practice-page/");
        driver.manage().window().maximize();

        waitForJVM(3000);

        JavascriptExecutor js = (JavascriptExecutor) driver;
        WebElement inputboxPizza = (WebElement) js.executeScript("return document.querySelector(\"div#userName\").shadowRoot.querySelector('div#app2').shadowRoot.querySelector('#pizza');");
        inputboxPizza.sendKeys("Margherita");
    }
}
