package day14_FakerClass_FileExist;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class C01_Actions extends TestBase {
    @Test
    public void actions() {
        /*
    "https://techproeducation.com/" gidin
    İlk kelime SHIFT tuşuna basılı şekilde, ikinci kelime basılmadan "TECHPRO education" araması yapın.
     */
        driver.get("https://techproeducation.com/");
        driver.findElement(By.xpath("//*[@class='elementor-widget-container']")).click();
        //İlk kelime Shift tuşuna basılı şekilde ikinci kelime basılmadan "TECHPRO education" araması yapın.
        WebElement search= driver.findElement(By.xpath("//*[@type='search']"));
        Actions actions=new Actions(driver);
        actions.keyDown(search, Keys.SHIFT).
                sendKeys("techpro").
                keyUp(Keys.SHIFT).
                sendKeys( " education",Keys.ENTER).perform();
        //Sayfayı Richmond Collage Enrollment From Linkine kadar scroll yapalım
        WebElement richmontCollege = driver.findElement(By.xpath("(//h3//a)[9]"));
        actions.scrollToElement(richmontCollege).perform();
        //ScrollToElement() methodu ile locate ettiğimiz
        // bir webElemente kadar yani o element görünene kadar scroll yapabilirsiniz.

    }
}
