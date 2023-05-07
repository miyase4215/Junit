package day13_ActionsClass;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class ActionsTest2 extends TestBase {
    @Test
    public void actions02() {
        //Amazon anasayfasına gidin
        driver.get("https://amazon.com");
        //"Account & List" üzerinde bekleyin (mouse over - hover over)
        WebElement accountList=driver.findElement(By.xpath("//*[@class='nav-line-2 ']"));
        Actions actions=new Actions(driver);
        actions.moveToElement(accountList).perform();

        //Açılan menüde "Account" linkine tıklayın
        WebElement account=driver.findElement(By.xpath("(//*[@class='nav-text'])[3]"));
        actions.click(account).perform();

        //Açılan sayfanın başlığının "Your Account" içerdiğini doğrulayın
        String title=driver.getTitle();
        Assert.assertTrue(title.contains("Your Account"));
        //40
    }
}
