package com.kathiravanvp.ex06_File_Upload;

import com.kathiravanvp.CommonToAll.CommonToAll;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class TestSelenium23_FileUpload extends CommonToAll {
    @Test
    public void file_Upload(){
        driver.get("https://awesomeqa.com/selenium/upload.html");
        WebElement uploadFile = driver.findElement(By.id("fileToUpload"));

        String working_dir = System.getProperty("user.dir");


        String path_file = working_dir+"/src/test/java/com/kathiravanvp/zData.txt";

        uploadFile.sendKeys(path_file);
        driver.findElement(By.name("submit")).click();

    }
}
