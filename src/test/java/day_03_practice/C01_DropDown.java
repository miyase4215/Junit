package day_03_practice;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import utilities.TestBase;

public class C01_DropDown extends TestBase {
    //amazon.com sayfasına gidiniz
    //dropdown'dan "Books" seçeneğini seçin
    //arama çubuğunda "java aratın
    //arama sonuçlarının java içerip içermediğini test edin


    @Test
    public void test01() {
        /*drop down 3 adımda locate edilir
        1.drop down locate edilmeli
        2.select object oluşturulmalı
        3.opsiyonlardan bir tanesi seçilmelidir
        select drop downların tagıdır. select gördüğünde dropdown dropdown görünce aklına select gelsin
         */

        driver.get("https://amazon.com/");
        // 1.drop down locate edilmeli
        WebElement dropDown= driver.findElement(By.xpath("//select[@id='searchDropdownBox']"));
        //2.select object oluşturulmalı
        Select select=new Select(dropDown);
        //3.opsiyonlardan bir tanesi seçilmelidir
        //seçmek için 3 yöntem var: selectbyvisibletext,selectbyindex,selectbyvalue
        select.selectByVisibleText("Books");
        //arama çubuğunda "java aratın
         driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']")).
                 sendKeys("java", Keys.ENTER);
        //arama sonuçlarının java içerip içermediğini test edin
        WebElement result=driver.findElement(By.xpath("//div[@class='a-section a-spacing-small a-spacing-top-small']"));
        String resultText=result.getText();
        Assert.assertTrue(resultText.contains("java"));
        //5. session selenium practice 50:00



    }
}
