import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.firefox.FirefoxDriver;
import java.util.concurrent.TimeUnit;

public class TestOrder {

    private WebDriver driver;

    @Before
    public void setUp() {
//        driver = new FirefoxDriver(options);
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(3,
                TimeUnit.SECONDS);
        driver.get("https://qa-scooter.praktikum-services.ru");
    }

    @Test
    public void testOrderScooterOne() {
        OrderPage orderTrue = new OrderPage(driver);
        orderTrue.enterDataFirstPageOrder("Иванов", "Иван", "Калуга", 18, "+79822589698");
        orderTrue.enterDataSecondPageOrder("черный", "04.10.2022", 7, "Оставьте у подъезда");
        Assert.assertTrue(orderTrue.successfullyText());
    }

    @Test
    public void testOrderScooterTwo() {
        OrderPage orderTrue = new OrderPage(driver);
        orderTrue.enterDataFirstPageOrder("Кирилл", "Сарычев", "Москва", 10, "+9211299212");
        orderTrue.enterDataSecondPageOrder("серый", "10.10.2022", 5, "Не оставляйте у подезда!");
        Assert.assertTrue(orderTrue.successfullyText());
    }

    @Test
    public void testOrderScooterThree() {
        OrderPage orderTrue = new OrderPage(driver);
        orderTrue.enterDataFirstPageOrder("Нина", "Абкурова", "Самара", 13, "+71255477898");
        orderTrue.enterDataSecondPageOrder("черный", "12.11.2022", 3, "");
        Assert.assertTrue(orderTrue.successfullyText());
    }

    @After
    public void teardown() {
        driver.quit();
    }
}