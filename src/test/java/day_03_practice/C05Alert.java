package day_03_practice;

import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class C05Alert extends TestBase {
    //https://demo.guru99.com/testradio.html adresine gidin
    //customer id kısmına 53920 yazın
    //submit butonuna tıklayın
    //çıkan alert mesajını yazdırın
    //alert'ü kabul edin
    //çıkan 2. alert mesajını yazdırın
    //çıkan 2. alerti kabul edin

    @Test
    public void test01() {
        driver.get("https://demo.guru99.com/test/delete_customer.php");
        //customer id kısmına 53920 yazın
        WebElement customer= driver.findElement(By.xpath("//input[@name='cusid']"));
        customer.sendKeys("53920");
        //submit butonuna tıklayın
        driver.findElement(By.xpath("//input[@name='submit']")).click();
        //çıkan alert mesajını yazdırın
        String alert1=driver.switchTo().alert().getText();
        System.out.println(alert1);
        //alert'ü kabul edin
        driver.switchTo().alert().accept();
        //çıkan 2. alert mesajını yazdırın
        String alert2=driver.switchTo().alert().getText();
        System.out.println(alert2 );
        //çıkan 2. alerti kabul edin
        driver.switchTo().alert().accept();
    }
}
