package com.kathiravanvp.ex07_Windows_Functions;

import com.kathiravanvp.CommonToAll.CommonToAll;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

public class TestSelenium25_Iframes extends CommonToAll {
    @Test
    public void test_Iframes(){
        driver.get("https://app.vwo.com/#/test/ab/13/heatmaps/1?token=eyJhY2NvdW50X2lkIjo2NjY0MDAsImV4cGVyaW1lbnRfaWQiOjEzLCJjcmVhdGVkX29uIjoxNjcxMjA1MDUwLCJ0eXBlIjoiY2FtcGFpZ24iLCJ2ZXJzaW9uIjoxLCJoYXNoIjoiY2IwNzBiYTc5MDM1MDI2N2QxNTM5MTBhZDE1MGU1YTUiLCJzY29wZSI6IiIsImZybiI6ZmFsc2V9&isHttpsOnly=1&accountId=666400");

        String parent = driver.getWindowHandle();
        System.out.println("Parent - "+parent);

        List<WebElement> heatmaps = driver.findElements(By.xpath("//div[@data-qa=\"yedexafobi\"]"));

        Actions actions = new Actions(driver);

        actions.moveToElement(heatmaps.get(1)).click().build().perform();

        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

        Set<String> all_Handles  =  driver.getWindowHandles();
        System.out.println(all_Handles);

        for (String handle : all_Handles){
            if (!handle.equals(parent)){
                driver.switchTo().window(handle);
                driver.switchTo().frame("heatmap-iframe");
                driver.findElement(By.xpath("//span[@data-qa=\"refoyekife\"]")).click();
            }
        }


    }
}
