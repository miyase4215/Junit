package day13_ActionsClass;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

import java.time.Duration;

public class C01_Actions01 extends TestBase {
    /*
    https://the-internet.herokuapp.com/context_menu  sitesine gidin
    Kutuya sağ tıklayın
    Alert’te cikan yazinin “You selected a context menu” oldugunu test edin
    Tamam diyerek alert’i kapatın
     */

    @Test
    public void actions() throws InterruptedException {
        //https://the-internet.herokuapp.com/context_menu  sitesine gidin
        driver.get("https://the-internet.herokuapp.com/context_menu");
        //Kutuya sağ tıklayın
        WebElement kutu = driver.findElement(By.id("hot-spot"));
        //Webelemente sağ click yapabilmek için Actions class'ından obje oluşturmalıyız
        Actions actions = new Actions(driver);
        actions.
                contextClick(kutu).//actions objesi ile sağClick methodu olan contextClick methodunu kullanırız.
                perform();//Action'ı sonlandırmak için perform() methodunu kullanırız
        Thread.sleep(Duration.ofSeconds(15));
        //Alert’te cikan yazinin “You selected a context menu” oldugunu test edin
        String alertText= driver.switchTo().alert().getText();
        Thread.sleep(Duration.ofSeconds(15));
        Assert.assertEquals( "You selected a context menu",alertText);
        //Tamam diyerek alert’i kapatın
        alertAccept();


    }
}
