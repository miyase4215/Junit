package day12_WindowHandles_BasicAut_Cookies;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class C02_BasicAuthentication extends TestBase {


    @Test
    public void basicAuthentication() {
        // url:https://the-internet.herokuapp.com/basic_auth sayfasına gidelim
        driver.get("https:admin:admin@the-internet.herokuapp.com/basic_auth");
        //https:admin:admin@the-internet.herokuapp.com/basic_auth
        //paragrafın "Cangratulations" kelimesini içerdiğini doğrulayınız
        WebElement paragraf=driver.findElement(By.xpath("//p"));
        Assert.assertTrue(paragraf.getText().contains("Congratulations"));
    }
}
