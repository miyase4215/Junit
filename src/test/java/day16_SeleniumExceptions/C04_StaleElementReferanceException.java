package day16_SeleniumExceptions;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class C04_StaleElementReferanceException extends TestBase {
    /*StaleElementReferanceException:
    Bir web sayfasındaki bir webelementin geçerliliğinin kaybolduğu durumlarda oluşur.
    Yani bir webelementi locate ettikten sonra -forward kullanıyorsak yeniden o elemente ulaşmak istediğimizde bu hatayı alırız
    bunu handle edebilmek için webelemente  ywniden locate atamalıyız.(webelementin locate'ini hatırlatma gibi)
     */
    @Test
    public void StaleElementReferanceExceptionTest1() {
        //techpro sayfasına gidelim
        driver.get("https://techproeducation.com");
        bekle(2);
        driver.findElement(By.xpath("//*[@class='eicon-close']")).click();//Reklam kapatmak için
        //Sayfaya gittikten sonra sayfayı yenileyelim
        driver.navigate().refresh();
        //login butonuna tıklayalım
        driver.findElement(By.xpath("(//*[text()='LMS LOGIN'])[1]")).click();
    }

    @Test
    public void StaleElementReferanceExceptionTest2() {
        //techpro sayfasına gidelim
        driver.get("https://techproeducation.com");
        bekle(2);
        driver.findElement(By.xpath("//*[@class='eicon-close']")).click();//Reklam kapatmak için

        //login butonuna tıklayalım
        WebElement login = driver.findElement(By.xpath("(//*[text()='LMS LOGIN'])[1]"));

        //Sayfaya gittikten sonra sayfayı yenileyelim
        driver.navigate().refresh();

        //login'e tıklayınız
        login.click();
        //sayfayı yeniledikten sonra click yaptığımız için exception alırız.
    }
    @Test
    public void StaleElementReferanceExceptionTest3() {
        //techpro sayfasına gidelim
        driver.get("https://techproeducation.com");
        bekle(2);
        driver.findElement(By.xpath("//*[@class='eicon-close']")).click();//Reklam kapatmak için

        //login butonuna tıklayalım
        WebElement login = driver.findElement(By.xpath("(//*[text()='LMS LOGIN'])[1]"));

        //Sayfaya gittikten sonra sayfayı yenileyelim
        driver.navigate().refresh();

        //login'e tıklayınız
         login = driver.findElement(By.xpath("(//*[text()='LMS LOGIN'])[1]"));
        login.click();
        //sayfayı yeniledikten sonra click yaptığımız için exception alırız.
    }
}
