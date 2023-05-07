package QATeam15Practice;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class Task_07 extends TestBase {

    @Test
    public void task7() {

//        - http://szimek.github.io/signature_pad/ sayfasına gidiniz
        driver.get("http://szimek.github.io/signature_pad/");
//        - Çıkan ekrana istediğiniz çizgi yada şekli çiziniz
        WebElement kutu= driver.findElement(By.xpath("//div[@class='signature-pad--body']"));
        Actions actions= new Actions(driver);
        //actions.click(kutu).perform();
        actions.clickAndHold(kutu).moveByOffset(-34,46).moveByOffset(45,-34).release().build().perform();
        bekle(3);


//        - Çizimden sonra clear butonuna basınız
        driver.findElement(By.xpath("//button[text()='Clear']")).click();
        bekle(2);
//        - Sayfayi kapatiniz
        driver.close();
    }
}