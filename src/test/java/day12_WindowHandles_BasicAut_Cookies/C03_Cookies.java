package day12_WindowHandles_BasicAut_Cookies;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.Cookie;
import utilities.TestBase;

import java.util.Set;

public class C03_Cookies extends TestBase {
    /*
    1-Amazon anasayfaya gidin
    2-tum cookie’leri listeleyin
    3-Sayfadaki cookies sayisinin 5’den buyuk oldugunu test edin
    4-ismi i18n-prefs olan cookie degerinin USD oldugunu test edin
    5-ismi “en sevdigim cookie” ve degeri “cikolatali” olan bir cookie  olusturun ve sayfaya ekleyin
    6-eklediginiz cookie’nin sayfaya eklendigini test edin
    7-ismi skin olan cookie’yi silin ve silindigini test edin
    8-tum cookie’leri silin ve silindigini test edin
     */

    @Test
    public void cookies() {
        // 1-Amazon anasayfaya gidin
        driver.get("https://amazon.com");
        // 2-tum cookie’leri listeleyin
        //tüm cookieleri listeleyebilmek için driver.manage.getcookies methodu kullanırız
        Set<Cookie> cookieSet= driver.manage().getCookies();
        int sayac=1;
        for (Cookie w:cookieSet) {
            System.out.println(sayac+ ".ci cookie: "+w );
            System.out.println("Name : "+w.getName());
            System.out.println("Value : "+w.getValue());
            sayac++;
        }
        // 3-Sayfadaki cookies sayisinin 5’den buyuk oldugunu test edin
        int cookieSayısı=cookieSet.size();
        Assert.assertTrue(cookieSayısı>5);

        //4-ismi i18n-prefs olan cookie degerinin USD oldugunu test edin
        String cookieValue=driver.manage().getCookieNamed("i18n-prefs").getValue();
        Assert.assertEquals("USD",cookieValue);

        //5-ismi “en sevdigim cookie” ve degeri “cikolatali” olan bir cookie  olusturun ve sayfaya ekleyin
        Cookie cookie=new Cookie("en sevdigim cookie", "cikolatali");
        driver.manage().addCookie(cookie);//manage methodu yönet demek
        cookieSet=driver.manage().getCookies();

        //6-eklediginiz cookie’nin sayfaya eklendigini test edin
        sayac=1;
        for (Cookie cookie1:cookieSet){
            System.out.println(sayac+".ci cookie: "+cookie1);
            sayac++;
        }
        //7-ismi skin olan cookie’yi silin ve silindigini test edin
        driver.manage().deleteCookieNamed("skin");
        Assert.assertFalse(cookieSet.contains("skin"));
        //8-tum cookie’leri silin ve silindigini test edin
        driver.manage().deleteAllCookies();
        Assert.assertTrue(cookieSet.isEmpty());
    }
}
