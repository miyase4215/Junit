package day11_Iframe_WindowHandle;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.WindowType;
import utilities.TestBase;

import java.util.ArrayList;
import java.util.List;

public class C02_WindowHandle extends TestBase {
    /*
    //Window 1'de https://www.techproeducation.com adresine gidiniz
    //Başlığın "Techpro Education | Online It Courses & Bootcamps" olduğunu doğrulayın
    //Window 2'de https://www.youtube.com sayfasını açınız:
    //Window 3'te https://www.linkedin.com sayfasını açınız:
    //techproeducation sayfasına geçiniz:
    //youtube sayfasına geçiniz:
    //linkedIn sayfasına geçiniz:
     */

    @Test
    public void windowHandle() {
        //Window 1'de https://www.techproeducation.com adresine gidiniz
        driver.get("https://www.techproeducation.com");
        //String techproWindowHandle= driver.getWindowHandle();
        //Başlığın "Techpro Education | Online It Courses & Bootcamps" olduğunu doğrulayın
        String actualTitle= driver.getTitle();
        String expectedTitle="Techpro Education | Online It Courses & Bootcamps";
        Assert.assertEquals(actualTitle,expectedTitle);
        //Window 2'de https://www.youtube.com sayfasını açınız:
        driver.switchTo().//geçiş yap
                newWindow(WindowType.WINDOW);//tab yazarsak yeni sekmede window yazarsak yeni pencerede açar
        driver.get("https://www.youtube.com");
        //String youtubeWindowHandle= driver.getWindowHandle();
        //youtube sayfasına geri dönmek için windowHandle değerini bir String'e assign ettikaldık

        //Window 3'te https://www.linkedin.com sayfasını açınız:
        driver.switchTo().
                newWindow(WindowType.WINDOW);
        driver.get("https://www.linkedin.com");
        //String linkedinWindowHandle=driver.getWindowHandle();

        List<String> tumWindowList=new ArrayList<String>(driver.getWindowHandles());
        //bütün açtığım penceredeki handle değerlerini bir ArrayList'e atadık

        //techproeducation sayfasına geçiniz:
        bekle(3);
        //driver.switchTo().window(techproWindowHandle);
        driver.switchTo().window(tumWindowList.get(0));

        //youtube sayfasına geçiniz:
        bekle(3);
        //driver.switchTo().window(youtubeWindowHandle);
        driver.switchTo().window(tumWindowList.get(1));

        //linkedIn sayfasına geçiniz:
        bekle(3);
        //driver.switchTo().window(linkedinWindowHandle);
        driver.switchTo().window(tumWindowList.get(2));

    }
}
