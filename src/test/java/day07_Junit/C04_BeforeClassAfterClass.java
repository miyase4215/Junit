package day07_Junit;

import org.junit.*;

public class C04_BeforeClassAfterClass {
    @BeforeClass
    public static void beforeClass() throws Exception {
        System.out.println("Classtaki tüm testlerden önce bir kez çalışır");
    }

    @AfterClass
    public static void afterClass() throws Exception {
        System.out.println("Classtaki tüm testlerden sonra bir kez çalışır");
    }

    @Before
    public void setUp() throws Exception {
        System.out.println("her test methodundan önce ");
    }

    @After
    public void tearDown() throws Exception {
        System.out.println("her test methodundan sonra ");
    }

    @Test
    public void test01() {
        System.out.println("ilk test");
    }
    @Test
    public void test02() {
        System.out.println("ikinci test");
    }
}
