package day_03_practice;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class C03_CheckBox extends TestBase {

    //checkbox elementlerini locate edin
    //checkbox1 ve checkbox 3 seçili değilse seçin
    //checkbox1 ve checkbox 3 seçili olduğunu test edin
    //checkbox2elementinin seçiliolmadığını test edin


    @Test
    public void test01() {
        //https://demo.guru99.com/testradio.html adresine gidin
        driver.get("https://demo.guru99.com/test/radio.html");
        //checkbox elementlerini locate edin
        WebElement checkBox1= driver.findElement(By.xpath("//input[@id='vfb-6-0']"));
        WebElement checkBox2= driver.findElement(By.xpath("//input[@id='vfb-6-1']"));
        WebElement checkBox3= driver.findElement(By.xpath("//input[@id='vfb-6-2']"));
        //checkbox1 ve checkbox 3 seçili değilse seçin
        if (!checkBox1.isSelected()){
            checkBox1.click();
        }
        if (!checkBox3.isSelected()){
            checkBox3.click();
        }

        //checkbox1 ve checkbox 3 seçili olduğunu test edin
        Assert.assertTrue(checkBox1.isSelected());
        Assert.assertTrue(checkBox3.isSelected());
        //checkbox2 elementinin seçili olmadığını test edin
        Assert.assertFalse(checkBox2.isSelected());

    }
}
