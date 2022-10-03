import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
//import org.openqa.selenium.firefox.FirefoxDriver;
import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertEquals;

public class TestQuestion extends GeneralPage{

    private WebDriver driver;

    public TestQuestion(WebDriver driver) {
        super(driver);
    }

    @Before
    public void setUp() {
//        FireFoxOptions options = new FireFoxOptions();
//        options.addArguments("--no-sandbox", "--headless", "--disable-dev-shm-usage");
//        driver = new FirefoxDriver(options);
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--no-sandbox", "--headless", "--disable-dev-shm-usage");
        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(3,
                TimeUnit.SECONDS);
        driver.get("https://qa-scooter.praktikum-services.ru/");
    }

    @Test
    public void checkFirstQuestion() {
        GeneralPage generalPage = new GeneralPage(driver);
        generalPage.scrollMainPageQuestions();
        assertEquals("Сутки — 400 рублей. Оплата курьеру — наличными или картой.",
                generalPage.getAnswer(QUESTION_FIRST));
    }

    @Test
    public void checkSecondQuestion() {
        GeneralPage generalPage = new GeneralPage(driver);
        generalPage.scrollMainPageQuestions();
        assertEquals("Пока что у нас так: один заказ — один самокат. Если хотите покататься с друзьями, " +
                        "можете просто сделать несколько заказов — один за другим.",
                generalPage.getAnswer(QUESTION_SECOND));
    }

    @Test
    public void checkThirdQuestion() {
        GeneralPage generalPage = new GeneralPage(driver);
        generalPage.scrollMainPageQuestions();
        assertEquals("Допустим, вы оформляете заказ на 8 мая. Мы привозим самокат 8 мая в течение дня. " +
                        "Отсчёт времени аренды начинается с момента, когда вы оплатите заказ курьеру. " +
                        "Если мы привезли самокат 8 мая в 20:30, суточная аренда закончится 9 мая в 20:30.",
                generalPage.getAnswer(QUESTION_THIRD));
    }

    @Test
    public void checkFourthQuestion() {
        GeneralPage generalPage = new GeneralPage(driver);
        generalPage.scrollMainPageQuestions();
        assertEquals("Только начиная с завтрашнего дня. Но скоро станем расторопнее.",
                generalPage.getAnswer(QUESTION_FOURTH));
    }

    @Test
    public void checkFifthQuestion() {
        GeneralPage generalPage = new GeneralPage(driver);
        generalPage.scrollMainPageQuestions();
        assertEquals("Пока что нет! Но если что-то срочное — всегда можно позвонить " +
                        "в поддержку по красивому номеру 1010.",
                generalPage.getAnswer(QUESTION_FIFTH));
    }

    @Test
    public void checkSixthQuestion() {
        GeneralPage generalPage = new GeneralPage(driver);
        generalPage.scrollMainPageQuestions();
        assertEquals("Самокат приезжает к вам с полной зарядкой. Этого хватает на восемь суток — " +
                        "даже если будете кататься без передышек и во сне. Зарядка не понадобится.",
                generalPage.getAnswer(QUESTION_SIXTH));
    }

    @Test
    public void checkSeventhQuestion() {
        GeneralPage generalPage = new GeneralPage(driver);
        generalPage.scrollMainPageQuestions();
        assertEquals("Да, пока самокат не привезли. Штрафа не будет, " +
                        "объяснительной записки тоже не попросим. Все же свои.",
                generalPage.getAnswer(QUESTION_SEVENTH));
    }

    @Test
    public void checkEighthQuestion() {
        GeneralPage generalPage = new GeneralPage(driver);
        generalPage.scrollMainPageQuestions();
        assertEquals("Да, обязательно. Всем самокатов! И Москве, и Московской области.",
                generalPage.getAnswer(QUESTION_EIGHT));
    }

    @After
    public void teardown() {
        driver.quit();
    }
}
