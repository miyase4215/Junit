package day13_ActionsClass;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class C04_Actions04 extends TestBase {
    @Test
    public void actions() {
        driver.get("https://jqueryui.com/droppable/");

        //"Drag me to my target" elementini "Drop here" elementi üzerine bırakınız.
        driver.switchTo().frame(0);
        WebElement dragSource= driver.findElement(By.xpath("//*[@id='draggable']"));
        WebElement dropTarget=driver.findElement(By.xpath("//*[id='droppable']"));
        Actions actions=new Actions(driver);
        actions.dragAndDrop(dragSource, dropTarget).perform();
        //source(drag) webelementini alıp, target(drop) webelementinin üzerinin üzerine taşır

        /*
    https://jqueryui.com/droppable/ adresine gidin

    "Drag me to my target" elementini "Drop here" elementi üzerine bırakınız.*/

    }

    @Test
    public void actions02() {
        driver.get("https://jqueryui.com/droppable/");

        //"Drag me to my target" elementini "Drop here" elementi üzerine bırakınız.
        driver.switchTo().frame(0);
        WebElement dragSource= driver.findElement(By.xpath("//*[@id='draggable']"));
        WebElement dropTarget=driver.findElement(By.xpath("//*[id='droppable']"));
        Actions actions=new Actions(driver);
        actions.clickAndHold(dragSource).//webelementi tutup bekler
        moveToElement(dropTarget).//mouseu elementin üzerine taşır
        release().perform();
    }
}
