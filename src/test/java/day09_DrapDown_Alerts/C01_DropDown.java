package day09_DrapDown_Alerts;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;
import java.util.List;

public class C01_DropDown {
    WebDriver driver;
    @Before
    public void setUp() throws Exception {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver(new ChromeOptions().addArguments("--remote-allow-origins=*"));
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get("https://testcenter.techproeducation.com/index.php?page=dropdown");
    }
    /*
    DropDown nedir:Altbaşlıkların olduğu açılır menü lisatesi
    -DropDown nasıl automate(handle) edilir?
    a-DropDown menuyu ilk olarak locate ederiz.
    b-Select objesi oluştururuz.
    c-Select objesinin DropDown menu Webelementinin icerigine ve seceneklerine
      erisim saglamasi icin Select sinifina argument olarak Locate ettigimiz
      webelementi koyariz
      ORNEK: Select select= new Select(DDM Webelement)

      d-Select class'i sadece <select> tag'i ile olusturulmus DropDown menulere uygulanabilir.
      e-Select objesi ile ddm menuyu handle etmek için kullanılan  3 method vardır:
      -SelectByVisibleText()-->ddmdeki elemente görünür metin ile ulaşmak için kullanılır.
      -SelectByIndex()-->ddmdeki elemente index ile ulaşmak için kullanılır.
      -SelectByValue methodlari var-->ddmdeki elemente elementin değeri(option tag'ındaki değer)
       ile ulaşmak için kullanılır.
      f-getOptions()-->Locate ettiğimiz ddm'deki tüm seçenekleri bize döndürür.
      g-getFirstSelectedOption()-->Ddm'deki en son seçili kalan ilk seçeneği bize döndürür.


     */
    @Test
    public void test02() {
       /* //a. Tüm eyalet isimlerini yazdıralım
        WebElement tumEyaletler = driver.findElement(By.cssSelector("select[id='state']"));
        Select select = new Select(tumEyaletler);
        List<WebElement> stateList = select.getOptions();//Bütün options taglarını getir
        //for (WebElement w:stateList) {
        //    System.out.println(w.getText());
        // }
        stateList.forEach(t-> System.out.println(t.getText()));*/
        //a. Tüm eyalet isimlerini yazdıralım
        List<WebElement> tumEyaletler= driver.findElements(By.xpath("//*[@id='state']//option"));
        tumEyaletler.forEach(t-> System.out.println(t.getText()));
        //Sayfadaki tüm ddm menülerdeki tüm seçenekleri(option) konsolda yazdırınız.
        List<WebElement> eyaletlerList=driver.findElements(By.tagName("option"));
        eyaletlerList.forEach(t-> System.out.println(t.getText()));
        System.out.println(tumEyaletler.size());
    }

    @After
    public void tearDown() throws Exception {
        Thread.sleep(3000);
        driver.close();
    }
}

