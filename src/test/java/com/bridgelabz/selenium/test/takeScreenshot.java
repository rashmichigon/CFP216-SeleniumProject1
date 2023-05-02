package com.bridgelabz.selenium.test;

import com.bridgelabz.selenium.Baseclass.Baseclass;
import org.testng.annotations.BeforeTest;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.io.FileHandler;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import java.io.File;
import java.io.IOException;

public class takeScreenshot extends Baseclass {

    @BeforeTest
    public void init()
    {
        setUp();
        driver.get("https://www.facebook.com/");
    }

    @Test
    public void takeScreenshotOfApp() throws IOException {
        TakesScreenshot src =(TakesScreenshot) driver;
        File srcShot = src.getScreenshotAs(OutputType.FILE);
        File destShot = new File("F:\\Database Automation Files\\Selenium_Instagram\\Screenshots\\fb1.jpeg");
        FileHandler.copy(srcShot,destShot);
        //FileUtils.copyFile(srcShot,destShot);
    }

    @Test
    public void screenshotOdSpecificWebElement() {
        WebElement emailShot = driver.findElement(By.id("email"));
        File srcShot = emailShot.getScreenshotAs(OutputType.FILE);
        File destShot = new File("F:\\Database Automation Files\\Selenium_Instagram\\Screenshots\\fb2.jpeg");
        try {
            FileHandler.copy(srcShot,destShot);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
