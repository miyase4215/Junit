package day14_FakerClass_FileExist;

import org.junit.Assert;
import org.junit.Test;

import java.nio.file.Files;
import java.nio.file.Paths;

public class C03_FileExist {
    @Test
    public void fileExist() {
        //masaüstünde bir dosya oluşturalım ve bu dosyanın varlığını doğrulayalım

        //Projenin içinde bulunduğu yolu verir
        System.out.println(System.getProperty("user.dir"));

        //Localimizdeki kullanıcı yolunu verir
        System.out.println(System.getProperty("user.home"));
        //String dosyaYolu="C:\Users\Türkün Miyase Tura\Desktop\B129.txt";
        String farkliKisim=System.getProperty("user.home");
        String ortakKısım="\\Desktop\\B129.txt";
        String dosyaYolu=farkliKisim+ortakKısım;
        Assert.assertTrue(Files.exists(Paths.get(dosyaYolu)));

    }
}
