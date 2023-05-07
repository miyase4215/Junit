package day_03_practice;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import utilities.TestBase;

import java.util.List;

public class C02_DropDownOptions extends TestBase {
    @Test
    public void test01() {
        //"https://amazon.com/" sayfasına gidelim
        driver.get("https://amazon.com/");
        //dropdowndan baby seçeneğini seçin
        WebElement ddm= driver.findElement(By.xpath("//select[@id='searchDropdownBox']"));
        //dropdowndan baby seçeneğini seçin
        Select select=new Select(ddm);
        select.selectByVisibleText("Baby");
        //seçtiğiniz options ı yazdırın
        String babyopt= select.getFirstSelectedOption().getText();
        System.out.println(babyopt);
        //dropdowndaki opsiyonların toplam sayısının 28 olduğunu test edin
        List<WebElement> optionsList=select.getOptions();
        int expectedOptionsNumbers=28;
        int actionOptionsNumber=optionsList.size();
        Assert.assertEquals(expectedOptionsNumbers,expectedOptionsNumbers);
        //dropdowndaki opsiyonların tamamını yazdırın
        int counter=1;
        for (WebElement w: optionsList){
            System.out.println(counter+" . option " +w.getText());
            counter++;
        }
    }

}
