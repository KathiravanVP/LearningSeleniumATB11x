package com.kathiravanvp.ex08_JavaScript_Executor;

import com.kathiravanvp.CommonToAll.CommonToAll;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class TestSelenium26_JS_Executor extends CommonToAll {
    @Test
    public void js_executor() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.location = 'https://www.google.com'");

        driver.get("https://selectorshub.com/xpath-practice-page/");

        WebElement div_to_scroll = driver.findElement(By.xpath("//div[@id='userName']"));


        js.executeScript("window.scrollBy(0, 500);");


        String url = js.executeScript("return document.URL;").toString();
        System.out.println(url);
        String title = js.executeScript("return document.title;").toString();
        System.out.println(title);

    }
}
