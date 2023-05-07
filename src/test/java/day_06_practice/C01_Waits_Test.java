package day_06_practice;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.TestBase;

import java.time.Duration;

public class C01_Waits_Test extends TestBase {
    @Test
    public void waitTest() {
        // https://the-internet.herokuapp.com/dynamic_controls adresine gidiniz
        driver.get("https://the-internet.herokuapp.com/dynamic_controls");
        // Textbox'in etkin olmadıgını(enable) test edin
        WebElement textbox= driver.findElement(By.xpath("//input[@type='text']"));
        Assert.assertFalse(textbox.isEnabled());
        // Enable butonuna tıklayın ve textbox etkin oluncaya kadar bekleyin
        driver.findElement(By.xpath("(//button[@type='button'])[2]")).click();
        WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.elementToBeClickable(textbox));

        // It's enable! mesajının goruntulendigini test edin
        WebElement message= driver.findElement(By.xpath("//p[@id='message']"));
        Assert.assertTrue(message.isDisplayed());

        // Textbox'in etkin oldugunu(enable) test edin
        Assert.assertTrue(textbox.isEnabled());
    }
}
