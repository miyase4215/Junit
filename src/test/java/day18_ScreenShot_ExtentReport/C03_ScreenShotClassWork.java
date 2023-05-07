package day18_ScreenShot_ExtentReport;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import utilities.TestBase;

public class C03_ScreenShotClassWork extends TestBase {
    //Techproeducation sayfasına gidelim
    //sayfanın resmini alalım
    //Arama bölümünde java aratalım
    //ve sonuc yazısının resmini alalım
    //Yeni bir sekmede amazona gidelim
    //sayfanın resmini alalım
    //arama bölümde iphone aratalım
    //ve sonuc yazısının resmini alalım
    //tekrar tecpro sayfasına geçelim ve sayfa resmini alalım
    @Test
    public void classWork() {
        //Techproeducation sayfasına gidelim
        driver.get("https://techproeducation.com/");
        bekle(3);
        driver.findElement(By.xpath("//i[@class='eicon-close']")).click();
        //sayfanın resmini alalım
        tumSayfaResmi();
        //Arama bölümünde java aratalım
        driver.findElement(By.xpath("//input[@type='search']")).sendKeys("java", Keys.ENTER);
        //ve sonuc yazısının resmini alalım
        //Yeni bir sekmede amazona gidelim
        //sayfanın resmini alalım
        //arama bölümde iphone aratalım
        //ve sonuc yazısının resmini alalım
        //tekrar tecpro sayfasına geçelim ve sayfa resmini alalım

    }
}
