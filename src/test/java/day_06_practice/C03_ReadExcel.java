package day_06_practice;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.junit.Assert;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.IOException;

public class C03_ReadExcel {
    // Ulkeler dosyasındaki 3.satırdaki indexin, 3.sutunundaki indexinin
    // "Cezayir" oldugunu test eden method olusturunuz


    @Test
    public void test01() throws IOException {
        int satirNoIdx=3;
        int sutunNoIdx=3;
        String actuelData=banaDataGetir( satirNoIdx, sutunNoIdx);
        Assert.assertEquals("Cezayir",actuelData);
    }
    private String banaDataGetir(int satirNoIdx, int sutunNoIdx) throws IOException {
        String dosyaYolu="src/resorces/ulkelr.xlsx";
        FileInputStream fis=new FileInputStream(dosyaYolu);
        //ülkeler dosyasını bizim sistemimize getirdik
        Workbook workbook= WorkbookFactory.create(fis);
        //dosyayı workbooka atadık
        String istenenData=workbook.getSheet("Sayfa1").getRow(satirNoIdx).getCell(sutunNoIdx).toString();
        return istenenData;
    }
}
