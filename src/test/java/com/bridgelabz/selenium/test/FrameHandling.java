package com.bridgelabz.selenium.test;

import com.bridgelabz.selenium.Baseclass.Baseclass;
import org.testng.annotations.BeforeTest;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;
import java.util.List;


public class FrameHandling extends Baseclass {

    @BeforeTest
    public void init()
    {
        setUp();
    }

    @Test
    public void frameHandlingDemo(){
        driver.get("https://www.guru99.com/execute-javascript-selenium-webdriver.html");
        List<WebElement> allFrames = driver.findElements(By.xpath("//iframe"));
        int totalFrames = allFrames.size();
        System.out.println("No of frames  : "+totalFrames);
        for (int i = 0 ; i<totalFrames ; i++){
            System.out.println("Page Source "+i+ ": "+ driver.switchTo().frame(i).getPageSource());
        }
    }

    @Test
    public void frameHandling2(){
        driver.get("https://jqueryui.com/droppable/");
        Actions actions = new Actions(driver);

        List<WebElement> allFrames = driver.findElements(By.tagName("iframe"));
        int totalFrames = allFrames.size();
        System.out.println("No of frames  : "+totalFrames);
        for (int i = 0 ; i< totalFrames ; i++){
            driver.switchTo().frame(i);
            System.out.println("Frame Title: "+driver.findElement(By.tagName("title")).getAttribute("innerHTML"));
            WebElement srcElement = driver.findElement(By.id("draggable"));
            WebElement destElement = driver.findElement(By.id("droppable"));
            actions.dragAndDrop(srcElement,destElement).perform();
        }
        //driver.switchTo().defaultContent();
        driver.switchTo().parentFrame();
        System.out.println("Frame Title: "+driver.getTitle());
        driver.findElement(By.linkText("Draggable")).click();
//        driver.switchTo().frame(0);
//        System.out.println("Frame Title "+driver.getTitle());
    }

    @Test
    public void fbActionsClass(){
        driver.get("https://www.facebook.com/");
        Actions actions = new Actions(driver);

        WebElement email = driver.findElement(By.id("email"));
        actions.moveToElement(email)
                .click()
                .keyDown(email, Keys.SHIFT)
                .sendKeys(email, "testing")
                .keyUp(email,Keys.SHIFT)
                .doubleClick(email)
                .build().perform();
        WebElement loginBtn  = driver.findElement(By.name("login"));
        actions.moveToElement(loginBtn).click().perform();
    }

    @Test
    public void scrollUsingActionsClass() throws InterruptedException {
        driver.get("https://www.amazon.com/");
        Actions actions = new Actions(driver);

        //actions.sendKeys(Keys.PAGE_DOWN).perform();
        actions.keyDown(Keys.CONTROL).sendKeys(Keys.END).perform();
        Thread.sleep(3000);
        //actions.sendKeys(Keys.PAGE_UP).perform();
        actions.keyDown(Keys.CONTROL).sendKeys(Keys.HOME).perform();
    }
}
