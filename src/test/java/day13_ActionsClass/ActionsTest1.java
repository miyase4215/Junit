package day13_ActionsClass;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class ActionsTest1 extends TestBase {
    @Test
    public void actions01() {

    //https://the-internet.herokuapp.com/context_menu  sitesine gidin
        driver.get("https://the-internet.herokuapp.com/context_menu");
    //Kutuya sağ tıklayın
        WebElement box= driver.findElement(By.xpath("//div[@id='hot-spot']"));
        Actions actions=new Actions(driver);
        actions.contextClick(box).perform();
    //Alert’te cikan yazinin “You selected a context menu” oldugunu test edin
        String alertext=driver.switchTo().alert().getText();
        Assert.assertEquals("You selected a context menu",alertext);

    //Tamam diyerek alert’i kapatın
        driver.switchTo().alert().accept();

    }
}
