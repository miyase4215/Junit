package QATeam15Practice;


import org.apache.xmlbeans.impl.xpath.Path;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class Task_10 extends TestBase {
    @Test
    public void Test01() {
    //https://www.selenium.dev/downloads/ adresine gidelim
        driver.get("https://www.selenium.dev/downloads/");
    //Platforms Supported by Selenium altındaki Browsers bölümü görünene kadar sayfayı indirelim
        WebElement browser=driver.findElement(By.xpath("(//button[@type='button'])[85]"));
        Actions actions=new Actions(driver);
        actions.moveToElement(browser).perform();bekle(2);
    //Browser bölümünden Chrome driver bölümündeki documentation linkine tıklıyalım
        browser.click();
        bekle(1);

        WebElement chrome=driver.findElement(By.xpath("(//*[text()='documentation'])[5]"));
        actions.scrollToElement(chrome).perform();
        chrome.click();
        bekle(8);
    //All versions available in Downloads altında Latest stable release olan linki tıklayalım

        List<String> pages=new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(pages.get(1));
        driver.findElement(By.xpath("//*[text()='ChromeDriver 112.0.5615.49']"));
        // Açılan pencerede chromedriver'i indirelim

       WebElement win32= driver.findElement(By.xpath("//*[text()='chromedriver_win32.zip']"));
       win32.click();

    //Driver'in indiğini doğrulayalım
        String dosyaIsmi=win32.getText();
        String home=System.getProperty("user_home");
        String indirilenler=home+"//Downloads/"+dosyaIsmi;
        File file=new File(indirilenler);

        if (Files.exists(Paths.get(dosyaIsmi))){
            file.delete();
        }else System.out.println("Dosya yok");
        Assert.assertFalse(Files.exists(Paths.get(indirilenler)));

    }
}
