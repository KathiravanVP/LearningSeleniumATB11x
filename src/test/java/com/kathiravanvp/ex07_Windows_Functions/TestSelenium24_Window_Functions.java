package com.kathiravanvp.ex07_Windows_Functions;

import com.kathiravanvp.CommonToAll.CommonToAll;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

import java.util.Set;

public class TestSelenium24_Window_Functions extends CommonToAll {
    @Test
    public void Window_Functions(){
        driver.get("https://the-internet.herokuapp.com/windows");

        String parent = driver.getWindowHandle();
        System.out.println(parent);

        driver.findElement(By.xpath("//a[text() = \"Click Here\"]")).click();

        Set<String> all_windows = driver.getWindowHandles();
        System.out.println(all_windows);

        for (String handle : all_windows){
            driver.switchTo().window(handle);
            if (driver.getPageSource().contains("New Window")){
                System.out.println("Test Case Passed!!");
            }
        }

    }
}
