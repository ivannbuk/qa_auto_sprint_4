import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class OrderPage {

    private static final By HEADER_BUTTON_ORDER = By.xpath("/html/body/div/div/div[1]/div[1]/div[2]/button[1]"); //Кнопка заказа в хэдере

    private static final By DOWN_BUTTON = By.className("Button_UltraBig__UU3Lp");  //Нижняя кнопка заказа
    private static final By ORDER_NAME = By.xpath("/html/body/div/div/div[2]/div[2]/div[1]/input"); //поле "имя"
    private static final By ORDER_SURNAME = By.xpath("//div[2]/input"); //поле "фамилия"
    private static final By ORDER_ADDRESS = By.xpath("//div[3]/input"); //поле "адрес"
    private static final By ORDER_METRO = By.xpath("/html/body/div/div/div[2]/div[2]/div[4]/div/div/input"); //поле "метро"
    private static final By ORDER_PHONE = By.xpath("//div[5]/input"); //поле "телефон"
    private static final By ORDER_NEXT_PAGE = By.className("Button_Middle__1CSJM"); //кнопка "Далее"
    private static final By ORDER_DATE = By.className("Input_Responsible__1jDKN"); //поле "дата"
    private static final By ORDER_PERIOD = By.className("Dropdown-placeholder"); //поле "периода аренды"
    private static final By BLACK_COLOR_SCOOTER = By.className("Checkbox_Input__14A2w"); //кнопка выбора "черного" самоката
    private static final By GREY_COLOR_SCOOTER = By.id("grey"); //кнопка выбора "серого" самоката
    private static final By ORDER_COMMENT = By.xpath("/html/body/div/div/div[2]/div[2]/div[4]/input"); //поле "комментарий"
    private static final By SUBMIT_ORDER_BUTTON = By.xpath("/html/body/div[1]/div/div[2]/div[3]/button[2]"); //кнопка "оформить заказ"
    private static final By SUBMIT_ORDER_BUTTON_YES = By.xpath("/html/body/div/div/div[2]/div[5]/div[2]/button[2]"); //кнопка подтверждения оформления заказа
    private static final By SUCCESSFUL_ORDER_TEXT = By.xpath("/html/body/div/div/div[2]/div[5]/div[1]"); //Модальное окно с текстом подтверждения

    private final WebDriver driver;

    public OrderPage(WebDriver driver) {
        this.driver = driver;
    }

    //Заполнение первой страницы заказа
    public void enterDataFirstPageOrder(String name, String surname, String address, int metro, String phoneNumber) {
        driver.findElement(HEADER_BUTTON_ORDER).click();
        driver.findElement(ORDER_NAME).sendKeys(name);
        driver.findElement(ORDER_SURNAME).sendKeys(surname);
        driver.findElement(ORDER_ADDRESS).sendKeys(address);
        driver.findElement(ORDER_METRO).click();
        By allMetroStation = By.xpath("/html/body/div/div/div[2]/div[2]/div[4]/div/div[2]/ul/li");
        List<WebElement> elements = driver.findElements(allMetroStation); //список из 255 станций метро
        elements.get(metro - 1).click();
        driver.findElement(ORDER_PHONE).sendKeys(phoneNumber);
        driver.findElement(ORDER_NEXT_PAGE).click();
    }

    public void enterDataSecondPageOrder(String color, String date, int rentalDays, String comment) {
        if ("черный".equals(color)) {
            driver.findElement(BLACK_COLOR_SCOOTER).click();
        }
        if ("серый".equals(color)) {
            driver.findElement(GREY_COLOR_SCOOTER).click();
        }
        driver.findElement(ORDER_DATE).sendKeys(date); //ввод даты в формате "dd.MM.yyyy"
        driver.findElement(ORDER_DATE).sendKeys(Keys.RETURN);
        driver.findElement(ORDER_PERIOD).click();
        By allDayForOrder = By.className("Dropdown-option");
        List<WebElement> elements = driver.findElements(allDayForOrder); //список из 7 дней аренды
        elements.get(rentalDays - 1).click();
        driver.findElement(ORDER_COMMENT).sendKeys(comment);
        driver.findElement(SUBMIT_ORDER_BUTTON).click();
        driver.findElement(SUBMIT_ORDER_BUTTON_YES).click();
    }
    //Подтверждения оформления заказа
    public boolean successfullyText() {
        String successfullOrder = driver.findElement(SUCCESSFUL_ORDER_TEXT).getText();
        return successfullOrder.contains("Заказ оформлен");
    }
}
