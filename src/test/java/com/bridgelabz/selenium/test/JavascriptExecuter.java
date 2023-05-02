package com.bridgelabz.selenium.test;

import com.bridgelabz.selenium.Baseclass.Baseclass;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.Iterator;
import java.util.Set;


public class JavascriptExecuter extends Baseclass {

    @BeforeTest
    public void init() {
        setUp();
        driver.get("https://www.guru99.com/execute-javascript-selenium-webdriver.html");
    }

    @Test
    public void JavascriptExecutorScroll() throws InterruptedException {
        JavascriptExecutor executor = (JavascriptExecutor) driver;
        executor.executeScript("window.scrollBy(0,1000)");
        Thread.sleep(1000);
        WebElement element = driver.findElement(By.xpath("//h3[@id = '3-example-scroll-down-using-javascriptexecutor']"));
        executor.executeScript("arguments[0].scrollIntoView();", element);

        executor.executeScript("window.scrollBy(0,-250)");

        //executor.executeScript("window.scrollBy(250,0)");

        WebElement linkElement = driver.findElement(By.linkText("https://demo.guru99.com/V4/"));
        executor.executeScript("arguments[0].click();", linkElement);
        String parentWindowAddress = driver.getWindowHandle();
        System.out.println("Parent Window Address : " + parentWindowAddress);

        Set<String> allWidows = driver.getWindowHandles();
        System.out.println("No of windows present : " + allWidows.size());

        Iterator<String> iterator = allWidows.iterator();
        while (((Iterator<?>) iterator).hasNext()) {
            String childWindow = iterator.next();
            if (!parentWindowAddress.equalsIgnoreCase(childWindow)) {
                driver.switchTo().window(childWindow);
                WebElement enterUser = driver.findElement(By.name("uid"));
                executor.executeScript("arguments[0].setAttribute('value', '\" longstring \"')", enterUser);
                //driver.close();
            }
        }
    }
}
