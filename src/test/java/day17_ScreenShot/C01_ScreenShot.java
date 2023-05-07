package day17_ScreenShot;

import org.apache.commons.io.FileUtils;
import org.junit.Test;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import utilities.TestBase;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class C01_ScreenShot extends TestBase {
    @Test
    public void test1() throws IOException {
        driver.get("https://amazon.com");
        //kaydettiğimiz ekran resmi her seferinde aynı dosyanın üzerine yazmaması
        // için dosya isminde sonra bir tarih atayabiliriz
        String tarih=new SimpleDateFormat("_hh_mm_ss_ddMMyyyy").format(new Date());
        String dosyaYolu="TestOutput/Screenshot"+ tarih + " .png";
        TakesScreenshot ts=(TakesScreenshot) driver;
        FileUtils.copyFile(ts.getScreenshotAs(OutputType.FILE), new File(dosyaYolu));
    }

    @Test
    public void screenShotTest() throws IOException {
       /*
            Tüm ekran görüntüsünü Selenium'dan gelen getScreenShotAs methodu ile alırız.
        Bu method selenium'daki TakesScreenshot arayüz'ünden(interface) gelir
         */
        //Techproeducation sayfasına gidelim
        driver.get("https://techproeducation.com");
        //1. adım:ilk olrak dosyayı nereye kaydedeceğimizi belirtiriz
        String dosyaYolu="screenShot.png";
        //2. adm:TakeScreenShot arayzünden object oluşturmak
        TakesScreenshot ts= (TakesScreenshot) driver;
        //3. adım:
        /*
        FileUtils class'ı file nesneleri ile birlikte kullanabileceğimiz methodlar içerir
        Bu methodları kullanarak dosyalarda okuma, yazma, kopyalama ve silme işlemlerini çok daha kolay yapabiliriz.
         Not: Files.write methodu da aynı işlemi görür
         */
        FileUtils.copyFile(ts.getScreenshotAs(OutputType.FILE), new File(dosyaYolu));

        //Ekran resmini projemize kaydedelim













    }
}
