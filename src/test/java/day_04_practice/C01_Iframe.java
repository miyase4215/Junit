package day_04_practice;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

import javax.swing.*;

public class C01_Iframe extends TestBase {
    // https://html.com/tags/iframe sayfasına gidiniz
    // Videoyu görecek kadar asagiya ininiz
    // Videoyu izlemek icin Play tusuna basiniz
    // Videoyu calistirdiginizi test ediniz
    // 'Powerful,but easy to misuse' yazısının gorunur oldugunu test ediniz

    @Test
    public void test01() {
        // https://html.com/tags/iframe sayfasına gidiniz
        driver.get("https://html.com/tags/iframe");
        // Videoyu görecek kadar asagiya ininiz
        Actions actions=new Actions(driver);
        actions.sendKeys(Keys.PAGE_DOWN).sendKeys(Keys.PAGE_DOWN).perform();
        // Videoyu izlemek icin Play tusuna basiniz
        WebElement iframe=driver.findElement(By.xpath("//iframe[@src='https://www.youtube.com/embed/owsfdh4gxyc']"));
        driver.switchTo().frame(iframe);
        WebElement play=driver.findElement(By.xpath("//button[@class='ytp-large-play-button ytp-button ytp-large-play-button-red-bg']"));
        play.click();
        /*
        play'i doğru locate edip click yapmamıza rağmen videoyu çalıştırmadı bunun üzerine html kodlarını inceleyince;
        playin aslında bir iframe içerisinde olduğunu gördük.
        Bunun üzerine önce iframe'i locate ediP, swich to() ile içteki web sayfasına geçtik.
         */

        // Videoyu calistirdiginizi test ediniz
        WebElement youTubeYazısı=driver.findElement(By.xpath("//a[@class='ytp-youtube-button ytp-button yt-uix-sessionlink']"));
        Assert.assertTrue(youTubeYazısı.isDisplayed());
        // 'Powerful,but easy to misuse' yazısının gorunur oldugunu test ediniz
        driver.switchTo().parentFrame();
        WebElement powerYazısı=driver.
                findElement(By.xpath("//span[@id='Powerful_but_easy_to_misuse']"));
        Assert.assertTrue(powerYazısı.isDisplayed());
    }
}
