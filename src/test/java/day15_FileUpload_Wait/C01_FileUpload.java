package day15_FileUpload_Wait;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

import java.awt.*;

public class C01_FileUpload extends TestBase {
    @Test
    public void fileUpload() {
        /*
    https://the-internet.herokuapp.com/upload adresine gidin

    b129.txt dosyasını yükleyin(upload)
    “File Uploaded!” textinin görüntülendiğini test edin
    */
        //https://the-internet.herokuapp.com/upload adresine gidin
        driver.get("https://the-internet.herokuapp.com/upload");
        //b129.txt dosyasını yükleyin(upload)
        WebElement dosyaSecWebElement= driver.findElement(By.id("file-upload"));
        bekle(3);
        String dosyaYolu= "C:\\Users\\Türkün Miyase Tura\\Desktop\\B129.txt";
        dosyaSecWebElement.sendKeys(dosyaYolu);
        //“File Uploaded!” textinin görüntülendiğini test edin
        Assert.assertTrue(driver.findElement(By.xpath("//*[text()='File Uploader']")).
                isDisplayed());


    }
}
