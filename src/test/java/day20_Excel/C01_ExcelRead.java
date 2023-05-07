package day20_Excel;

import org.apache.poi.ss.usermodel.*;
import org.junit.Assert;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class C01_ExcelRead {
    @Test
    public void excelReadTest1() throws IOException {
        /*
    Capitals.xlsx dosyasından 1. satır 2. sütundaki hücreyi yazdırın
    3. Satır 1. sütun değerini yazdırın ve "France" olduğunu test edin
    Kullanılan satır sayısın bulun
    Ülke-Başkent şeklinde verileri yazdırın
     */
        //Excel dosyasından bir veri okuyabilmemiz için;
        //1.Dosya yolunu alırız
        String dosyaYolu="src/test/java/resources/Capitals (2).xlsx";
        String dosyaYolu1="C:\\Users\\Türkün Miyase Tura\\Desktop\\Capitals (2).xlsx";//masaüstünden aldık
        //2.Dosyayı okuyabilmek için akışa almam gerekir
        FileInputStream fis=new FileInputStream(dosyaYolu);
        //3.Java ortamında bir excell dosyası oluşturmamız gerekir
        Workbook workbook= WorkbookFactory.create(fis);//create(fis) ile excelde bu dosyayı okuruz
        //4.Okuyacağımız Sayfayı(Sheet) seçmemiz gerekir.
        Sheet sheet=workbook.getSheet("Sheet1");
        //5.Satır(Row)seçmemiz gerekir
        Row row=sheet.getRow(0);//1. satır index 0dan  başladığı için
        //6.Hücreyi(Cell) seçmemiz gerekir
        Cell cell=row.getCell(0);//1. satır index 0dan başladığı için
        System.out.println(cell);


    }

    @Test
    public void readExcelTest2() throws IOException {
        FileInputStream fis=new FileInputStream("src/test/java/resources/Capitals (2).xlsx");
        Workbook workbook=WorkbookFactory.create(fis);
        //1. satır 1. sutundaki bilgiyi yazdırın
        System.out.println(workbook.getSheet("Sheet1").getRow(0).getCell(0));

    }

    @Test
    public void readExcelTest3() throws IOException {

        FileInputStream fis=new FileInputStream("src/test/java/resources/Capitals (2).xlsx");
        Workbook workbook=WorkbookFactory.create(fis);
        // Capitals.xlsx dosyasından 1. satır 2. sütundaki hücreyi yazdırın
        System.out.println(workbook.getSheet("Sheet1").getRow(0).getCell(1));
        //3. Satır 1. sütun değerini yazdırın ve "France" olduğunu test edin
        String satır3sutun1=workbook.getSheet("Sheet1").getRow(2).getCell(0).toString();
        Assert.assertEquals(satır3sutun1,"France");
        //Kullanılan satır sayısın bulun
        System.out.println("son satır sayısı "+workbook.getSheet("Sheet1").getLastRowNum());
        System.out.println("Kullanılan satır sayısı "+workbook.getSheet("Sheet1").getPhysicalNumberOfRows());
        System.out.println("Son Sutun sayısı "+workbook.getSheet("Sheet1").getRow(0).getLastCellNum());
        System.out.println("kullanılan sutun sayısı "+workbook.getSheet("Sheet1").getRow(0).getPhysicalNumberOfCells());
        //Ülke-Başkent şeklinde verileri yazdırın
        Map<String,String> ulkeVeBaskentler=new HashMap<>();
        for (int index = 0; index < workbook.getSheet("Sheet1").getPhysicalNumberOfRows(); index++) {
            String ulke=workbook.getSheet("Sheet1").getRow(index).getCell(0).toString();
            String baskent=workbook.getSheet("Sheet1").getRow(index).getCell(1).toString();
            ulkeVeBaskentler.put(ulke,baskent+"/n");

        }
        System.out.println(ulkeVeBaskentler);



    }

    @Test
    public void readExcelTest4() throws IOException {
        FileInputStream fis=new FileInputStream("src/test/java/resources/Capitals (2).xlsx");
        Workbook workbook=WorkbookFactory.create(fis);
        //Ülke ve başkent şeklinde verileri yazdırın
        for (int index = 0; index <workbook.getSheet("Sheet1").getPhysicalNumberOfRows() ; index++) {
            for (int j = 0; j <workbook.getSheet("Sheet1").getRow(0).getPhysicalNumberOfCells() ; j++) {
                System.out.println(workbook.getSheet("Sheet1").getRow(index).getCell(j)+"/t");


            }
            System.out.println();

        }
    }
}
