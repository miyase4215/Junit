package day12_WindowHandles_BasicAut_Cookies;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.Cookie;
import utilities.TestBase;

import java.util.Set;

public class C03_CookiesTest extends TestBase {
    @Test
    public void cookies() {
        driver.get("https://amazon.com");
        //tüm cookieleri listeleyin

       Set<Cookie> cookieSet=driver.manage().getCookies();
       int counter=1;
       for (Cookie w:cookieSet){
           System.out.println(counter+ ".ci cookie" +w);
           System.out.println("name "+w.getName());
           System.out.println("değeri "+w.getValue());
           counter++;
       }
       //sayfadaki cookies sayısının 5den fazla olduğunu test edin
        System.out.println(counter);
       int cookieNum=cookieSet.size();
        Assert.assertTrue(cookieNum>5);
        //İSMİ i18N-prefs OLAN cookie değerinin USD olduğunu test edin
       //String cookieValue=driver.manage().getCookieNamed("i18N-prefs").getValue();
       //Assert.assertEquals("USD",cookieValue);
       //ismi "en sevdiğim cookie" ve değeri "cikolatalı" olan bir cookie oluşturun ve sayfaya ekleyin
        Cookie cookie=new Cookie("en sevdiğim cookie","cikolatalı");
        driver.manage().addCookie(cookie);
        cookieSet=driver.manage().getCookies();


        //ismi skin olan cookie'yi silin ve silindiğini test edin
        driver.manage().deleteCookieNamed("skin");
        cookieSet=driver.manage().getCookies();
       Assert.assertFalse(cookieSet.contains("skin"));
       //tüm cookieleri silin ve silindiğini test edin
        driver.manage().deleteAllCookies();
        cookieSet=driver.manage().getCookies();
        Assert.assertTrue(cookieSet.isEmpty());



    }
}
